package RestaurentManagementConsole.KitchenManagers;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.ChefInterface;
import RestaurentManagementConsole.Restaurent.Restaurent;

public class Chef {

    private final int id;
    private final String name;
    private final ChefInterface chefinterface;
    public Chef(int id, String name) {
        this.id = id;
        this.name = name;
        chefinterface = Restaurent.getInstanceRestaurent();
    }

    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {

        Cook cook = chefinterface.getRandomCook();
        
        ArrayList<Order> processedOrders = new ArrayList<>();
        for (Order order : orders) {
            Order order1 = cook.getfoodAndProcess(order);
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
