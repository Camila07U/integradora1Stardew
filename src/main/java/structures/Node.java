package structures;


public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next)
    {
        this.data = data;
        this.next = null;
    }

    public Node(Crop crop) {
        this.data = (E) crop;
        this.next = null;
    }

    public Node(Chest chest)
    {
        this.data = (E) chest;
        this.next = null;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public Node<E> getNext()
    {
        return next;
    }

    public void setNext(Node<E> next)
    {
        this.next = next;
    }
}