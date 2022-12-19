package RestaurentManagementConsole.menu;

public class Item {

    private final String foodName;
    private int price;
    private final Category category;// V-veg NV-nonveg

    public Item(String foodName, int price, Category category) {
        this.foodName = foodName;
        this.price = price;
        this.category = category;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
