package RestaurentManagementConsole.RestaurentApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Cashier.Cashier;
import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Orders.OrderList;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.menu.UserMenu;

public class Waiter {

    private final int id;
    private final String name;
    private UserMenu menu;
    private final HashMap<Integer, OrderList> orders;
    private final ArrayList<String> Tablenumbers;

    public Waiter(int waiter_id, String name) {
        this.id = waiter_id;
        this.name = name;
        Tablenumbers = new ArrayList<>();
        orders = new HashMap<>();
        menu = Menu.getinstance();
    }

    protected void assignCustomer(int customerid) {
        OrderList order = new OrderList();
        this.orders.put(customerid, order);
    }

    public void TakeNewOrder(int customerid, String foodName, int quantity) {

        OrderList orders1 = orders.get(customerid);
        boolean foodExists = false;
        foodExists = menu.checkFoodAvailability(foodName);
        if (foodExists == false) {
            System.out.println("Enter the right foodname to order");
        } else {
            Order order = new Order(foodName, quantity);
            orders1.AddtoOrders(order);
        }
    }

    public void processOrder(int customerid) {
        OrderList o1 = orders.get(customerid);

        if (o1.getOrders().size() == 0) {
            throw new RuntimeException();
        }
        if (o1.getOrderId()==0) {
            o1.setOrderId(customerid);
        }
        for (Order order : o1.getOrders()) {
            if (order.isDelivered()) {
                System.out.println("that food" + order.getFoodname()
                        + "is delivered so shoulnt send that to kitchen order manager");
                continue;
            } else if (!order.isDelivered()) {
                KitchenSystem kitchensystem = Restaurent.getInstanceRestaurent().getrandomChef();
                kitchensystem.storeOrder(o1.getOrderId(), order, this);
            }
        }
    }

    protected void ReceiveOrder(int orderID, ArrayList<Order> order) {
        // serves.returnCustomer(this.id).receiveOrder(order);
    }

    public void DeleteOrder(int customerid, String foodName, int quantity) {
        boolean foodExists = false;
        foodExists = menu.checkFoodAvailability(foodName);
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
        if (!checkfoodprocessed) {
            System.out.println("can't delete the food since it is already processed");
        } else {
            System.out.println("Orders in main orders are");
            o.deleteOrder(foodName, quantity);
        }
    }

    public Bill askbill(int customerid) {
        OrderList order = this.orders.get(customerid);
        Cashier cashier = Cashier.getInstance();
        return cashier.generateBill(order.getOrders(), order.getOrderId());
    }

    public void paybill(float paymentAmount, int customerid) {
        Cashier.getInstance().payBill(paymentAmount, orders.get(customerid).getOrderId());
    }

    public UserMenu providesMenu() {
        return menu;
    }

    protected List<String> getTablenumbers() {
        return Tablenumbers;
    }

    protected void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }

    protected int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected HashMap<Integer, OrderList> getOrders() {
        return orders;
    }

}