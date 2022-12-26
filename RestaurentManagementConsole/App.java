package RestaurentManagementConsole;

import RestaurentManagementConsole.Customer.Customer;
import RestaurentManagementConsole.Manager.Manager;
import RestaurentManagementConsole.Restaurent.Restaurent;

public class App {
    public static void main(String[] args) {
        Restaurent.getInstanceRestaurent().addRestaurentMandatoryItemspeople();
        User m1 = new Manager(1, "ram");
        
        m1.entersUI();

        while (true) {
            System.out.println("------------");
            System.out.println("------------");
            System.out.println("Welcome to the Restaurent");
            System.out.println("------------");
            System.out.println("------------");

            User c1 = new Customer(1, "mani");
            System.out.println("Customer 1->" + c1.getName());


            c1.entersUI();

            
            break;
        }

    }
}

// orders gets clubed with old order -> addcount is happenening and we are
// passing that order to storeorder function so it clubs up!

// orderHook.deleteOrder(foodName, quantity, customer.getOrderID());

// remove total item is not working