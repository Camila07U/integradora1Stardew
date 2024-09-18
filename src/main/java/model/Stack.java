package model;

public class Stack {

    private Crop item;
    private int quantity;
    private static final int MAX_STACKS_FOR_SLOT = 25;

    public Stack(Crop item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Crop getItem() {
        return item;
    }

    public void setItem(Crop item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
