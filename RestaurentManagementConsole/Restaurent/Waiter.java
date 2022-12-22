package RestaurentManagementConsole.Restaurent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Cashier.Cashier;
import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Orders.OrderList;
import RestaurentManagementConsole.RestaurentApplication.KitchenSystem;
import RestaurentManagementConsole.menu.UserMenu;

public class Waiter {

    private final int id;
    private final String name;
    private final HashMap<Integer, OrderList> orders;
    private final ArrayList<String> Tablenumbers;
    private WaiterInterface waiterInterface ; 

    public Waiter(int waiter_id, String name) {
        this.id = waiter_id;
        this.name = name;
        Tablenumbers = new ArrayList<>();
        orders = new HashMap<>();
        waiterInterface = Restaurent.getInstanceRestaurent();
    }

    void assignCustomer(int customerid) {
        OrderList order = new OrderList();
        this.orders.put(customerid, order);
    }

    public void TakeNewOrder(int customerid, String foodName, int quantity) {

        OrderList orders1 = orders.get(customerid);
        boolean foodExists = false;
        foodExists = waiterInterface.getUserMenu().checkFoodAvailability(foodName);
        if (foodExists == false) {
            System.out.println("Enter the right foodname to order");
        } else {
            Order order = new Order(foodName, quantity);
            orders1.AddtoOrders(order);
        }
    }

    public ArrayList<Order> processOrder(int customerid) {
        OrderList o1 = orders.get(customerid);

        if (o1.getOrders().size() == 0) {
            throw new NullPointerException();
        }
        if (o1.getOrderId() == 0) {
            o1.setOrderId(customerid);
        }
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : o1.getOrders()) {
            if (order.isDelivered()) {
                continue;
            } else if (!order.isDelivered()) {
                orders.add(order);
                order.setDelivered(true);
            }
        }
         KitchenSystem kitchensystem = new KitchenOrderSystem();
        return kitchensystem.assignToChefAndReceieveFood(orders);
    }

    public void DeleteOrder(int customerid, String foodName, int quantity) {
        boolean foodExists = false;
        foodExists = waiterInterface.getUserMenu().checkFoodAvailability(foodName);
        if (foodExists == false) {
            System.out.println("Enter the right foodname to delete order since this food in not available in menu");
            return;
        }
        OrderList o = orders.get(customerid);
        boolean foodCheckinOrders = false;
        for (Order orders : o.getOrders()) {
            if (orders.getFoodname().equals(foodName)) {
                foodCheckinOrders = true;
                break;
            }
        }
        if (foodCheckinOrders == false) {
            throw new RuntimeException();
        }
        boolean checkfoodprocessed = false;
        for (Order order : o.getOrders()) {
            if (!order.isDelivered() && order.getFoodname().equals(foodName)) {
                checkfoodprocessed = true;
                break;
            }
        }
        if (checkfoodprocessed) {
            System.out.println("Orders in main orders are");
            o.deleteOrder(foodName, quantity);
        }
    }

    public Bill askbill(int customerid) {
        OrderList order = this.orders.get(customerid);
        Cashier cashier = waiterInterface.returnCashier();
        return cashier.generateBill(order.getOrders(), order.getOrderId());
    }

    public void paybill(float paymentAmount, int customerid) {
        WaiterInterface fetchCashier = Restaurent.getInstanceRestaurent();
        Cashier cashier = fetchCashier.returnCashier();
        cashier.payBill(paymentAmount, orders.get(customerid).getOrderId());
    }

    public UserMenu providesMenu() {
        return waiterInterface.getUserMenu();
    }

    List<String> getTablenumbers() {
        return Tablenumbers;
    }

    void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}