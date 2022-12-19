package RestaurentManagementConsole;

import java.util.Scanner;

import RestaurentManagementConsole.KitchenOrderSystem.Chef;
import RestaurentManagementConsole.KitchenOrderSystem.Cook;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.manager.*;
import RestaurentManagementConsole.waiter.Waiter;

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

        m1.addTableNumbersToWaiters(w1,addtablenumber1);

        System.out.println("enter tablenumber to add");
        String addtablenumber2 = sc.nextLine();
        m1.addTableNumbersToWaiters(w1,addtablenumber2);
        
        System.out.println("enter number to delete");
        String tablenumber1 = sc.nextLine();
        m1.deleteTableNumberforWaiter(tablenumber1, w1);
        System.out.println(w1.getTablenumbers()); 

        Waiter w2 = new Waiter(2, "ram");
        m1.AddWaiterToDB(w2);

        System.out.println("enter tablenumber to add");
        String addtablenumber3 = sc.nextLine();
        m1.addTableNumbersToWaiters(w2,addtablenumber3);

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

            System.out.println("available places are t1-t6");
            System.out.println("please enter which place you are going to sit");
            String tablenumber = sc.nextLine();
            c1.setTablenumber(tablenumber);
            m1.addCustomerToDB(c1);

            c1.askMenu();
            System.out.println("enter food name ");
            String foodname = sc.nextLine();
            System.out.println("enter the quantity");
            int quantity = sc.nextInt();
            c1.addOrders(foodname, quantity);
            c1.confirmOrder();
            System.out.println(c1.getName()+" has -> waiter name " + c1.getWaiter().getName());

            System.out.println("enter food name ");
            sc.nextLine();
            String foodname7 = sc.nextLine();
            System.out.println("enter the quantity");
            int quantity7 = sc.nextInt();
            c1.addOrders(foodname7, quantity7);
            c1.confirmOrder();

            System.out.println("enter food name to delete");
            sc.nextLine();
            String foodname8 = sc.nextLine();
            System.out.println("enter the quantity");
            int quantity8 = sc.nextInt();
            c1.DeleteOrder(foodname8, quantity8);
                        
            Cook worker1 = new Cook(1, "banu", "banu111", "banu111");
            m1.addWorkerToDb(worker1);
            Cook worker2 = new Cook(2, "arul", "arul111", "arul111");
            m1.addWorkerToDb(worker2);
            System.out.println("enter order id to process");
            sc.nextLine();
            String orderid = sc.nextLine();
            k1.assignFoodToCookAndReceiveFood(orderid);
            k1.sendFoodToWaiter(orderid);
            
            // System.out.println("enter food name");
            // String foodname9 = sc.nextLine();
            // System.out.println("enter the quantity");
            // int quantity9 = sc.nextInt();
            // c1.addOrders(foodname9, quantity9);
            // c1.confirmOrder();
            
            // System.out.println("enter foodname to delte 2");
            // sc.nextLine();
            // String foodname10 = sc.nextLine();
            // System.out.println("enter quantoty to delete");
            // int quantity10 = sc.nextInt();
            // c1.DeleteOrder(foodname10, quantity10);
            
            // System.out.println("enter order id to process");
            // sc.nextLine();
            // String orderid1 = sc.nextLine();
            // k1.assignFoodToChefAndReceiveFood(orderid1);
            // k1.sendFoodToWaiter(orderid1);

            c1.askBill();
            System.out.println("enter the amount to be paid");
            float amounttobepaid = sc.nextFloat();
            c1.payBill(amounttobepaid);
            Customer c2 = new Customer(2, "harsha");
            System.out.println("available places are t1-t6");
            System.out.println("please enter which place you are going to sit");
            sc.nextLine();
            String tablenumber2 = sc.nextLine();
            c2.setTablenumber(tablenumber2);
            m1.addCustomerToDB(c2);

            c2.askMenu();
            System.out.println("enter food name ");
            String foodnamee = sc.nextLine();
            System.out.println("enter the quantity");
            int quantityy = sc.nextInt();
            c2.addOrders(foodnamee, quantityy);
            c2.confirmOrder();
            System.out.println(c2.getName()+" has -> waiter name is " + c2.getWaiter().getName());

            System.out.println("enter order id to process");
            sc.nextLine();
            String orderid2 = sc.nextLine();
            k1.assignFoodToCookAndReceiveFood(orderid2);
            k1.sendFoodToWaiter(orderid2);
            c2.askBill();
            System.out.println("enter the amount to be paid");
            float amounttobepaid1 = sc.nextFloat();
            c1.payBill(amounttobepaid1);
            break;
        }

            
            sc.close();
    }
}


//orders gets clubed with old order -> addcount is happenening and we are passing that order to storeorder function so it clubs up! 

// orderHook.deleteOrder(foodName, quantity, customer.getOrderID());

//remove total item is not working