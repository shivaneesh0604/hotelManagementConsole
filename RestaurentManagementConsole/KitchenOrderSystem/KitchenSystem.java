package RestaurentManagementConsole.KitchenOrderSystem;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.waiter.Waiter;

public interface KitchenSystem {
    public void storeOrder(String orderId,Order order,Waiter waiter);
}
