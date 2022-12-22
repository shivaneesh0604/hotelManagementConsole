package RestaurentManagementConsole.menu;

public enum Classificaton {
  VEG, NONVEG;

  public static Classificaton contains(int category) {
    if (category == 1) {
      return Classificaton.VEG;
    } else {
      return Classificaton.NONVEG;
    }
  }
}
