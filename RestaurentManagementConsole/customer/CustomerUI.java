package RestaurentManagementConsole.customer;

import java.util.Scanner;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.RestaurentApplication.Restaurent;
import RestaurentManagementConsole.RestaurentApplication.Waiter;
import RestaurentManagementConsole.menu.UserMenu;

public class CustomerUI {
    public static void enterTheRestaurent(int customerid) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter table number to sit");
        String tablenumber = sc.nextLine();
        Waiter waiter = Restaurent.getInstanceRestaurent().getWaiter(tablenumber, customerid);
        while (true) {
            System.out.println("press 1 to ask options");
            int askoptions = sc.nextInt();
            while (askoptions == 1) {

                System.out.println(
                        "press 1 for asking menu \n 2 to add new orders \n 3 for deleteOrder \n 4 for confirm order \n 5 for asking bill and paying  ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        UserMenu menu = waiter.providesMenu();
                        menu.showMenu();
                        break;

                    case 2:
                        System.out.println("enter food name ");
                        sc.nextLine();
                        String foodname = sc.nextLine();
                        System.out.println("enter the quantity");
                        int quantity = sc.nextInt();
                        waiter.TakeNewOrder(customerid, foodname, quantity);
                        break;

                    case 3:
                        System.out.println("enter food name to delete");
                        sc.nextLine();
                        String foodname1 = sc.nextLine();
                        System.out.println("enter the quantity");
                        int quantity1 = sc.nextInt();
                        waiter.DeleteOrder(customerid, foodname1, quantity1);
                        break;

                    case 4:
                        waiter.processOrder(customerid);
                        break;

                    case 5:
                        Bill bill = waiter.askbill(customerid);
                        bill.ReadBill();
                        float paymentAmount = sc.nextFloat();
                        waiter.paybill(paymentAmount, customerid);
                        break;
                }
            }

            sc.close();
        }
    }
}
