package RestaurentManagementConsole.Cashier;

import java.util.ArrayList;
import java.util.HashMap;

import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.CashierInterface;
import RestaurentManagementConsole.Restaurent.Restaurent;

public class Cashier {

    private final int id;
    private final String name;
    private HashMap<Integer, Bill> bills = new HashMap<>();
    private final CashierInterface cashierInterface;


    private Cashier(int id, String name) {
        this.id = id;
        this.name = name;
        cashierInterface = Restaurent.getInstanceRestaurent();
    }

    private static Cashier cashier = null;

    public static Cashier getInstance() {
        if (cashier == null) {
            cashier = new Cashier(1, "karthi");
        }
        return cashier;
    }

    public Bill generateBill(ArrayList<Order> listOfOrders, int orderid) {
        Bill bill = new Bill(listOfOrders,orderid);
        bills.put(orderid, bill);
        return bill;
    }

    public void payBill(float paymentAmount, int orderid) {
        if (bills.get(orderid).getTotalAmount() == paymentAmount) {
            System.out.println("payment done");
            System.out.println("Happy journey! \n THANK YOU");
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