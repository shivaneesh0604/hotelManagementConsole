package RestaurentManagementConsole.KitchenOrderSystem;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.KitchenSystemInterface;
import RestaurentManagementConsole.Restaurent.Restaurent;

public class KitchenOrderSystem implements KitchenSystem {
    private KitchenSystemInterface kitchenSystemInterface = Restaurent.getInstanceRestaurent();

    @Override
    public  ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {
        return kitchenSystemInterface.getRandomChef().assignToChefAndReceieveFood(orders);
    }


}
