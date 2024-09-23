package model;

import structures.*;

public class Chest implements Getters {

    private String name;
    private LabelChest type;
    private SinglyLinkedList<Stack> stacks;
    private static final int MAX_SLOTS = 50;

    public Chest(String name) {
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

    public boolean addCrop(PlantedCrop plantedCrop, int quantity) {
        boolean added = false;
        boolean full = isFull();
        if (full = false) {
            // Se itera entre los stacks
            for (Stack stack : stacks) {

                // Si el primero esta vacio lo guarda alli
                if (stack.isEmpty()) {
                    stack.setCrop(plantedCrop, quantity);
                    added = true;
                    return added;

                    // Valida que el cultivo ya guardado en ese Stack sea el mismo que vamos a guardar
                } else if (stack.getCrop().getName().equals(plantedCrop.getName())) {
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
    public int showOccupiedStack() {
        int occupiedStacks = stacks.getSize();
        return occupiedStacks;
    }

    // verificar si el cofre esta lleno
    public boolean isFull() {
        return stacks.getSize() == MAX_SLOTS;
    }

    // Eliminar un cultivo de los cofres
    public boolean removeCrop(String cropName) {
        boolean removed = false;
        for (Stack stack : stacks) {
            if (stack.getCrop().getName().equals(cropName)) {
                stacks.remove(stack);
                removed = true;
            }
        }
        return removed;
    }

    public void clearChest() {
        stacks.clean();
    }

    public String showChestContents() {
        StringBuilder result = new StringBuilder();

        if (stacks.isEmpty()) {
            result.append("Chest is empty\n");
        } else {
            result.append("Chest contents:\n");
            result.append("Stack in use: ").append(stacks.getSize()).append("\n");

            for (Stack stack : stacks) {
                result.append(stack.toString()).append("\n");
            }
        }

        return result.toString(); // Convierte StringBuilder a String y lo devuelve
    }
}