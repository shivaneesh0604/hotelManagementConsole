package RestaurentManagementConsole.database;

import java.util.List;

import RestaurentManagementConsole.waiter.Waiter;

public interface WaiterDatabase {
    public void addWaitersToRestaurent(Waiter waiter);

    public void addTableNumbersToWaiters(String tablenumber, Waiter waiter);

    public void deleteTableNumberforWaiter(String tablenumber, Waiter waiter);

    public List<String> returnTableNumbers(int waiterID);
    
}
