package structures;

import java.util.Iterator;

public class SinglyLinkedList<T extends Getters> implements Iterable<T> {

    private Node<T> root;
    private int size;

    public SinglyLinkedList() {
        this.root = null;
        this.size = 0;
    }

    // Obtiene el tamaño de la linkedList
    public int getSize() {
        return size;
    }


    // MEtodo para agregar un elemento
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        // Verifica si la lista esta vacia
        // Si lo esta crea el nuevo node
        if (isEmpty()) {
            root = newNode;

            // Itera entre los nodos hasta que encuentra el siguiente vacio y se agrega y aumenta el contador del tamaña
        } else {
            Node<T> current = root;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Node<T> search(String name) {
        Node<T> found = null;

        // Caso base
        if(root.getData().getName().equals(name)){
            found = root;

        } else {  // Caso iterativo
            Node<T> current = root;

            while(current.getNext() != null && !current.getNext().getData().getName().equals(name)){
                current = current.getNext();
            }
            if(current.getNext() != null){
                found = current.getNext();
            } else {
                found = null;
            }
        }

        return found;
    }

    // Metodo para verificar si esta vacia
    public boolean isEmpty() {
        return root == null;
    }

    // Metodo para elminar un node
    public boolean remove(T data){
        boolean found = false;
        // Si no hay nodos
        if(root == null){
            return found;
        }

        // Si el nodo a eliminar es el primero
        if(root.getData().equals(data)){
            root = root.getNext();
            size--;
            found = true;
            return found;
        }

        // Buscar el nodo que se va eliminar
        Node<T> current = root;
        while(current.getNext() != null && !current.getNext().getData().equals(data)){
            current = current.getNext();
        }

        // Si se encuentra el nodo a eliminar, se elimina
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            size--;
            found = true;
            return found;
        }

        return found;
    }

    // Mostrar los elementos de la linked list
    public void printLinkedList(){
        Node<T> current = root;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    //Iterador para iterar entre las linkedList
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    // Clase interna que implementa un iterador personalizado para la lista enlazada
    private class CustomIterator implements Iterator<T> {
        private Node<T> current = root;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                System.out.println("No hay elementos que devolver");
            }
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }

    // Dejar la lista vacia
    public void clean(){
        root = null;
        size = 0;
    }
}