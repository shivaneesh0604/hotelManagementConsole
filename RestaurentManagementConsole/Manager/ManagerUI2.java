package RestaurentManagementConsole.Manager;

import RestaurentManagementConsole.KitchenManagers.Chef;
import RestaurentManagementConsole.KitchenManagers.Cook;
import RestaurentManagementConsole.Restaurent.ManagerInterface;
import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.Restaurent.Waiter;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.menu.Starter;

public class ManagerUI2 {
    private ManagerInterface managerInterface = Restaurent.getInstanceRestaurent();

    public void managerinterface() {
        Waiter w1 = new Waiter(5, "rajagopal");
        managerInterface.addWaitersToRestaurent(w1);
        managerInterface.addTableNumbersToWaiters("t5", 5);
        managerInterface.addTableNumbersToWaiters("t6", 5);
        managerInterface.deleteTableNumberforWaiter("t5", 5);

        Cook cook = new Cook(5, "vishnu");
        managerInterface.addWorkerToRestaurent(cook);

        Chef chef = new Chef(5, "sure");
        managerInterface.addChefToRestaurent(chef);
        
        Menu menu = managerInterface.getFullMenu();
        menu.showMenu();
        Item item = new Item("parotta", 15,
                RestaurentManagementConsole.menu.Classificaton.VEG, Starter.NOTSTARTER);
        menu.addMenusItems(item);

        menu.alterMenuItems("parotta", 10);
        menu.alterMenuItems("DOSA", 20);

        menu.deleteMenuItems("DOSA");


    }
}
