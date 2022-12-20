package RestaurentManagementConsole.RestaurentApplication;

import RestaurentManagementConsole.customer.Customer;

public interface Serve {
    public Waiter returnWaiter(int orderid);
    public Customer returnCustomer(int waiterid);
}
