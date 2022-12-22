package RestaurentManagementConsole.customer;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;

public class Customer {

    private final int id;
    private final String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void entersRestaurent(){
        CustomerUI customerui = new CustomerUI();
        customerui.enterTheRestaurent(this);
    }

    public void enterCustomerUI() {
        CustomerUI2 customerui = new CustomerUI2();
        customerui.entersRestaurent(this);
    }

    public void receiveOrder(ArrayList<Order> order) {
        for (Order orders : order) {
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
