package model;

public class Stack {

    private Crop item;
    private int quantity;
    private static final int MAX_STACKS_FOR_SLOT = 25;

    

    public Stack() {
        this.item = null;
        this.quantity = 0;
    }

    public Stack(Crop item, int quantity) {
        if(quantity <= MAX_STACKS_FOR_SLOT){
        this.item = item;
        this.quantity = quantity;
    } else {
        System.out.println("Max 25 Stack for Slot");
    }
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
