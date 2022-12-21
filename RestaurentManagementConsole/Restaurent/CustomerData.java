package RestaurentManagementConsole.Restaurent;

import RestaurentManagementConsole.RestaurentApplication.Waiter;
import RestaurentManagementConsole.customer.Customer;

public interface CustomerData {
    
    public void addCustomerToRestaurent(Customer customer);

    public Waiter getWaiter(String tablenumber,int customerid);

}
