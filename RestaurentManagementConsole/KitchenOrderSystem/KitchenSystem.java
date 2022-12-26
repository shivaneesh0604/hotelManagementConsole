package RestaurentManagementConsole.KitchenOrderSystem;

import java.util.ArrayList;

import RestaurentManagementConsole.Orders.Order;

public interface KitchenSystem {
    public ArrayList<Order> assignToChefAndReceieveFood(ArrayList<Order> orders);
}
