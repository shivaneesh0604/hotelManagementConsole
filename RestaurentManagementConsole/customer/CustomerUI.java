package RestaurentManagementConsole.customer;

import java.util.Scanner;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Manager.CustomerData;
import RestaurentManagementConsole.RestaurentApplication.Restaurent;
import RestaurentManagementConsole.RestaurentApplication.Waiter;
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
            System.out.println("press 1 to ask options");
            int askoptions = in.nextInt();
            while (askoptions == 1) {

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
                        waiter.DeleteOrder(customer.getId(), foodname1, quantity1);
                        break;

                    case 4:
                        waiter.processOrder(customer.getId());
                        break;

                    case 5:
                        Bill bill = waiter.askbill(customer.getId());
                        bill.ReadBill();
                        System.out.println("enter the amount to pay");
                        float paymentAmount = in.nextFloat();
                        waiter.paybill(paymentAmount, customer.getId());
                        break;
                }
            }

        }
    }
}
