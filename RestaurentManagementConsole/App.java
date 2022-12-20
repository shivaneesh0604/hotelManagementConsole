package RestaurentManagementConsole;

import java.util.Scanner;

import RestaurentManagementConsole.RestaurentApplication.Chef;
import RestaurentManagementConsole.RestaurentApplication.Cook;
import RestaurentManagementConsole.RestaurentApplication.Manager;
import RestaurentManagementConsole.RestaurentApplication.Waiter;
import RestaurentManagementConsole.customer.Customer;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Manager m1 = new Manager(1, "ram");

        Chef k1 = Chef.getInstanceChef();
        System.out.println("------------");
        
        Waiter w1 = new Waiter(1, "raj");
        m1.AddWaiterToDB(w1);
        System.out.println("enter tablenumber to add");
        String addtablenumber1 = sc.nextLine();

        m1.addTableNumbersToWaiters(1,addtablenumber1);

        System.out.println("enter tablenumber to add");
        String addtablenumber2 = sc.nextLine();
        m1.addTableNumbersToWaiters(1,addtablenumber2);
        
        System.out.println("enter number to delete");
        String tablenumber1 = sc.nextLine();
        m1.deleteTableNumberforWaiter(tablenumber1, 1);

        Waiter w2 = new Waiter(2, "ram");
        m1.AddWaiterToDB(w2);

        System.out.println("enter tablenumber to add");
        String addtablenumber3 = sc.nextLine();
        m1.addTableNumbersToWaiters(2,addtablenumber3);

        m1.addItems("Rice", 100,1);
        m1.addItems("ChickenFriedRice", 200,2);
        m1.addItems("MutttonChucka", 200,2);
        m1.addItems("ChickenChucka", 120,2);
        m1.addItems("Parrota", 15,2 );

        m1.alterfoodprice("Rice", 90);
        m1.deleteFoodInMenu("ChickenChucka");

        while (true) {
            System.out.println("------------");
            System.out.println("------------");
            System.out.println("Welcome to the Restaurent");
            System.out.println("------------");
            System.out.println("------------");

            Customer c1 = new Customer(1, "mani");
            System.out.println("Customer 1->" + c1.getName());

            c1.enterCustomerUI();
                        
            Cook worker1 = new Cook(1, "banu", "banu111", "banu111");
            m1.addWorkerToDb(worker1);
            Cook worker2 = new Cook(2, "arul", "arul111", "arul111");
            m1.addWorkerToDb(worker2);
            System.out.println("enter order id to process");
            sc.nextLine();
            int orderid = sc.nextInt();
            k1.assignFoodToCookAndReceiveFood(orderid);
            k1.sendFoodToWaiter(orderid);
            break;
        }

            
            sc.close();
    }
}


//orders gets clubed with old order -> addcount is happenening and we are passing that order to storeorder function so it clubs up! 

// orderHook.deleteOrder(foodName, quantity, customer.getOrderID());

//remove total item is not working