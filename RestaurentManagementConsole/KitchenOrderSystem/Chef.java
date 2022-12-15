package RestaurentManagementConsole.KitchenOrderSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import RestaurentManagementConsole.Person;
import RestaurentManagementConsole.Orders.NewOrder;
import RestaurentManagementConsole.Orders.Orders;
import RestaurentManagementConsole.waiter.Waiter;

public class Chef extends Person implements KitchenSystem  {

    private ArrayList<Cook> cook = new ArrayList<>();
    private HashMap<String, Orders> ordersFromWaiter = new HashMap<>();
    private HashMap<String, Waiter> waiterAck = new HashMap<>();
    private HashMap<String, Orders> PreparedordersFromCook = new HashMap<>();

    private Chef(int id,String name) {
        super(id, name);
    }

    private static Chef chef = null;

    public static Chef getinsttanceChef() {
        if (chef == null) {
            chef = new Chef(1,"raghu");
        }
        return chef;
    }

    public void addCookToChef(Cook Cook) {
        this.cook.add(Cook);
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

    public void assignFoodToCookAndReceiveFood(String orderid) {
        Random random = new Random();
        int index = random.nextInt(cook.size());
        Cook cook2 = cook.get(index);
        try {
            Orders order = ordersFromWaiter.get(orderid);
            for (NewOrder newOrder : order.getOrders()) {
                if (!newOrder.isDelivered() && newOrder.getQuantity() > 0) {
                    NewOrder order3 = cook2.getfoodAndProcess(newOrder, this);
                    order3.setDelivered(true);
                    if (this.PreparedordersFromCook.containsKey(orderid)) {
                        Orders order4 = PreparedordersFromCook.get(orderid);
                        System.out.println("prepared food from Cook");
                        order4.AddtoOrders(order3);
                    } else {
                        Orders order1 = new Orders();
                        PreparedordersFromCook.put(orderid, order1);
                        Orders order2 = PreparedordersFromCook.get(orderid);
                        System.out.println("prepared food from Cook are");
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
        waiterans.ReceiveOrder(orderID, PreparedordersFromCook.get(orderID));
        ordersFromWaiter.remove(orderID);
        PreparedordersFromCook.remove(orderID);   
    }
}
