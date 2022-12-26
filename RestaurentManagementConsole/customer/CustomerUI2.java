package RestaurentManagementConsole.Customer;

import java.util.ArrayList;

import RestaurentManagementConsole.Cashier.Bill;
import RestaurentManagementConsole.Orders.Order;
import RestaurentManagementConsole.Restaurent.CustomerInterface;
import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.Restaurent.Waiter;
import RestaurentManagementConsole.menu.UserMenu;

public class CustomerUI2 {
    private CustomerInterface customerInterface = Restaurent.getInstanceRestaurent();

    public void entersRestaurent(Customer customer) {
        customerInterface.addCustomerToRestaurent(customer);
        Waiter waiter = customerInterface.getWaiter("t1", customer.getId());
        UserMenu menu = waiter.providesMenu();
        menu.showMenu();
        System.out.println("for ordering the food");
        waiter.TakeNewOrder(customer.getId(), "GrillChicken", 2);
        waiter.TakeNewOrder(customer.getId(), "GrillChicken", 2);

        System.out.println("food to delete");
        waiter.DeleteOrder(customer.getId(), "GrillChicken", 2);
        waiter.DeleteOrder(customer.getId(), "GrillChicken", 1);

        System.out.println("receive order ");
        ArrayList<Order> orders = waiter.processOrder(customer.getId());

        customer.receiveOrder(orders);

        System.out.println("bill payment process ");
        Bill bill = waiter.askbill(customer.getId());
        bill.ReadBill();
        waiter.paybill(30, customer.getId());

    }
}
