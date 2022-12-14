package hotelManagementConsole.KitchenOrderSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import hotelManagementConsole.Orders.NewOrder;
import hotelManagementConsole.Orders.Orders;
import hotelManagementConsole.waiter.Waiter;

public class KitchenOrderSystem implements OrderHook {

    private ArrayList<Worker> worker = new ArrayList<>();
    private HashMap<String, Orders> ordersFromWaiter = new HashMap<>();
    private HashMap<String, Waiter> waiterAck = new HashMap<>();
    private HashMap<String, Orders> PreparedordersFromChef = new HashMap<>();

    private KitchenOrderSystem() {

    }

    private static KitchenOrderSystem kitchenOrderManager = null;

    public static KitchenOrderSystem getinsttanceKitchenOrderManager() {
        if (kitchenOrderManager == null) {
            kitchenOrderManager = new KitchenOrderSystem();
        }
        return kitchenOrderManager;
    }

    public void addWorkersToKitchenOrderSystem(Worker worker) {
        this.worker.add(worker);
    }

    @Override
    public void storeOrder(String OrderID, NewOrder order, Waiter waiter) {
        
        if (ordersFromWaiter.containsKey(OrderID)) {
            Orders order1 = ordersFromWaiter.get(OrderID);
            boolean check = false;
            for (NewOrder orders : order1.getOrders()) {
                if (orders.equals(order)) {
                    System.out.println("already added");
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("orders added in kitchen order manager are  ");
                order1.AddtoOrders(order);
            }

        } else {
            Orders order1 = new Orders();
            ordersFromWaiter.put(OrderID, order1);
            Orders order3 = ordersFromWaiter.get(OrderID);
            System.out.println("orders added in kitchen order manager are ->  ");
            order3.AddtoOrders(order);
        }
        if (!waiterAck.containsKey(OrderID)) {
            waiterAck.put(OrderID, waiter);
        }
    }

    public void assignFoodToChefAndReceiveFood(String orderid) {
        Random random = new Random();
        int index = random.nextInt(worker.size());
        Worker chef2 = worker.get(index);
        try {
            Orders order = ordersFromWaiter.get(orderid);
            for (NewOrder newOrder : order.getOrders()) {
                if (!newOrder.isDelivered() && newOrder.getQuantity() > 0) {
                    NewOrder order3 = chef2.getfoodAndProcess(newOrder, this);
                    order3.setDelivered(true);
                    if (this.PreparedordersFromChef.containsKey(orderid)) {
                        Orders order4 = PreparedordersFromChef.get(orderid);
                        System.out.println("prepared food from chef");
                        order4.AddtoOrders(order3);
                    } else {
                        Orders order1 = new Orders();
                        PreparedordersFromChef.put(orderid, order1);
                        Orders order2 = PreparedordersFromChef.get(orderid);
                        System.out.println("prepared food from chef are");
                        order2.AddtoOrders(order3);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("orderid not available");
        }
    }

    public void sendFoodToWaiter(String orderID) {
        Waiter waiterans = waiterAck.get(orderID);
        waiterans.ReceiveOrder(orderID, PreparedordersFromChef.get(orderID));
        ordersFromWaiter.remove(orderID);
        PreparedordersFromChef.remove(orderID);
    }

    public HashMap<String, Orders> getOrders() {
        return ordersFromWaiter;
    }
}
