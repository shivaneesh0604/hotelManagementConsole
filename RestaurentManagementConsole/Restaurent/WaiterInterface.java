package RestaurentManagementConsole.Restaurent;

import RestaurentManagementConsole.Cashier.Cashier;
import RestaurentManagementConsole.menu.UserMenu;

public interface WaiterInterface {
    public UserMenu getUserMenu();
    public Cashier returnCashier();
}
