package RestaurentManagementConsole.KitchenOrderSystem;

import java.util.HashMap;

import RestaurentManagementConsole.Orders.Order;

public class Cook  {

    private final int id;
    private final String name;
    private HashMap<Chef, Order> orders = new HashMap<>();

    public Cook(int id, String name, String Username, String Password) {
        this.id = id;
        this.name = name;
    }

    public Order getfoodAndProcess(Order order, Chef kitchenOrderManager) {
        this.orders.put(kitchenOrderManager, order);
        System.out.println("food in process...");
        try {
            Thread.sleep(2000);
        } catch (Exception e){
        }
        System.out.println("food completed");
        System.out.println("foodname is "+order.getFoodname()+"quantity is "+order.getQuantity());
        return orders.get(kitchenOrderManager);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
