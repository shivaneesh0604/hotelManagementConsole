package hotelManagementConsole.menu;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu implements UserMenu {

    private static ArrayList<Item> menuList = new ArrayList<>();

    private Menu() {

    }

    private static Menu menu = null;

    public static Menu getinstance() {
        if (menu == null) {

            menu = new Menu();
        }
        return menu;

    }

    public void addMenusItems(Item items) {
        menuList.add(items);
    }

    public void showMenu() {
        System.out.println("Food available are ");
        System.out.println("foodname  price  v/nv");
        for (Item item : menuList) {
            System.out.println(item.getFoodName() + " " + item.getPrice() + " " + item.getCategory());
        }
    }

    public void alterMenuItems(String foodname, int price) {
        for (Item item : menuList) {
            if (item.getFoodName().equals(foodname)) {
                item.setPrice(price);
                System.out.println("changed food name is " + item.getFoodName() + "price is " + item.getPrice());
            }
        }

    }

    public void alterMenuItems(String foodname) {
        Iterator<Item> it = menuList.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getFoodName().equals(foodname)) {
                it.remove();
            }
        }

    }

    public boolean checkFoodAvailability(String foodname) {
        for (Item item : menuList) {
            if (item.getFoodName().equals(foodname)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getMenuList() {
        return menuList;
    }

}
