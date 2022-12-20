package RestaurentManagementConsole.Cashier;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.menu.UserMenu;

public class Bill {

    private final UserMenu menu;
    private final ArrayList<Order> order;
    private final int orderid;
    private float totalAmount;

    public Bill(ArrayList<Order> order,int orderid) {
        this.order = order;
        this.orderid = orderid;
        menu = Menu.getinstance();
    }

    public float ReadBill() {
        System.out.println("\norder id is "+orderid);
        System.out.format(
                "-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProductName\t\tQuantity\t\tRate \t\t\tTotal Price\n");
        System.out.format(
                "-----------------------------------------------------------------------------------------------------------------------------------\n");
        int totalPrice = 0;
        int price = 0;
        // String Bill = "";
        for (Order newOrder : order) {
            for (Item item : menu.getMenuList()) {
                if (item.getFoodName().equals(newOrder.getFoodname())) {
                    price = item.getPrice() * newOrder.getQuantity();
                    System.out.format("  %-9s             %-9d          %5d               %9d\n", newOrder.getFoodname(),
                            newOrder.getQuantity(), item.getPrice(), price);
                    totalPrice += price;
                }
            }
        }
        System.out.println("total price is "+totalPrice);
        System.out.println("\n");
        totalAmount = totalPrice;
        return totalAmount; 
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

}