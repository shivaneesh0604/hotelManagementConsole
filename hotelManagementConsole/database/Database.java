package hotelManagementConsole.database;

import java.util.ArrayList;
import java.util.Iterator;

import hotelManagementConsole.KitchenOrderSystem.Cook;
import hotelManagementConsole.KitchenOrderSystem.Chef;
import hotelManagementConsole.customer.Customer;
import hotelManagementConsole.waiter.Waiter;

public class Database {

    private ArrayList<Waiter> waiters = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Cook> worker = new ArrayList<>();

    private Database() {

    }

    private static Database DB = null;

    public static Database getinstanceDatabase() {
        if (DB == null) {
            DB = new Database();
        }
        return DB;
    }

    public void addWaitersToDB(Waiter waiter) {
        waiters.add(waiter);

    }

    public void addTableNumbersToWaiters(String tablenumber, Waiter waiter) {
        boolean Tablecheck = false;
        for (Waiter waiter1 : waiters) {
            if (waiter1.getId() == waiter.getId()) {
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

    public void deleteTableNumberToWaiter(String tablenumber, Waiter waiter) {

        for (Waiter waiter1 : waiters) {
            if (waiter1.getId() == waiter.getId()) {
                Iterator<String> itr = waiter.getTablenumbers().iterator();
                while (itr.hasNext()) {
                    String tablenumber1 = itr.next();
                    if (tablenumber1.equals(tablenumber)) {
                        itr.remove();
                    }
                }
            }
        }
    }

    public void addCustomerToDB(Customer customer) {
        customers.add(customer);
        for (Waiter waiter : waiters) {
            if (waiter.getTablenumbers().contains(customer.getTablenumber())) {
                customer.setWaiter(waiter);
                waiter.assignCustomer(customer);
            }
        }
    }

    public void addWorkerToDb(Cook worker) {
        this.worker.add(worker);
        Chef.getinsttanceChef().addCookToChef(worker);
    }

}
