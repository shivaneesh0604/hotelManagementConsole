package RestaurentManagementConsole.customer;

import java.util.ArrayList;
import java.util.Scanner;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.CustomerData;
import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.Restaurent.Waiter;
import RestaurentManagementConsole.menu.UserMenu;

public class CustomerUI {
    private CustomerData customerData = Restaurent.getInstanceRestaurent();

    public void enterTheRestaurent(Customer customer) {

        customerData.addCustomerToRestaurent(customer);
        Scanner in = new Scanner(System.in);
        System.out.println("enter table number to sit");
        String tablenumber = in.next();
        Waiter waiter = customerData.getWaiter(tablenumber, customer.getId());

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
                    waiter.TakeNewOrder(customer.getId(), foodname, quantity);
                    break;

                case 3:
                    System.out.println("enter food name to delete");
                    in.nextLine();
                    String foodname1 = in.nextLine();
                    System.out.println("enter the quantity");
                    int quantity1 = in.nextInt();
                    try {

                        waiter.DeleteOrder(customer.getId(), foodname1, quantity1);
                    } catch (Exception e) {
                        System.out.println("this food is not ordered");
                    }
                    break;

                case 4:
                    try {
                        ArrayList<Order> orders = waiter.processOrder(customer.getId());
                        customer.receiveOrder(orders);
                    } catch (Exception e) {
                        System.out.println("add an order first");
                    }
                    break;

                case 5:
                    Bill bill = waiter.askbill(customer.getId());
                    bill.ReadBill();
                    System.out.println("enter the amount to pay");
                    float paymentAmount = in.nextFloat();
                    waiter.paybill(paymentAmount, customer.getId());
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
}
