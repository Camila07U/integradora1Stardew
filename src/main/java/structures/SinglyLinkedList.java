package structures;

import java.util.Comparator;
import java.util.Iterator;

public class SinglyLinkedList<T> {

    private Node<T> root;
    private int size;

    public SinglyLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            while ()
        }
    }
}