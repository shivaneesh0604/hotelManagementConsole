package RestaurentManagementConsole.customer;

import java.util.ArrayList;

// import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.Order;
// import RestaurentManagementConsole.RestaurentApplication.Waiter;
// import RestaurentManagementConsole.menu.UserMenu;

public class Customer {

    private final int id;
    private final String name;
    

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void enterCustomerUI(){
        CustomerUI customerui = new CustomerUI();
        customerui.enterTheRestaurent(this);
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

