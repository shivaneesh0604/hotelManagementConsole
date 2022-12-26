package RestaurentManagementConsole.Customer;

import java.util.ArrayList;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.RestaurentPublicFunctions;
import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.Restaurent.Waiter;
import RestaurentManagementConsole.menu.UserMenu;

public class CustomerUI2 {
    private RestaurentPublicFunctions RestaurentPublicFunctions = Restaurent.getInstanceRestaurent();

    public void entersRestaurent(int customerid) {
        Waiter waiter = RestaurentPublicFunctions.getIN("t1",customerid);
        UserMenu menu = waiter.providesMenu();
        menu.showMenu();
        System.out.println("for ordering the food");
        waiter.TakeNewOrder(customerid, "GrillChicken", 2);
        waiter.TakeNewOrder(customerid, "GrillChicken", 2);
        
        System.out.println("food to delete");
        waiter.DeleteOrder(customerid, "GrillChicken", 2);
        waiter.DeleteOrder(customerid, "GrillChicken", 1);

        System.out.println("receive order ");
        ArrayList<Order> orders = waiter.processOrder(customerid);

        receiveOrder(orders);

        System.out.println("bill payment process ");
        Bill bill = waiter.askbill(customerid);
        bill.ReadBill();
        waiter.paybill(30, customerid);

    }
    private void receiveOrder(ArrayList<Order> order) {
        for (Order orders : order) {
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }
}
