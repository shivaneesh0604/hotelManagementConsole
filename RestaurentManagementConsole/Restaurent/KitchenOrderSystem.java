package RestaurentManagementConsole.Restaurent;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.RestaurentApplication.KitchenSystem;

public class KitchenOrderSystem implements KitchenSystem {
    private KitchenSystemInterface restaurent = Restaurent.getInstanceRestaurent();

    @Override
    public  ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders) {
        return restaurent.getRandomChef().assignToChefAndReceieveFood(orders);
    }


}
