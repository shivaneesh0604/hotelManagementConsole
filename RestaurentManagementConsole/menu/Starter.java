package RestaurentManagementConsole.menu;

public enum Starter {
    STARTER,NOTSTARTER;
    public static Starter contains(int category) {
        if (category == 1) {
          return Starter.STARTER;
        } else {
          return Starter.NOTSTARTER;
        }
      }
}
