package RestaurentManagementConsole.Restaurent;

import java.util.List;

import RestaurentManagementConsole.RestaurentApplication.Chef;
import RestaurentManagementConsole.RestaurentApplication.Cook;
import RestaurentManagementConsole.menu.Menu;

public interface ManagerInterface {
    public void addWaitersToRestaurent(Waiter waiter);

    public void addTableNumbersToWaiters(String tablenumber, int waiterid);

    public void deleteTableNumberforWaiter(String tablenumber, int waiterid);

    public List<String> returnTableNumbers(int waiterID);

    public void addWorkerToRestaurent(Cook worker);

    public void addChefToRestaurent(Chef chef);

    public Menu getFullMenu();

}
