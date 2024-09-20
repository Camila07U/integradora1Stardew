package model;

import structures.*;

public class Chest {

    private String name;
    private LabelChest type;
    private SinglyLinkedList<Stack> stacks;
    private static final int MAX_SLOTS = 50;

    public Chest(String name, LabelChest type) {
        this.name = name;
        this.type = LabelChest.DEFAULT;
        stacks = new SinglyLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LabelChest getType() {
        return type;
    }

    public void setType(LabelChest type) {
        this.type = type;
    }

    public SinglyLinkedList<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(SinglyLinkedList<Stack> stacks) {
        this.stacks = stacks;
    }

    // Metodos aparte

    public boolean addCrop(Crop crop, int quantity) {
        boolean added = false;
        boolean full = isFull();
        if (full = false) {
            // Se itera entre los stacks
            for (Stack stack : stacks) {

                // Si el primero esta vacio lo guarda alli
                if (stack.isEmpty()) {
                    stack.setCrop(crop, quantity);
                    added = true;
                    return added;

                    // Valida que el cultivo ya guardado en ese Stack sea el mismo que vamos a guardar
                } else if (stack.getCrop().getName().equals(crop.getName())) {
                    stack.incrementQuantity(quantity);
                    added = true;
                    return added;
                } else {
                    System.out.println("Cantidad excede el limite maximo de 25 stacks por espacio");
                }
            }
            System.out.println("Chest full, add in other Chest"); // Excepcion creo
        }
        return added;
    }

    // Dar el numero de stacks en uso
    public int showOccupiedStack(){
        int occupiedStacks = stacks.getSize();
        return occupiedStacks;
    }

    // verificar si el cofre esta lleno
    public boolean isFull(){
        return stacks.getSize() == MAX_SLOTS;
    }

    // Eliminar un cultivo de los cofres
    public boolean removeCrop(String cropName){
        boolean removed = false;
        for(Stack stack : stacks){
            if(stack.getCrop().getName().equals(cropName)){
                stacks.remove(stack);
                removed = true;
            }
        }
        return removed;
    }

    public void clearChest(){
        stacks.clean();
    }

    public void showChestContents(){
        if(stacks.isEmpty()){
            System.out.println("Chest is empty");
        } else {
            System.out.println("Chest contents:");
            System.out.println("Stack in use: " + stacks.getSize());
            for(Stack stack : stacks){
                System.out.println(stack.toString());
            }
        }
    }
}
