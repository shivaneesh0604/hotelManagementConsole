package hotelManagementConsole.KitchenOrderSystem;

import hotelManagementConsole.Orders.NewOrder;
import hotelManagementConsole.waiter.Waiter;

public interface OrderHook {
    public void storeOrder(String orderId,NewOrder order,Waiter waiter);
}
