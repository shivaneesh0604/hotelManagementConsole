package RestaurentManagementConsole.Cashier;

import java.util.ArrayList;
import java.util.HashMap;

import RestaurentManagementConsole.Person;
import RestaurentManagementConsole.Orders.NewOrder;

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
        Bill bill = new Bill(order,orderid);
        bills.put(orderid, bill);
        return bill;
    }

    public void paybill(float paymentAmount, String orderid) {
        if (bills.get(orderid).getTotalAmount() == paymentAmount) {
            System.out.println("payment done");
        }
        else{
            System.out.println("payable amount is less than "+bills.get(orderid).getTotalAmount()+" so enter amount equal to "+bills.get(orderid).getTotalAmount());
        }
    }
}