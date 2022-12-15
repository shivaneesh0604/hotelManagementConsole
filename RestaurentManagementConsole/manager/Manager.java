package RestaurentManagementConsole.manager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import RestaurentManagementConsole.Person;
import RestaurentManagementConsole.KitchenOrderSystem.Cook;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.database.CustomerDatabase;
import RestaurentManagementConsole.database.DatabaseSystem;
import RestaurentManagementConsole.database.WaiterDatabase;
import RestaurentManagementConsole.database.WorkerDatabase;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.waiter.Waiter;

public class Manager extends Person {
    Scanner sc = new Scanner(System.in);

    private WaiterDatabase waiterDatabase;
    private CustomerDatabase customerDatabase;
    private WorkerDatabase workerDatabase;
    private Menu menu;

    private static final List<String> tableAvailable = Arrays.asList("t1", "t2", "t3", "t4", "t5", "t6");

    public Manager(int manager_id, String name) {
        super(manager_id, name);
        waiterDatabase = new DatabaseSystem();
        customerDatabase = new DatabaseSystem();
        workerDatabase = new DatabaseSystem();
        menu = Menu.getinstance();
    }


    public void addItems(String foodName, int price, String category) {
        Item item = new Item(foodName, price, category);
        menu.addMenusItems(item);
    }

    public void alterfoodprice(String foodname,int price){
        menu.alterMenuItems(foodname,price);
    }

    public void deleteFoodInMenu(String foodname){
        menu.alterMenuItems(foodname);
    }

    public void addTableNumbersToWaiters(Waiter waiter, String addtablenumber1) {
        if (tableAvailable.contains(addtablenumber1)) {
            waiterDatabase.addTableNumbersToWaiters(addtablenumber1, waiter);
        }
        else{
            System.out.println("please enter available table number");
            System.out.println("Available tablenumbers are "+tableAvailable);
        }
    }
    
    public void deleteTableNumberforWaiter(String tablenumber, Waiter waiter) {
        waiterDatabase.deleteTableNumberforWaiter(tablenumber, waiter);
    }

    public void AddWaiterToDB(Waiter waiter) {
        waiterDatabase.addWaitersToDatabase(waiter);
    }

    public void addWorkerToDb(Cook worker){
        workerDatabase.addWorkerToDb(worker);
    }

    public void addCustomerToDB(Customer customer) {
        customerDatabase.addCustomerToDB(customer);
    }
    
    public static List<String> getTableAvailable() {
        return tableAvailable;
    }

}
