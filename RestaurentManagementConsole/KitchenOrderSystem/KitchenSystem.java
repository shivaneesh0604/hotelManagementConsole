package RestaurentManagementConsole.KitchenOrderSystem;

import RestaurentManagementConsole.Orders.NewOrder;
import RestaurentManagementConsole.waiter.Waiter;

public interface KitchenSystem {
    public void storeOrder(String orderId,NewOrder order,Waiter waiter);
}
