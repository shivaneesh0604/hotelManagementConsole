package RestaurentManagementConsole.Orders;

import java.util.ArrayList;
import java.util.Iterator;


public class Orders {

    private String orderId;

    private ArrayList<NewOrder> orders = new ArrayList<>();

    public void AddtoOrders(NewOrder order) {
        orders.add(order);
        for (NewOrder order1 : orders) {
            System.out.println(order1.getFoodname());
            System.out.println(order1.getQuantity());
        }
    }

    public boolean CheckAvailability(String foodName) {
        for (NewOrder order : orders) {
            if (order.getFoodname().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteOrder(String foodname, int quantity) {
        Iterator<NewOrder> it = orders.iterator();
        while (it.hasNext()) {
            NewOrder order = it.next();
            System.out.println(order.getQuantity());
            System.out.println(quantity);
            if (order.getFoodname().equals(foodname) && order.getQuantity()>=quantity && !order.isDelivered()) {
                if (order.getQuantity() == quantity) {
                    System.out.println(order.getFoodname()+" is totally deleted");
                    it.remove();
                    order.setQuantity(0);
                    break;
                } else if (order.getQuantity() > quantity) {
                    order.setQuantity(order.getQuantity() - quantity);
                    System.out.println(
                            "Changed order is " + order.getFoodname() + " with the quantity " + order.getQuantity());
                            break;
                } else if (order.getQuantity() < quantity) {
                    System.out
                            .println("Your order is not compatible to change please enter value on or below "
                                    + order.getQuantity()+" to delete");
                                    break;
                }
            }
        }
    }

    public ArrayList<NewOrder> getOrders() {
        return orders;
    }

    public void setDelivered(NewOrder newOrder) {
        newOrder.setDelivered(true);
    }

    public String getOrderId() {
        return orderId;
    }

    public String setOrderId(int id, String name) {
        this.orderId = id + name;
        return orderId;
    }

}
