package model;

public class Stack {

    private Crop crop;
    private int quantity;
    private static final int MAX_STACKS_FOR_SLOT = 25;

    

    public Stack() {
        this.crop = null;
        this.quantity = 0;
    }

    public Stack(Crop item, int quantity) {
        if (quantity <= MAX_STACKS_FOR_SLOT) {
            this.crop = item;
            this.quantity = quantity;
        } else {
            System.out.println("Max 25 Stack for Slot"); // Crear excepcion
        }
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Metodos aparte

    // Verifica si el stack esta vacio
    public boolean isEmpty() {
        return crop == null;
    }

    // Asignar un cultivo a un Stack
    public void setCrop(Crop crop, int quantity) {
        if (quantity <= MAX_STACKS_FOR_SLOT) {
            this.crop = crop;
            this.quantity = quantity;
        } else {
            System.out.println("Max 25 Stack for Slot"); // Crear excepcion a esto
        }
    }

    // Aumentar la cantidad de crop de un Stack
    public void incrementQuantity(int quantity) {
        if(this.quantity + quantity <= MAX_STACKS_FOR_SLOT) {
            this.quantity += quantity;
        } else {
            System.out.println("Max 25 Stack for Slot"); // Crear excepcion a esto
        }
    }

    // Vaciar un stack
    public void clearStack(){
        this.crop = null;
        this.quantity = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        } else {
            return "Crop: " + crop.getName() + "\nType: " + crop.getStation() + "\n Quantity: " + quantity + "\n + ";
        }
    }
}
