package RestaurentManagementConsole.Restaurent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import RestaurentManagementConsole.Cashier.Cashier;
import RestaurentManagementConsole.KitchenManagers.Chef;
import RestaurentManagementConsole.KitchenManagers.Cook;
import RestaurentManagementConsole.menu.Classificaton;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.menu.Starter;
import RestaurentManagementConsole.menu.UserMenu;

public class Restaurent implements RestaurentPublicFunctions, ManagerInterface, WaiterInterface, KitchenSystemInterface,
        CashierInterface, ChefInterface {

    private ArrayList<Waiter> waiters = new ArrayList<Waiter>();
    private ArrayList<Cook> cooks = new ArrayList<Cook>();
    private ArrayList<Chef> chefs = new ArrayList<Chef>();
    private Cashier cashier;
    private Menu menu = Menu.getinstance();

    private Restaurent() {

    }

    private static Restaurent restaurent = null;

    public static Restaurent getInstanceRestaurent() {
        if (restaurent == null) {
            restaurent = new Restaurent();
        }
        return restaurent;
    }

    public void addRestaurentMandatoryItemspeople() {
        Waiter waiter1 = new Waiter(1, "shiva");
        waiter1.setTableNumber("t1");
        waiters.add(waiter1);

        Waiter waiter2 = new Waiter(2, "sankar");
        waiter2.setTableNumber("t2");
        waiters.add(waiter2);

        Waiter waiter3 = new Waiter(1, "sathya");
        waiter2.setTableNumber("t3");
        waiters.add(waiter3);
        chefs.add(new Chef(1, "raju"));
        chefs.add(new Chef(1, "ramu"));
        cashier = Cashier.getInstance();
        Cook cook1 = new Cook(1, "naveen");
        addWorkerToRestaurent(cook1);
        Cook cook2 = new Cook(2, "milky");
        addWorkerToRestaurent(cook2);
        menu.addMenusItems(new Item("DOSA", 30, Classificaton.VEG, Starter.NOTSTARTER));
        menu.addMenusItems(new Item("ChickenFriedRice", 100, Classificaton.NONVEG, Starter.NOTSTARTER));
        menu.addMenusItems(new Item("GrillChicken", 300, Classificaton.NONVEG, Starter.STARTER));
        menu.addMenusItems(new Item("Panner Tikka", 130, Classificaton.VEG, Starter.STARTER));
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

    private boolean checkTableNumbersForAllWaiters(String tableNumber) {
        for (Waiter waiters : waiters) {
            if (waiters.getTablenumbers().contains(tableNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addTableNumbersToWaiters(String tablenumber, int waiterid) {
        for (Waiter waiter1 : waiters) {
            if (waiter1.getId() == waiterid) {
                boolean check = checkTableNumbersForAllWaiters(tablenumber);
                if (check) {
                    System.out.println("Table number already added to another waiter so can't add");
                    break;
                } else {
                    waiter1.setTableNumber(tablenumber);
                    break;
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
    public Waiter getIN(String tablenumber,int customerid){
        return getWaiter(tablenumber, customerid);
    }

    

    @Override
    public void addWorkerToRestaurent(Cook cook) {
        this.cooks.add(cook);
    }

    @Override
    public void addWaitersToRestaurent(Waiter waiter) {
        waiters.add(waiter);
    }

    @Override
    public void addChefToRestaurent(Chef chef) {
        chefs.add(chef);
    }

    
    private Waiter getWaiter(String TableNumber, int customerid) {
        for (Waiter waiter : waiters) {
            if (waiter.getTablenumbers().contains(TableNumber)) {
                waiter.assignCustomer(customerid);
                return waiter;
            }
        }
        return null;
    }

    @Override
    public Cashier returnCashier() {
        return this.cashier;
    }

    @Override
    public Chef getRandomChef() {
        Random rand = new Random();
        return chefs.get(rand.nextInt(chefs.size()));
    }

    @Override
    public UserMenu getUserMenu() {
        return this.menu;
    }

    @Override
    public Menu getFullMenu() {
        return this.menu;
    }

    @Override
    public ArrayList<Item> getMenuItems() {

        return menu.getMenuItems();
    }

    @Override
    public Cook getRandomCook() {
        Random random = new Random();
        int index = random.nextInt(cooks.size());
        return cooks.get(index);
    }

}
