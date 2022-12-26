package RestaurentManagementConsole.Customer;

import java.util.ArrayList;

import RestaurentManagementConsole.User;
import RestaurentManagementConsole.Orders.Order;

public class Customer extends User {

    public Customer(int id, String name) {
        super(id, name);
    }

    // public void entersRestaurent(){
    // CustomerUI customerui = new CustomerUI();
    // customerui.enterTheRestaurent(this);
    // }

    public void receiveOrder(ArrayList<Order> order) {
        for (Order orders : order) {
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }

    @Override
    public void entersUI() {
        CustomerUI2 customerui = new CustomerUI2();
        customerui.entersRestaurent(this);
    }

}
