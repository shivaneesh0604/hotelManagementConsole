package RestaurentManagementConsole.menu;

public class Item {

    private final String foodName;
    private int price;
    private final Classificaton category;// V-veg NV-nonveg
    private final Starter starter;

    public Item(String foodName, int price, Classificaton classification,Starter starter) {
        this.foodName = foodName;
        this.price = price;
        this.category = classification;
        this.starter = starter;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public Classificaton getCategory() {
        return category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Starter getStarter() {
        return starter;
    }
}
