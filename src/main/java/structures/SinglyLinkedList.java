package structures;

import java.util.Comparator;

public class SinglyLinkedList<E> {

    private Node<E> root, tail;

    public SinglyLinkedList() {
        root = null;
        tail = null;
    }

    public boolean isEmpty() {
        return (root == null || tail == null);
    }

    public void appendNode(Node<E> newNode) {
        if (isEmpty()) {
            root = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int size()
    {
        int count = 0;
        Node<E> current = root;
        while (current != null)
        {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void insertionSort(Comparator<E> comparator)
    {
        if(root == null || root.getNext() == null)
        {
            return;
        }

        Node<E> sortedList = null;

        while(root != null) {
            Node<E> current = root;
            root = root.getNext();

            if (sortedList == null || comparator.compare(current.getData(), sortedList.getData()) <= 0)
            {
                current.setNext(sortedList);
                sortedList = current;
            } else {
                Node<E> temp = sortedList;
                while (temp.getNext() != null && comparator.compare(current.getData(), temp.getNext().getData()) > 0)
                {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
        }
        root = sortedList;
    }
}