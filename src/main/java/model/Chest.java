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

        // Verificar si el cofre está lleno
        if (isFull()) {
            System.out.println("Chest full, add in other Chest");
            return false;
        }

        // Iterar sobre los stacks existentes para agregar el cultivo
        for (Stack stack : stacks) {
            // Si el stack está vacío, crear uno nuevo y agregar el cultivo
            if (stack.isEmpty()) {
                stack = new Stack(plantedCrop, quantity);  // Crear nuevo stack con el cultivo
                stacks.add(stack);  // Agregar el nuevo stack al cofre
                added = true;
                return added;
            }

            // Si el cultivo ya está en el stack
            if (stack.getCrop().getName().equals(plantedCrop.getName())) {
                int availableSpace = 25 - stack.getQuantity();  // Calcular el espacio disponible en el stack actual

                // Si hay espacio suficiente en el stack actual, agregar al stack
                if (quantity <= availableSpace) {
                    stack.incrementQuantity(quantity);  // Utilizamos el metodo incrementQuantity
                    added = true;
                    return added;
                } else {
                    // Agregar la cantidad que cabe en el stack actual
                    stack.incrementQuantity(availableSpace);
                    quantity -= availableSpace;  // Reducir la cantidad restante

                    // Crear un nuevo stack para la cantidad restante si todavía queda
                    if (quantity > 0) {
                        Stack newStack = new Stack(plantedCrop, quantity);
                        stacks.add(newStack);  // Agregar el nuevo stack al cofre
                        added = true;
                    }
                    return added;
                }
            }
        }

        // Si no hay ningún stack con el cultivo, crear uno nuevo
        Stack newStack = new Stack(plantedCrop, quantity);
        stacks.add(newStack);
        added = true;

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

    // Método para obtener los cultivos del cofre
    public SinglyLinkedList<PlantedCrop> getCrops() {
        SinglyLinkedList<PlantedCrop> crops = new SinglyLinkedList<>();
        for (Stack stack : stacks) {
            crops.add(stack.getCrop());
        }
        return crops;
    }

    // Método para establecer los cultivos del cofre
    public void setCrops(SinglyLinkedList<PlantedCrop> crops) {
        clearChest();
        for (PlantedCrop crop : crops) {
            addCrop(crop, 1); // Add each crop with a quantity of 1
        }
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