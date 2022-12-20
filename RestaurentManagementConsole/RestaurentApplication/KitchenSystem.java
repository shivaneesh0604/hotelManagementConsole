package RestaurentManagementConsole.RestaurentApplication;

import RestaurentManagementConsole.Orders.Order;

public interface KitchenSystem {
    public void storeOrder(int orderId,Order order,Waiter waiter);
}
