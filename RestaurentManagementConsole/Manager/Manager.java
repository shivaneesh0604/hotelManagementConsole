package RestaurentManagementConsole.Manager;

import java.util.Arrays;
import java.util.List;

import RestaurentManagementConsole.Restaurent.ManagerUI;


public class Manager {

    private final int id;
    private final String name;

    private static final List<String> tableAvailable = Arrays.asList("t1", "t2", "t3", "t4", "t5", "t6");

    public Manager(int manager_id, String name) {
        this.id = manager_id;
        this.name = name;
    }

    public void enterManagerUI(){
        ManagerUI managerui = new ManagerUI();
        managerui.enterRestaurent();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<String> getTableavailable() {
        return tableAvailable;
    }

}
