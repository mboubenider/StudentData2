
public class Items {
    private String ItemName;
    private int ItemCode;
    private double ItemPrice;
    private int ItemQuantity;
    private double ItemDiscount;
    private int phoneNumber;

    public Items(String ItemName, int code, int quantity, double discount, double price, int phone) {
        this.ItemName = ItemName;
        this.ItemCode = code;
        this.ItemQuantity = quantity;
        this.ItemDiscount = discount;
        this.ItemPrice = price;
        this.phoneNumber = phone;
    }

    public String getItemName() {
        return ItemName;
    }
    public void setItemName(String name) {
        this.ItemName = name;
    }
    public double getItemCode() {
        return ItemCode;
    }
    public void setItemCode(int code) {
        this.ItemCode = code;
    }
    public double getItemQuantity() {
        return ItemQuantity;
    }
    public void setItemQuantiy(int quantity) {
        this.ItemCode = quantity;
    }
    public double getItemDiscount() { return ItemDiscount; }
    public void setItemDiscount(double discount) {
        this.ItemDiscount = discount;
    }
    public double getItemPrice() {
        return ItemPrice;
    }
    public void setItemPrice(double price) { this.ItemPrice = price; }

    public double getphoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phone) { this.phoneNumber = phone; }

    @Override
    public String toString() {
        return ItemName + " ($" + ItemPrice + ")";
    }
}