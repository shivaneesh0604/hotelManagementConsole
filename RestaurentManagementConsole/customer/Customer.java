package RestaurentManagementConsole.customer;

import java.util.ArrayList;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.NewOrder;
import RestaurentManagementConsole.menu.UserMenu;
import RestaurentManagementConsole.waiter.Waiter;

public class Customer {

    private final int id;
    private final String name;
    private Waiter waiter;
    private String tablenumber;
    private Bill bill;
    private ArrayList<NewOrder> ordersReceived;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        ordersReceived = new ArrayList<>();
    }

    public void askMenu() {
        UserMenu menu = waiter.providesMenu();
        menu.showMenu();
    }

    public void addOrders(String foodname, int Quantity) {
        waiter.TakeNewOrder(this.getId(), foodname, Quantity);
    }

    public void confirmOrder() {
        try {
            waiter.processOrder(this);
        } catch (RuntimeException e) {
            System.out.println("no orders available");
        }
    }

    public void DeleteOrder(String foodName, int quantity) {
        try {
            waiter.DeleteOrder(this.getId(), foodName, quantity);
        } catch (RuntimeException e) {
            System.out.println("cant delete this order since this food is not available in orders");
        }
    }

    public void receiveOrder(ArrayList<NewOrder> order) {
        for (NewOrder orders : order) {
            this.ordersReceived.add(orders);
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }

    public void askbill() {
        bill = waiter.askbill(this.getId());
        System.out.println("payable amount is " + bill.ReadBill());
    }

    public void paybill(float paymentAmount) {
        waiter.paybill(paymentAmount, this.getId());
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public String getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(String tablenumber) {
        this.tablenumber = tablenumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    } 

}
