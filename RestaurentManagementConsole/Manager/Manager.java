package RestaurentManagementConsole.Manager;

import java.util.Arrays;
import java.util.List;

import RestaurentManagementConsole.User;

public class Manager extends User {

    private static final List<String> tableAvailable = Arrays.asList("t1", "t2", "t3", "t4", "t5", "t6");

    public Manager(int manager_id, String name) {
        super(manager_id, name);
    }

    public void enterManagerUI() {
        ManagerUI managerui = new ManagerUI();
        managerui.enterRestaurent();
    }

    public static List<String> getTableavailable() {
        return tableAvailable;
    }

    @Override
    public void entersUI() {
        ManagerUI2 managerUI2 = new ManagerUI2();
        managerUI2.managerinterface();
    }

}
