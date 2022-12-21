package RestaurentManagementConsole;

import RestaurentManagementConsole.Manager.Manager;
import RestaurentManagementConsole.customer.Customer;

public class App {
    public static void main(String[] args) {
        Manager m1 = new Manager(1, "ram");

        m1.enterManagerUI();

        while (true) {
            System.out.println("------------");
            System.out.println("------------");
            System.out.println("Welcome to the Restaurent");
            System.out.println("------------");
            System.out.println("------------");

            Customer c1 = new Customer(1, "mani");
            System.out.println("Customer 1->" + c1.getName());

            c1.enterCustomerUI();

            
            break;
        }

    }
}

// orders gets clubed with old order -> addcount is happenening and we are
// passing that order to storeorder function so it clubs up!

// orderHook.deleteOrder(foodName, quantity, customer.getOrderID());

// remove total item is not working