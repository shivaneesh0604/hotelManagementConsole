package RestaurentManagementConsole.Cashier;

import java.util.ArrayList;
import java.util.HashMap;

import RestaurentManagementConsole.Orders.Order;

public class Cashier {

    private final int id;
    private final String name;
    private HashMap<Integer, Bill> bills = new HashMap<>();

    private Cashier(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static Cashier cashier = null;

    public static Cashier getInstance() {
        if (cashier == null) {
            cashier = new Cashier(1, "karthi");
        }
        return cashier;
    }

    public Bill generateBill(ArrayList<Order> order, int orderid) {
        Bill bill = new Bill(order,orderid);
        bills.put(orderid, bill);
        return bill;
    }

    public void payBill(float paymentAmount, int orderid) {
        if (bills.get(orderid).getTotalAmount() == paymentAmount) {
            System.out.println("payment done");
        }
        else{
            System.out.println("payable amount is less than "+bills.get(orderid).getTotalAmount()+" so enter amount equal to "+bills.get(orderid).getTotalAmount());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    } 

}