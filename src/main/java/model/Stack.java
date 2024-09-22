package model;

import structures.Getters;

public class Stack implements Getters {

    private PlantedCrop plantedCrop;
    private int quantity;
    private static final int MAX_STACKS_FOR_SLOT = 25;
    

    public Stack() {
        this.plantedCrop = null;
        this.quantity = 0;
    }

    public Stack(PlantedCrop item, int quantity) {
        if (quantity <= MAX_STACKS_FOR_SLOT) {
            this.plantedCrop = item;
            this.quantity = quantity;
        } else {
            System.out.println("Max 25 Stack for Slot"); // Crear excepcion
        }
    }
    
    @Override
    public String getName() {
        return "";
    }

    public PlantedCrop getCrop() {
        return plantedCrop;
    }

    public void setCrop(PlantedCrop plantedCrop) {
        this.plantedCrop = plantedCrop;
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
        return plantedCrop == null;
    }

    // Asignar un cultivo a un Stack
    public void setCrop(PlantedCrop plantedCrop, int quantity) {
        if (quantity <= MAX_STACKS_FOR_SLOT) {
            this.plantedCrop = plantedCrop;
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
        this.plantedCrop = null;
        this.quantity = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        } else {
            return "Crop: " + plantedCrop.getName() + "\n Quantity: " + quantity + "\n + ";
        }
    }

}
