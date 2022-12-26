package RestaurentManagementConsole.Manager;


import RestaurentManagementConsole.User;

public class Manager extends User {

    public Manager(int manager_id, String name) {
        super(manager_id, name);
    }

    public void enterManagerUI() {
        ManagerUI managerui = new ManagerUI();
        managerui.enterRestaurent();
    }

    @Override
    public void entersUI() {
        ManagerUI2 managerUI2 = new ManagerUI2();
        managerUI2.managerinterface();
    }

}
