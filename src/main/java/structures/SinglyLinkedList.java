package structures;

import model.PlantedCrop;
import model.Stack;

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

    public Node<T> getRoot() {
        return root;
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

    // Método para obtener los días de crecimiento de un cultivo almacenado en un
    // Space o un Crop
    public int getCropGrowthDays(T data) {
        if (data instanceof Stack) {
            Stack stack = (Stack) data;
            return stack.getCrop().getDays();
        } else if (data instanceof PlantedCrop) {
            PlantedCrop crop = (PlantedCrop) data;
            return crop.getDays();
        }
        throw new IllegalArgumentException("Tipo no soportado para la ordenación por días de crecimiento.");
    }

    // Ordenamiento
    /**
     * description: Método para ordenar la lista por días de crecimiento de los
     * cultivos (Insertion Sorting).
     *
     *
     **/
    public void insertionSortByGrowthDays(boolean ascending) {
        if (root == null || root.getNext() == null) {
            return;
        }

        Node<T> sortedList = null;
        Node<T> current = root;

        while (current != null) {
            Node<T> next = current.getNext();
            sortedList = sortedInsert(sortedList, current, ascending);
            current = next;
        }

        root = sortedList;
    }

    public Node<T> sortedInsert(Node<T> sortedList, Node<T> newNode, boolean ascending) {
        // Comparación entre nodos de tipo Crop
        if (sortedList == null
                || (ascending && getCropGrowthDays(sortedList.getData()) > getCropGrowthDays(newNode.getData()))
                || (!ascending && getCropGrowthDays(sortedList.getData()) < getCropGrowthDays(newNode.getData()))) {
            newNode.setNext(sortedList);
            sortedList = newNode;
        } else {
            Node<T> current = sortedList;
            while (current.getNext() != null && ((ascending
                    && getCropGrowthDays(current.getNext().getData()) <= getCropGrowthDays(newNode.getData()))
                    || (!ascending && getCropGrowthDays(current.getNext().getData()) >= getCropGrowthDays(
                    newNode.getData())))) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        return sortedList;
    }

    // Metodo para ordenar la lista por nombre de los cultivos
    public void sortByName(boolean ascending) {
        if (root == null || root.getNext() == null) {
            return;
        }

        Node<T> sortedList = null;
        Node<T> current = root;

        while (current != null) {
            Node<T> next = current.getNext();
            sortedList = sortedInsertByName(sortedList, current, ascending);
            current = next;
        }

        root = sortedList;
    }

    // Método auxiliar para la inserción ordenada por nombre
    public Node<T> sortedInsertByName(Node<T> sortedList, Node<T> newNode, boolean ascending) {
        // Comparación entre nodos de tipo Crop
        if (sortedList == null
                || (ascending && getCropName(sortedList.getData()).compareTo(getCropName(newNode.getData())) > 0)
                || (!ascending && getCropName(sortedList.getData()).compareTo(getCropName(newNode.getData())) < 0)) {
            newNode.setNext(sortedList);
            sortedList = newNode;
        } else {
            Node<T> current = sortedList;
            while (current.getNext() != null && ((ascending
                    && getCropName(current.getNext().getData()).compareTo(getCropName(newNode.getData())) <= 0)
                    || (!ascending && getCropName(current.getNext().getData())
                    .compareTo(getCropName(newNode.getData())) >= 0))) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        return sortedList;
    }

    // Obtener el nombre de un cultivo almacenado en un crop
    public String getCropName(T data) {
        if (data instanceof PlantedCrop) {
            PlantedCrop crop = (PlantedCrop) data;
            return crop.getName();
        }
        throw new IllegalArgumentException("Tipo no soportado para la ordenación por nombre.");
    }
}