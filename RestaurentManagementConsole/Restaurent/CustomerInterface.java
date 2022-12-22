package RestaurentManagementConsole.Restaurent;

import RestaurentManagementConsole.customer.Customer;

public interface CustomerInterface {
    
    public void addCustomerToRestaurent(Customer customer);

    public Waiter getWaiter(String tablenumber,int customerid);

}
