package RestaurentManagementConsole.Customer;

import RestaurentManagementConsole.User;

public class Customer extends User {

    public Customer(int id, String name) {
        super(id, name);
    }

    // public void entersRestaurent(){
    // CustomerUI customerui = new CustomerUI();
    // customerui.enterTheRestaurent(this);
    // }

    

    @Override
    public void entersUI() {
        CustomerUI2 customerui = new CustomerUI2();
        customerui.entersRestaurent(this.getId());
    }

}
