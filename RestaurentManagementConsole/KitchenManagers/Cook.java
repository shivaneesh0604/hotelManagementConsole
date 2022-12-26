package RestaurentManagementConsole.KitchenManagers;

import RestaurentManagementConsole.Orders.Order;

public class Cook  {

    private final int id;
    private final String name;

    public Cook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Order getfoodAndProcess(Order order) {
        System.out.println("food in process...");
        try {
            Thread.sleep(2000);
        } catch (Exception e){
        }
        System.out.println("food completed");
        System.out.println("foodname is "+order.getFoodname()+" quantity is "+order.getQuantity());
        return order;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
