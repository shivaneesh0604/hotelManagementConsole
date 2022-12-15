package hotelManagementConsole.database;

import hotelManagementConsole.KitchenOrderSystem.Cook;
import hotelManagementConsole.customer.Customer;
import hotelManagementConsole.waiter.Waiter;

public class DatabaseSystem implements CustomerDatabase,WaiterDatabase,WorkerDatabase {
    
    private final Database database;

    public DatabaseSystem() {
        database=Database.getinstanceDatabase();
    }

    @Override
    public void addWaitersToDatabase(Waiter waiter) {
        database.addWaitersToDB(waiter);
    }

    @Override
    public void addTableNumbersToWaiters(String tablenumber, Waiter waiter) {
        database.addTableNumbersToWaiters(tablenumber, waiter);
    }

    @Override
    public void addCustomerToDB(Customer customer){
        database.addCustomerToDB(customer);
    }

    @Override
    public void deleteTableNumberforWaiter(String tablenumber, Waiter waiter) {
        database.deleteTableNumberToWaiter(tablenumber, waiter);
    }

    @Override
    public void addWorkerToDb(Cook worker) {
        database.addWorkerToDb(worker);
    }

}