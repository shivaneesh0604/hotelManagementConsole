package hotelManagementConsole.menu;

public class Item {

    private final String foodName;
    private int price;
    private final String category;// V-veg NV-nonveg

    public Item(String foodName, int price, String VegORNonveg) {
        this.foodName = foodName;
        this.price = price;
        this.category = VegORNonveg;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
