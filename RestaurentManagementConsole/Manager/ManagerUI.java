package RestaurentManagementConsole.Manager;

import java.util.List;
import java.util.Scanner;

import RestaurentManagementConsole.Restaurent.Restaurent;
import RestaurentManagementConsole.Restaurent.Waiter;
import RestaurentManagementConsole.KitchenManagers.Chef;
import RestaurentManagementConsole.KitchenManagers.Cook;
import RestaurentManagementConsole.Restaurent.RestaurentManagementFunctions;
import RestaurentManagementConsole.menu.Item;
import RestaurentManagementConsole.menu.Menu;
import RestaurentManagementConsole.menu.Starter;

public class ManagerUI {
    private RestaurentManagementFunctions managerInterface = Restaurent.getInstanceRestaurent();

    public void enterRestaurent() {
        Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(
                        "press 1 for Adding Waiter  \n 2 to add cook \n 3 for adding chef \n 4 for adding tablenumber to waiter \n 5 for deleting table number for waiter \n 6 for Adding items in menu \n 7 for altering the food pirce \n 8 for deleting food");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("enter name for adding waiter");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("enter id for adding");
                        int id = scanner.nextInt();
                        Waiter w1 = new Waiter(id, name);
                        managerInterface.addWaitersToRestaurent(w1);
                        break;

                    case 2:
                        System.out.println("enter cook to add ");
                        scanner.nextLine();
                        String name1 = scanner.nextLine();
                        System.out.println("enter id for adding");
                        int id1 = scanner.nextInt();
                        Cook cook = new Cook(id1, name1);
                        managerInterface.addWorkerToRestaurent(cook);
                        break;

                    case 3:
                        System.out.println("enter chef to add ");
                        scanner.nextLine();
                        String name2 = scanner.nextLine();
                        System.out.println("enter id for adding");
                        int id2 = scanner.nextInt();
                        Chef chef = new Chef(id2, name2);
                        managerInterface.addChefToRestaurent(chef);
                        break;

                    case 4:
                        System.out.println("enter waiterid to add tablenumer available ids are ");
                        int waiterid = scanner.nextInt();
                        List<String> tableForThisWaiter = managerInterface
                                .returnTableNumbers(waiterid);
                        System.out.println(tableForThisWaiter);
                        System.out.println("enter tablenumber to add");
                        scanner.nextLine();
                        String addtablenumber = scanner.nextLine();

                        if (tableForThisWaiter.contains(addtablenumber)) {
                            System.out.println("please enter other table number than this " + tableForThisWaiter);
                        } else {
                            managerInterface.addTableNumbersToWaiters(addtablenumber, waiterid);
                        }
                        break;

                    case 5:
                        System.out.println("enter waiterid to add tablenumer available ids are ");
                        int waiterid1 = scanner.nextInt();
                        List<String> tableForThisWaiter1 = managerInterface
                                .returnTableNumbers(waiterid1);
                        System.out.println(tableForThisWaiter1);
                        System.out.println("enter tablenumber to delete");
                        scanner.nextLine();
                        String deletetablenumber = scanner.nextLine();

                        if (tableForThisWaiter1.contains(deletetablenumber)) {
                            System.out.println(Restaurent.getInstanceRestaurent().returnTableNumbers(waiterid1));
                            managerInterface.deleteTableNumberforWaiter(deletetablenumber, waiterid1);
                        } else {
                            System.out.println("please enter available table number");
                            System.out.println("Available tablenumbers are " + tableForThisWaiter1);
                        }

                        break;

                    case 6:
                        System.out.println("food available are ");
                        Menu menu = managerInterface.getFullMenu();
                        menu.showMenu();
                        System.out.println("enter foodbname to add");
                        scanner.nextLine();
                        String foodname = scanner.nextLine();
                        System.out.println("enter price to add");
                        int price = scanner.nextInt();
                        System.out.println("enter category veg or nonveg for veg press 1 or nonveg press 2");
                        int category = scanner.nextInt();
                        System.out.println("enter 1 for starter 2 for not a starter");
                        int starter = scanner.nextInt();
                        Item item = new Item(foodname, price,
                                RestaurentManagementConsole.menu.Classificaton.contains(category),Starter.contains(starter));
                        menu.addMenusItems(item);
                        break;

                    case 7:
                        System.out.println("food available are ");
                        Menu menu1 = managerInterface.getFullMenu();
                        menu1.showMenu();
                        System.out.println("enter foodname to alter");
                        scanner.nextLine();
                        String foodname2 = scanner.nextLine();
                        System.out.println("enter price to alter");
                        int price2 = scanner.nextInt();
                        menu1.alterMenuItems(foodname2, price2);
                        break;

                    case 8:
                        System.out.println("food available are ");
                        Menu menu2 = managerInterface.getFullMenu();
                        menu2.showMenu();
                        System.out.println("enter foodname to delete from menu");
                        scanner.nextLine();
                        String foodname3 = scanner.nextLine();
                        menu2.deleteMenuItems(foodname3);
                        break;

                }
                System.out.println("if you want to exit press 1");
                int exit = scanner.nextInt();
                if (exit == 1) {
                    break;
                } else {
                    continue;
                }
            }
        
    }
}
