package RestaurentManagementConsole.database;

import RestaurentManagementConsole.waiter.Waiter;

public interface WaiterDatabase {
    public void addWaitersToDatabase(Waiter waiter);

    public void addTableNumbersToWaiters(String tablenumber, Waiter waiter);

    public void deleteTableNumberforWaiter(String tablenumber, Waiter waiter);
}
