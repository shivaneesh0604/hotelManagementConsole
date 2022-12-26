package RestaurentManagementConsole.Cashier;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.menu.Item;

public class Bill {

    private final ArrayList<Item> menuItems = Restaurent.getInstanceRestaurent().getMenuItems();
    private final ArrayList<Order> orders;
    private float totalAmount;

    public Bill(ArrayList<Order> order, int orderid) {
        this.orders = order;
    }

    public float ReadBill() {
        System.out.format(
                "-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProductName\t\tQuantity\t\tRate \t\t\tTotal Price\n");
        System.out.format(
                "-----------------------------------------------------------------------------------------------------------------------------------\n");
        int totalPrice = 0;
        int price = 0;
        // String Bill = "";
        for (Order newOrder : orders) {
            for (Item item : menuItems) {
                if (item.getFoodName().equals(newOrder.getFoodname())) {
                    price = item.getPrice() * newOrder.getQuantity();
                    System.out.format("  %-9s             %-9d          %5d               %9d\n",
                            newOrder.getFoodname(),
                            newOrder.getQuantity(), item.getPrice(), price);
                    totalPrice += price;
                }
            }
        }
        System.out.println("total price is " + totalPrice);
        System.out.println("\n");
        totalAmount = totalPrice;
        return totalAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}