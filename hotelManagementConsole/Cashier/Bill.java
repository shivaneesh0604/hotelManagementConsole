package hotelManagementConsole.Cashier;

import java.util.ArrayList;

import hotelManagementConsole.Orders.NewOrder;
import hotelManagementConsole.menu.Item;
import hotelManagementConsole.menu.Menu;
import hotelManagementConsole.menu.UserMenu;

public class Bill {

    private final UserMenu menu;
    private final ArrayList<NewOrder> order;
    private float totalAmount;

    public Bill(ArrayList<NewOrder> order) {
        this.order = order;
        menu = Menu.getinstance();
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
        for (NewOrder newOrder : order) {
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
        totalAmount = totalPrice;
        return totalAmount; 
    }

    public float getTotalAmount() {
        return totalAmount;
    }

}