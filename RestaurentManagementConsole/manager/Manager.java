package RestaurentManagementConsole.manager;

import java.util.Arrays;
import java.util.List;

import RestaurentManagementConsole.KitchenOrderSystem.Cook;
import RestaurentManagementConsole.Restaurent.MenuRoles;
import RestaurentManagementConsole.RestaurentApplication.CustomerData;
import RestaurentManagementConsole.RestaurentApplication.Restaurent;
import RestaurentManagementConsole.RestaurentApplication.WaiterData;
import RestaurentManagementConsole.RestaurentApplication.WorkerData;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.menu.Category;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.waiter.Waiter;

public class Manager {

    private final int id;
    private final String name;
    private WaiterData waiterDatabase;
    private CustomerData customerDatabase;
    private WorkerData workerDatabase;
    private Menu menu;
    private final MenuRoles role;

    private static final List<String> tableAvailable = Arrays.asList("t1", "t2", "t3", "t4", "t5", "t6");

    public Manager(int manager_id, String name) {
        this.id = manager_id;
        this.name = name;
        this.role = MenuRoles.MENU_EDITOR;
        waiterDatabase = Restaurent.getInstanceRestaurent();
        customerDatabase = Restaurent.getInstanceRestaurent();
        workerDatabase = Restaurent.getInstanceRestaurent();
        menu = Menu.getinstance();
    }

    public void addItems(String foodName, int price, int category) {
        Item item = new Item(foodName, price, Category.contains(category));
        menu.addMenusItems(item);

    }
               
    public void alterfoodprice(String foodname, int price) {
        menu.alterMenuItems(foodname, price);
    }

    public void deleteFoodInMenu(String foodname) {
        menu.deleteMenuItems(foodname);
    }

    public void addTableNumbersToWaiters(int waiterid, String addtablenumber1) {
        if (tableAvailable.contains(addtablenumber1)) {
            System.out.println(waiterDatabase.returnTableNumbers(waiterid)); 
            waiterDatabase.addTableNumbersToWaiters(addtablenumber1, waiterid);
        } else {
            System.out.println("please enter available table number");
            System.out.println("Available tablenumbers are " + tableAvailable);
        }
    }

    public void deleteTableNumberforWaiter(String tablenumber, int waiterid) {
        if (tableAvailable.contains(tablenumber)) {
            System.out.println(waiterDatabase.returnTableNumbers(waiterid)); 
            waiterDatabase.deleteTableNumberforWaiter(tablenumber, waiterid);
        } else {
            System.out.println("please enter available table number");
            System.out.println("Available tablenumbers are " + tableAvailable);
        }
    }

    public void AddWaiterToDB(Waiter waiter) {
        waiterDatabase.addWaitersToRestaurent(waiter);
    }

    public void addWorkerToDb(Cook worker) {
        workerDatabase.addWorkerToRestaurent(worker);
    }

    public void addCustomerToDB(Customer customer) {
        customerDatabase.addCustomerToRestaurent(customer);
    }

    public static List<String> getTableAvailable() {
        return tableAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MenuRoles getRole() {
        return role;
    }

}
