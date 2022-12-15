package RestaurentManagementConsole.customer;

import java.util.ArrayList;

import RestaurentManagementConsole.Person;
import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.NewOrder;
import RestaurentManagementConsole.menu.UserMenu;
import RestaurentManagementConsole.waiter.Waiter;

public class Customer extends Person {

    private UserMenu menu;
    private Waiter waiter;
    private String tablenumber;
    private String orderID;  
    private Bill bill;
    private float BillTotalAmount;

    public Customer(int id, String name) {
        super(id, name);
    }

    public void askMenu() {
        menu = waiter.providesMenu();
    }

    public void readMenu() {
        try {
            menu.showMenu();
        } catch (NullPointerException e) {
            System.out.println("please first read the menu");
        }
    }

    public void addOrders(String foodname, int Quantity) {
        waiter.TakeNewOrder(this, foodname, Quantity);
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
            waiter.DeleteOrder(this, foodName, quantity);
        } catch (RuntimeException e) {
            System.out.println("cant delete this order since this food is not available in orders");
        }
    }

    public void receiveOrder(ArrayList<NewOrder> order) {
        System.out.println("customer " + getName());
        for (NewOrder order1 : order) {
            System.out.println("Foodname received is " + order1.getFoodname() + " quantity is " + order1.getQuantity());
        }
    }

    public void askbill() {
        bill = waiter.askbill(this);
    }
    
    public void ReadBill(){
        try {
            BillTotalAmount = bill.ReadBill();
        } catch (NullPointerException e) {
            System.out.println("Ask The Bill first");
        }
        System.out.println("payable amount is "+BillTotalAmount);
    }

    public void paybill(float paymentAmount){
        waiter.paybill(paymentAmount,this);
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

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

}