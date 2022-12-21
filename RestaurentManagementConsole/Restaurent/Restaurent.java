package RestaurentManagementConsole.Restaurent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import RestaurentManagementConsole.RestaurentApplication.Chef;
import RestaurentManagementConsole.RestaurentApplication.Cook;
import RestaurentManagementConsole.RestaurentApplication.Waiter;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.menu.Category;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;

public class Restaurent implements CustomerData, WaiterData, WorkerData {

    private ArrayList<Waiter> waiters = new ArrayList<Waiter>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Cook> workers = new ArrayList<Cook>();
    private ArrayList<Chef> chefs = new ArrayList<Chef>();
    private Menu menu = Menu.getinstance();

    private Restaurent() {
        waiters.add(new Waiter(1, "shiva"));
        waiters.add(new Waiter(2, "sankar"));
        waiters.add(new Waiter(1, "sathya"));
        chefs.add(new Chef(1, "raju"));
        chefs.add(new Chef(1, "ramu"));
        Cook cook1 = new Cook(1, "naveen");
        addWorkerToRestaurent(cook1);
        Cook cook2 = new Cook(2, "milky");
        addWorkerToRestaurent(cook2); 
        menu.addMenusItems(new Item("DOSA", 30, Category.VEG));
        menu.addMenusItems(new Item("chicken", 100, Category.NONVEG));
    }

    private static Restaurent restaurent = null;

    public static Restaurent getInstanceRestaurent() {
        if (restaurent == null) {
            restaurent = new Restaurent();
        }
        return restaurent;
    }

    @Override
    public List<String> returnTableNumbers(int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiterid == waiter1.getId()) {
                return waiter1.getTablenumbers();
            }
        }
        return null;
    }

    private boolean checkTableNumbersForAllWaiters(String tableNumber) {
        for (Waiter waiters : waiters) {
            if (waiters.getTablenumbers().contains(tableNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addTableNumbersToWaiters(String tablenumber, int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiter1.getId() == waiterid) {

                boolean check = checkTableNumbersForAllWaiters(tablenumber);
                if (check) {
                    System.out.println("Table number already added to another waiter so can't add");
                    break;
                } else {
                    waiter1.setTableNumber(tablenumber);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteTableNumberforWaiter(String tablenumber, int waiterid) {

        for (Waiter waiter1 : waiters) {
            if (waiter1.getId() == waiterid) {
                Iterator<String> itr = waiter1.getTablenumbers().iterator();
                while (itr.hasNext()) {
                    String tablenumber1 = itr.next();
                    if (tablenumber1.equals(tablenumber)) {
                        itr.remove();
                    }
                }
            }
        }
    }

    @Override
    public void addCustomerToRestaurent(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void addWorkerToRestaurent(Cook cook) {
        this.workers.add(cook);
        for (Chef chef : chefs) {
            chef.addCookToChef(cook);
        }
    }

    @Override
    public void addWaitersToRestaurent(Waiter waiter) {
        waiters.add(waiter);
    }

    @Override
    public void addChefToRestaurent(Chef chef) {
        chefs.add(chef);
    }

    @Override
    public Waiter getWaiter(String TableNumber, int customerid) {
        for (Waiter waiter : waiters) {
            if (waiter.getTablenumbers().contains(TableNumber)) {
                waiter.assignCustomer(customerid);
                return waiter;
            }
        }
        return null;
    }

    public Chef getrandomChef() {
        Random rand = new Random();
        return chefs.get(rand.nextInt(chefs.size()));
    }

}
