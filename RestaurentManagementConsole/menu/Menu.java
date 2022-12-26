package RestaurentManagementConsole.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Menu implements UserMenu {

    private ArrayList<Item> CategoryFoodAsVeg = new ArrayList<>();
    private ArrayList<Item> CategoryFoodAsNonVeg = new ArrayList<>();
    private HashMap<Classificaton, ArrayList<Item>> Starter2 = new HashMap<Classificaton,ArrayList<Item>>(){
        {
            put(Classificaton.VEG,new ArrayList<>());
            put(Classificaton.NONVEG, new ArrayList<>());
        }
    };
    private ArrayList<Item> totalItems = new ArrayList<>();

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
        totalItems.add(items);
        if (items.getStarter().equals(Starter.STARTER)) {
            if (items.getCategory().equals(Classificaton.VEG)) {
                ArrayList<Item> items1 = Starter2.get(Classificaton.VEG);
                items1.add(items);
            } else {
                ArrayList<Item> items1 = Starter2.get(Classificaton.NONVEG);
                items1.add(items);

            }
        } else if (items.getCategory().equals(Classificaton.VEG)) {
            CategoryFoodAsVeg.add(items);
        } else if (items.getCategory().equals(Classificaton.NONVEG)) {
            CategoryFoodAsNonVeg.add(items);
        }
    }

    public void showMenu() {
        System.out.println("Food available are ");
        System.out.println("foodname \t price ");
        ArrayList<Item> itemsVeg = Starter2.get(Classificaton.VEG);
        ArrayList<Item> itemsNonVeg = Starter2.get(Classificaton.NONVEG);
        try {
            System.out.println("Veg Starters are ");
            for (Item item : itemsVeg) {
                System.out.println(item.getFoodName() + " " + item.getPrice());
            }

        } catch (Exception e) {
        }
        System.out.println("");
        try {
            System.out.println("Non veg Starters are");
            for (Item item : itemsNonVeg) {
                System.out.println(item.getFoodName() + " " + item.getPrice());
            }

        } catch (Exception e) {
        }
        System.out.println("");
        System.out.println("Nonveg foods are ");
        for (Item item : CategoryFoodAsNonVeg) {
            System.out.println(item.getFoodName() + " " + item.getPrice());
        }
        System.out.println("");
        System.out.println("veg foods are");
        for (Item item : CategoryFoodAsVeg) {
            System.out.println(item.getFoodName() + " " + item.getPrice());
        }
        System.out.println("");
    }

    public void alterMenuItems(String foodname, int price) {
        for (Item item : totalItems) {
            if (item.getFoodName().equals(foodname)) {
                item.setPrice(price);
                System.out.println("changed food name is " + item.getFoodName() + "price is " + item.getPrice());
            }
        }

    }

    public void deleteMenuItems(String foodname) {
        Iterator<Item> it = totalItems.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getFoodName().equals(foodname)) {
                it.remove();
            }
        }

        try {
            Iterator<Item> it1 = CategoryFoodAsNonVeg.iterator();
            while(it1.hasNext()){
                Item item1 = it.next();
                if(item1.getFoodName().equals(foodname)){
                    it1.remove();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            Iterator<Item> it2= CategoryFoodAsVeg.iterator();
            while(it2.hasNext()){
                Item item2 = it2.next();
                if(item2.getFoodName().equals(foodname)){
                    it2.remove();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            ArrayList<Item> item3 = Starter2.get(Classificaton.NONVEG);
            Iterator<Item> it3 = item3.iterator();
            while(it3.hasNext()){
                Item item4 = it.next();
                if(item4.getFoodName().equals(foodname)){
                    it3.remove();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            ArrayList<Item> item4 = Starter2.get(Classificaton.VEG);
            Iterator<Item> it4 = item4.iterator();
            while(it4.hasNext()){
                Item item5 = it.next();
                if(item5.getFoodName().equals(foodname)){
                    it4.remove();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean checkFoodAvailability(String foodname) {
        for (Item item : totalItems) {
            if (item.getFoodName().equals(foodname)) {
                return true;
            }
        }
        return false;
    }   

    public ArrayList<Item> getMenuItems(){
        return totalItems;
    }

}
