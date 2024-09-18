package model;

import structures.SinglyLinkedList;

public class Chest {

    private String name;
    private String type;
    private SinglyLinkedList<Stack> Stack;
    private static final int MAX_SLOTS = 50;

    public Chest(String name, String type, SinglyLinkedList<model.Stack> stack) {
        this.name = name;
        this.type = type;
        Stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SinglyLinkedList<model.Stack> getStack() {
        return Stack;
    }

    public void setStack(SinglyLinkedList<model.Stack> stack) {
        Stack = stack;
    }
}
