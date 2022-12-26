package RestaurentManagementConsole.Restaurent;

import RestaurentManagementConsole.Customer.Customer;

public interface CustomerInterface {
    
    public void addCustomerToRestaurent(Customer customer);

    public Waiter getWaiter(String tablenumber,int customerid);

}
