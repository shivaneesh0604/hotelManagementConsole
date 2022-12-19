package RestaurentManagementConsole.manager;

import java.util.Arrays;
import java.util.List;

import RestaurentManagementConsole.KitchenOrderSystem.Cook;
import RestaurentManagementConsole.Restaurent.MenuRoles;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.database.CustomerDatabase;
import RestaurentManagementConsole.database.Restaurent;
import RestaurentManagementConsole.database.WaiterDatabase;
import RestaurentManagementConsole.database.WorkerDatabase;
import RestaurentManagementConsole.menu.Category;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.waiter.Waiter;

public class Manager {

    private final int id;
    private final String name;
    private WaiterDatabase waiterDatabase;
    private CustomerDatabase customerDatabase;
    private WorkerDatabase workerDatabase;
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

    public void addTableNumbersToWaiters(Waiter waiter, String addtablenumber1) {
        if (tableAvailable.contains(addtablenumber1)) {
            waiterDatabase.addTableNumbersToWaiters(addtablenumber1, waiter);
        } else {
            System.out.println("please enter available table number");
            System.out.println("Available tablenumbers are " + tableAvailable);
        }
    }

    public void deleteTableNumberforWaiter(String tablenumber, Waiter waiter) {
        waiterDatabase.deleteTableNumberforWaiter(tablenumber, waiter);
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
