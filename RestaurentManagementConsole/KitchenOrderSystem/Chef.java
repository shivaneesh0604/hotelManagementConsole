package RestaurentManagementConsole.KitchenOrderSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import RestaurentManagementConsole.Orders.NewOrder;
import RestaurentManagementConsole.waiter.Waiter;

public class Chef implements KitchenSystem {

    private final int id;
    private final String name;
    private ArrayList<Cook> cook = new ArrayList<>();
    private HashMap<String, ArrayList<NewOrder>> ordersFromWaiter = new HashMap<>();
    private HashMap<String, Waiter> waiterAck = new HashMap<>();
    private HashMap<String, ArrayList<NewOrder>> PreparedordersFromCook = new HashMap<>();

    private Chef(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static Chef chef = null;

    public static Chef getinsttanceChef() {
        if (chef == null) {
            chef = new Chef(1, "raghu");
        }
        return chef;
    }

    public void addCookToChef(Cook Cook) {
        this.cook.add(Cook);
    }

    @Override
    public void storeOrder(String OrderID, NewOrder order, Waiter waiter) {

        if (ordersFromWaiter.containsKey(OrderID)) {
            ArrayList<NewOrder> order1 = ordersFromWaiter.get(OrderID);
            boolean check = false;
            for (NewOrder orders : order1) {
                if (orders.equals(order)) {
                    System.out.println("already added");
                    check = true;
                    break;
                }
            }
            if (!check) {
                order1.add(order);
                // order1.AddtoOrders(order);
            }

        } else {
            System.out.println("hi");
            ordersFromWaiter.put(OrderID, new ArrayList<NewOrder>());
            ArrayList<NewOrder> order3 = ordersFromWaiter.get(OrderID);
            order3.add(order);
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
            ArrayList<NewOrder> order = ordersFromWaiter.get(orderid);
            for (NewOrder newOrder : order) {
                if (!newOrder.isDelivered() && newOrder.getQuantity() > 0) {
                    NewOrder order3 = cook2.getfoodAndProcess(newOrder, this);
                    order3.setDelivered(true);
                    if (this.PreparedordersFromCook.containsKey(orderid)) {
                        ArrayList<NewOrder> order4 = PreparedordersFromCook.get(orderid);
                        System.out.println("prepared food from Cook");
                        order4.add(order3);
                    } else {
                        PreparedordersFromCook.put(orderid, new ArrayList<NewOrder>());
                        ArrayList<NewOrder> order2 = PreparedordersFromCook.get(orderid);
                        System.out.println("prepared food from Cook are");
                        order2.add(order3);
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
