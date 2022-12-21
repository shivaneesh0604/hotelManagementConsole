package RestaurentManagementConsole.Restaurent;

import java.util.List;

import RestaurentManagementConsole.RestaurentApplication.Waiter;

public interface WaiterData {
    public void addWaitersToRestaurent(Waiter waiter);

    public void addTableNumbersToWaiters(String tablenumber, int waiterid);

    public void deleteTableNumberforWaiter(String tablenumber, int waiterid);

    public List<String> returnTableNumbers(int waiterID);
    
}
