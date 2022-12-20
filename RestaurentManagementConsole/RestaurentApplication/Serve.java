package RestaurentManagementConsole.RestaurentApplication;

import RestaurentManagementConsole.customer.Customer;
import RestaurentManagementConsole.waiter.Waiter;

public interface Serve {
    public Waiter returnWaiter(String orderid);
    public Customer returnCustomer(int waiterid);
}
