package model;

import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import structures.*;

// Import para persistencia

public class Controller {

    private SinglyLinkedList<Chest> chests; // Lista de cofres

    public Controller() {
        chests = new SinglyLinkedList<>();
    }

    public String createChest(String name){
        String message = "";
        for(Chest chest: chests){
            if(chest.getName().equals(name)){
                message = "Chest with the name" + name + " already exists";
                break;
            } else {
                Chest newChest = new Chest(name);
                chests.add(newChest);
                message = "Chest with the name" + name + " added";
            }
        }
        return message;
    }

    public Chest searchChest(String name){
        Node<Chest> found = chests.search(name);

        if(found != null){
            return found.getData();
        } else {
            return null; // Crear una excepcion para cuando no se encuentre el cofre
        }
    }




}
