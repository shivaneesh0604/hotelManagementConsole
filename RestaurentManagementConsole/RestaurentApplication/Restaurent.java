package RestaurentManagementConsole.RestaurentApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import RestaurentManagementConsole.KitchenOrderSystem.Chef;
import RestaurentManagementConsole.KitchenOrderSystem.Cook;
import RestaurentManagementConsole.Orders.OrderList;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.waiter.Waiter;

public class Restaurent implements CustomerData, WaiterData, WorkerData, Serve {

    private ArrayList<Waiter> waiters = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Cook> worker = new ArrayList<>();

    private Restaurent() {

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
        for (Waiter waiter : waiters) {
            if (waiter.getTablenumbers().contains(customer.getTablenumber())) {
                customer.setWaiter(waiter);
                waiter.assignCustomer(customer.getId());
            }
        }
    }

    @Override
    public void addWorkerToRestaurent(Cook worker) {
        this.worker.add(worker);
        Chef.getInstanceChef().addCookToChef(worker);
    }

    @Override
    public void addWaitersToRestaurent(Waiter waiter) {
        waiters.add(waiter);
    }

    @Override
    public Waiter returnWaiter(String orderid) {
        for (Waiter waiter : waiters) {
            Collection<OrderList> orders = waiter.getOrders().values();
            for (OrderList order : orders) {
                if (order.getOrderId().equals(orderid)) {
                    return waiter;
                }
            }
        }
        return null;
    }

    @Override
    public Customer returnCustomer(int waiterid) {
        for (Customer customer : customers) {
            if (customer.getWaiter().getId() == waiterid) {
                return customer;
            }
        }
        return null;
    }

}
