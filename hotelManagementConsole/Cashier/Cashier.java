package hotelManagementConsole.Cashier;

import java.util.ArrayList;
import java.util.HashMap;

import hotelManagementConsole.Person;
import hotelManagementConsole.Orders.NewOrder;

public class Cashier extends Person {

    private HashMap<String, Bill> bills = new HashMap<>();

    private Cashier(int id, String name) {
        super(id, name);
    }

    private static Cashier cashier = null;

    public static Cashier getinstance() {
        if (cashier == null) {
            cashier = new Cashier(1, "karthi");
        }
        return cashier;
    }

    public Bill generateBill(ArrayList<NewOrder> order, String orderid) {
        Bill bill = new Bill(order);
        bills.put(orderid, bill);
        return bill;
    }

    public void paybill(float paymentAmount, String orderid) {
        if (bills.get(orderid).getTotalAmount() == paymentAmount) {
            System.out.println("payment done");
        }
    }

}