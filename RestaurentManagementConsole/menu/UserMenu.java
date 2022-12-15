package RestaurentManagementConsole.menu;

import java.util.ArrayList;

public interface UserMenu {
    public void showMenu();
    public ArrayList<Item> getMenuList();
    public boolean checkFoodAvailability(String foodname);
}
