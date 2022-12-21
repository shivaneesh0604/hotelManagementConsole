package RestaurentManagementConsole.RestaurentApplication;

import java.util.ArrayList;
import java.util.Random;

import RestaurentManagementConsole.Orders.Order;

public class Chef implements KitchenSystem {

    private final int id;
    private final String name;
    private ArrayList<Cook> cook = new ArrayList<>();
    public Chef(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCookToChef(Cook Cook) {
        this.cook.add(Cook);
    }

    @Override
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {

        Random random = new Random();       
        int index = random.nextInt(cook.size());
        Cook cook2 = cook.get(index);
        ArrayList<Order> processedOrders = new ArrayList<>();
        for (Order order : orders) {
            Order order1 = cook2.getfoodAndProcess(order);
            processedOrders.add(order1);
        }
        return processedOrders;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
