package RestaurentManagementConsole.Customer;

import java.util.ArrayList;
import java.util.Scanner;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.RestaurentPublicFunctions;
import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.Restaurent.Waiter;
import RestaurentManagementConsole.menu.UserMenu;

public class CustomerUI {
    private RestaurentPublicFunctions restaurentPublicFunctions = Restaurent.getInstanceRestaurent();

    public void enterTheRestaurent(int customerid) {

        Scanner in = new Scanner(System.in);
        System.out.println("enter table number to sit");
        String tablenumber = in.next();
        Waiter waiter = restaurentPublicFunctions.getIN(tablenumber,customerid);
        while (true) {
            System.out.println(
                    "press 1 for asking menu \n 2 to add new orders \n 3 for deleteOrder \n 4 for confirm order \n 5 for asking bill and paying  ");
            int option = in.nextInt();
            switch (option) {
                case 1:
                    UserMenu menu = waiter.providesMenu();
                    menu.showMenu();
                    break;

                case 2:
                    System.out.println("enter food name ");
                    in.nextLine();
                    String foodname = in.nextLine();
                    System.out.println("enter the quantity");
                    int quantity = in.nextInt();
                    waiter.TakeNewOrder(customerid, foodname, quantity);
                    break;

                case 3:
                    System.out.println("enter food name to delete");
                    in.nextLine();
                    String foodname1 = in.nextLine();
                    System.out.println("enter the quantity");
                    int quantity1 = in.nextInt();
                    try {
                        waiter.DeleteOrder(customerid, foodname1, quantity1);
                    } catch (Exception e) {
                        System.out.println("this food is not ordered");
                    }
                    break;

                case 4:
                    try {
                        ArrayList<Order> orders = waiter.processOrder(customerid);
                        receiveOrder(orders);
                    } catch (Exception e) {
                        System.out.println("add an order first");
                    }
                    break;

                case 5:
                    Bill bill = waiter.askbill(customerid);
                    bill.ReadBill();
                    System.out.println("enter the amount to pay");
                    float paymentAmount = in.nextFloat();
                    waiter.paybill(paymentAmount, customerid);
                    break;
            }
            System.out.println("if you want to close options press 1");
            int closeOption = in.nextInt();
            if (closeOption == 1) {
                break;
            } else {
                continue;
            }

        }
    }

    private void receiveOrder(ArrayList<Order> order) {
        for (Order orders : order) {
            System.out.println("Foodname received is " + orders.getFoodname() + " quantity is " + orders.getQuantity());
        }
    }
}