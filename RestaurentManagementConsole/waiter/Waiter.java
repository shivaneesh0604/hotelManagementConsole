package RestaurentManagementConsole.waiter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RestaurentManagementConsole.Person;
import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Cashier.Cashier;
import RestaurentManagementConsole.KitchenOrderSystem.Chef;
import RestaurentManagementConsole.KitchenOrderSystem.KitchenSystem;
import RestaurentManagementConsole.Orders.NewOrder;
import RestaurentManagementConsole.Orders.Orders;
import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.menu.UserMenu;

public class Waiter extends Person {

    private UserMenu menu;
    private final HashMap<Integer, Orders> orders;
    private final HashMap<String, Customer> customerfinding;// for returning the food
    private final ArrayList<String> Tablenumbers;
    private KitchenSystem kitchenSystem;
    private Cashier cashier;

    public Waiter(int waiter_id, String name) {
        super(waiter_id, name);
        Tablenumbers = new ArrayList<>();
        orders = new HashMap<>();
        customerfinding = new HashMap<>();
        kitchenSystem = Chef.getinsttanceChef();
        menu = Menu.getinstance();
        cashier = Cashier.getinstance();
    }

    public void assignCustomer(int customerid) {
        Orders order = new Orders();
        this.orders.put(customerid, order);
    }

    public void assignCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public void TakeNewOrder(int customerid, String foodName, int quantity) {

        Orders orders1 = orders.get(customerid);
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
        Orders o1 = orders.get(customer.getId());

        if (o1.getOrders().size()==0) {
            throw new RuntimeException();
        }
        if (o1.getOrderId() == null) {
            o1.setOrderId(customer.getId(), customer.getName());
        }
        for (NewOrder order : o1.getOrders()) {
            if (order.isDelivered()) {
                System.out.println("that food" + order.getFoodname()
                        + "is delivered so shoulnt send that to kitchen order manager");
                continue;
            }
            else if (!order.isDelivered()) {
                kitchenSystem.storeOrder(o1.getOrderId(), order, this);
            }
        }
        if (customerfinding.get(o1.getOrderId()) == null) {
            this.customerfinding.put(o1.getOrderId(), customer);
        }
    }

    public void ReceiveOrder(String orderID, ArrayList<NewOrder> order) {
        Customer customer = customerfinding.get(orderID);
        customer.receiveOrder(order);
    }

    public void DeleteOrder(int customerid, String foodName, int quantity) {
        boolean foodExists = false;
        foodExists = menu.checkFoodAvailability(foodName);
        if (foodExists == false) {
            System.out.println("Enter the right foodname to delete order since this food in not available in menu");
            return;
        }
        Orders o = orders.get(customerid);
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

    public Bill askbill(int customerid) {
        Orders order = this.orders.get(customerid);
        return cashier.generateBill(order.getOrders(),order.getOrderId());
    }

    public void paybill(float paymentAmount,int customerid){
        cashier.paybill(paymentAmount,orders.get(customerid).getOrderId());
    }

    public UserMenu providesMenu() {
        return menu;
    }

    public List<String> getTablenumbers() {
        return Tablenumbers;
    }

    public void setTableNumber(String tablenumber) {
        this.Tablenumbers.add(tablenumber);
    }

}