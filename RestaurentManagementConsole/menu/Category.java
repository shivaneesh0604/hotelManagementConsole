package RestaurentManagementConsole.menu;

public enum Category {
  VEG, NONVEG;

  public static Category contains(int category) {
    if (category == 1) {
      return Category.VEG;
    } else {
      return Category.NONVEG;
    }
  }
}
