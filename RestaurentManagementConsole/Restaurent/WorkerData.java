package RestaurentManagementConsole.Restaurent;

import RestaurentManagementConsole.RestaurentApplication.Chef;
import RestaurentManagementConsole.RestaurentApplication.Cook;

public interface WorkerData {

    public void addWorkerToRestaurent(Cook worker);

    public void addChefToRestaurent(Chef chef);

}
