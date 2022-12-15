package RestaurentManagementConsole.Orders;

public class NewOrder {

    private final String foodname;
    private int quantity;
    private boolean delivered = false;
    public NewOrder(String foodname, int quantity) {
        this.foodname = foodname;
        this.quantity = quantity;
    }
    
    public String getFoodname() {
        return foodname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    
}
