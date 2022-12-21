package RestaurentManagementConsole.RestaurentApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import RestaurentManagementConsole.Manager.CustomerData;
import RestaurentManagementConsole.Manager.WaiterData;
import RestaurentManagementConsole.Manager.WorkerData;
import RestaurentManagementConsole.Orders.OrderList;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.menu.Category;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;

public class Restaurent implements CustomerData, WaiterData, WorkerData, Serve {

    private ArrayList<Waiter> waiters = new ArrayList<Waiter>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Cook> workers = new ArrayList<Cook>();

    private ArrayList<Chef> chefs = new ArrayList<Chef>();
    private Menu menu = Menu.getinstance();

    private Restaurent() {
        waiters.add(new Waiter(1, "shiva"));
        waiters.add(new Waiter(2, "sankar"));
        waiters.add(new Waiter(1, "sathya"));
        workers.add(new Cook(1, "naveen"));
        workers.add(new Cook(2, "milky"));
        chefs.add(new Chef(1, "raju"));
        chefs.add(new Chef(1, "ramu"));
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

    @Override
    public void addTableNumbersToWaiters(String tablenumber, int waiterid) {
        boolean Tablecheck = false;
        for (Waiter waiter1 : waiters) {
            if (waiter1.getId() == waiterid) {
                for (Waiter waiter2 : waiters) {
                    if (waiter2.getTablenumbers().contains(tablenumber)) {
                        Tablecheck = true;
                        break;
                    }
                }
                if (Tablecheck) {
                    System.out.println("Table number already added to another waiter so can't add");
                } else {
                    waiter1.setTableNumber(tablenumber);
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
    public Waiter returnWaiter(int orderid) {
        for (Waiter waiter : waiters) {
            Collection<OrderList> orders = waiter.getOrders().values();
            for (OrderList order : orders) {
                if (order.getOrderId() == orderid) {
                    return waiter;
                }
            }
        }
        return null;
    }

    @Override
    public Customer returnCustomer(int waiterid) {
        // for (Customer customer : customers) {
        // if (customer.getWaiter().getId() == waiterid) {
        // return customer;
        // }
        // }
        return null;
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
