package RestaurentManagementConsole.Orders;

import java.util.ArrayList;
import java.util.Iterator;


public class OrderList {

    private int orderId=0;

    private ArrayList<Order> orders = new ArrayList<>();

    public void AddtoOrders(Order order) {
        orders.add(order);
        for (Order order1 : orders) {
            System.out.println(order1.getFoodname());
            System.out.println(order1.getQuantity());
        }
    }

    public void deleteOrder(String foodname, int quantity) {
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            Order order = it.next();
            System.out.println(order.getQuantity());
            System.out.println(quantity);
            if (order.getFoodname().equals(foodname) && order.getQuantity()>=quantity && !order.isDelivered()) {
                if (order.getQuantity() == quantity) {
                    System.out.println(order.getFoodname()+" is totally deleted");
                    it.remove();
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

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setDelivered(Order newOrder) {
        newOrder.setDelivered(true);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id ;
    }

}
