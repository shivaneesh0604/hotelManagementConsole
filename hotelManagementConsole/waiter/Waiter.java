package hotelManagementConsole.waiter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hotelManagementConsole.Person;
import hotelManagementConsole.Cashier.Bill;
import hotelManagementConsole.Cashier.Cashier;
import hotelManagementConsole.KitchenOrderSystem.OrderHook;
import hotelManagementConsole.KitchenOrderSystem.KitchenOrderSystem;
import hotelManagementConsole.Orders.NewOrder;
import hotelManagementConsole.Orders.Orders;
import hotelManagementConsole.customer.Customer;
import hotelManagementConsole.menu.Menu;
import hotelManagementConsole.menu.UserMenu;

public class Waiter extends Person {

    private UserMenu menu;
    private final HashMap<Customer, Orders> orders;
    private final HashMap<String, Customer> customerfinding;// for returning the food
    private final ArrayList<String> Tablenumbers;
    private OrderHook orderHook;
    private Cashier cashier;

    public Waiter(int waiter_id, String name) {
        super(waiter_id, name);
        Tablenumbers = new ArrayList<>();
        orders = new HashMap<>();
        customerfinding = new HashMap<>();
        orderHook = KitchenOrderSystem.getinsttanceKitchenOrderManager();
        menu = Menu.getinstance();
        cashier = Cashier.getinstance();
    }

    public void assignCustomer(Customer customer) {
        Orders order = new Orders();
        this.orders.put(customer, order);
    }

    public void assignCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public void TakeNewOrder(Customer customer, String foodName, int quantity) {

        Orders orders1 = orders.get(customer);
        boolean foodExists = false;
        foodExists = menu.checkFoodAvailability(foodName);
        if (foodExists == false) {
            System.out.println("Enter the right foodname to order");
        } else {
            NewOrder order = new NewOrder(foodName, quantity);
            orders1.AddtoOrders(order);
        }
    }

    public void processOrder(Customer customer) {
        Orders o1 = orders.get(customer);

        if (o1.getOrders().size()==0) {
            throw new RuntimeException();
        }
        if (o1.getOrderId() == null) {
            customer.setOrderID(o1.setOrderId(customer.getId(), customer.getName()));
        }
        for (NewOrder order : o1.getOrders()) {
            if (order.isDelivered()) {
                System.out.println("that food" + order.getFoodname()
                        + "is delivered so shoulnt send that to kitchen order manager");
                continue;
            }
            System.out.println(order.getFoodname() + "here");
            if (!order.isDelivered()) {
                orderHook.storeOrder(customer.getOrderID(), order, this);
            }
        }
        if (customerfinding.get(customer.getOrderID()) == null) {
            this.customerfinding.put(customer.getOrderID(), customer);
        }
    }

    public void ReceiveOrder(String orderID, Orders order) {
        Customer customer = customerfinding.get(orderID);
        customer.receiveOrder(order.getOrders());
    }

    public void DeleteOrder(Customer customer, String foodName, int quantity) {
        boolean foodExists = false;
        foodExists = menu.checkFoodAvailability(foodName);
        if (foodExists == false) {
            System.out.println("Enter the right foodname to delete order since this food in not available in menu");
            return;
        }
        Orders o = orders.get(customer);
        boolean foodCheckinOrders=false;
        for (NewOrder orders : o.getOrders()) {
            if(orders.getFoodname().equals(foodName)){
                foodCheckinOrders=true;
                break;
            }
        }
        if(foodCheckinOrders==false){
            throw new RuntimeException();
        }
        // if(o.getOrders().contains(foodName)){

        // }
        boolean checkfoodprocessed = false;
        for (NewOrder order : o.getOrders()) {
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

    public Bill askbill(Customer customer) {
        Orders order = this.orders.get(customer);
        return cashier.generateBill(order.getOrders(),order.getOrderId());
    }

    public Menu providesMenu() {
        return Menu.getinstance();
    }

    public List<String> getTablenumbers() {
        return Tablenumbers;
    }

    public void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }

}