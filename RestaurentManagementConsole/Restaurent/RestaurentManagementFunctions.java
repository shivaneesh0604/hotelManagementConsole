package RestaurentManagementConsole.Restaurent;

import java.util.List;

import RestaurentManagementConsole.KitchenManagers.Chef;
import RestaurentManagementConsole.KitchenManagers.Cook;
import RestaurentManagementConsole.menu.Menu;

public interface RestaurentManagementFunctions {
    public void addWaitersToRestaurent(Waiter waiter);

    public void addTableNumbersToWaiters(String tablenumber, int waiterid);

    public void deleteTableNumberforWaiter(String tablenumber, int waiterid);

    public List<String> returnTableNumbers(int waiterID);

    public void addWorkerToRestaurent(Cook worker);

    public void addChefToRestaurent(Chef chef);

    public Menu getFullMenu();

}
