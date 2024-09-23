package model;

import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import Exceptions.*;
import structures.*;

// Import para persistencia

import java.util.ArrayList;

public class Controller {

    private SinglyLinkedList<Chest> chests; // Lista de cofres
    private final Clock clock;
    private ArrayList<PlantedCrop> plantedCrops;


    public Controller() {
        chests = new SinglyLinkedList<>();
        this.plantedCrops = new ArrayList<>();
        this.clock = new Clock();
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


    /**
     * Searches for a chest by its name in the collection of chests.
     *
     * @param name The name of the chest to search for.
     * @return The found chest if it exists, otherwise null.
     */
    public Chest searchChest(String name) {
        Node<Chest> found = chests.search(name);

        if (found != null) {
            return found.getData(); // Devuelve el cofre si es encontrado
        } else {
            throw new ChestNotFoundException("Chest with name " + name + " not found.");
        }
    }

    public String findChestContents(String name) {
        try {
            Chest chest = searchChest(name); // Busca el cofre
            return chest.showChestContents().toString(); // Devuelve el contenido
        } catch (ChestNotFoundException e) {
            return e.getMessage(); // Muestra el mensaje de la excepción
        }
    }

    /**
     * Removes a chest with the specified name from the collection of chests.
     * @param name The name of the chest to be removed.
     * @return A message indicating whether the chest was successfully removed or not.
     */
    public String removeChest(String name){
        String message = "";
        Node<Chest> found = chests.search(name);

        if(found != null){
            boolean removeChest = chests.remove(found.getData());
            if(removeChest){
                message = "Chest with the name" + name + " removed";
            } else {
                message = "Chest with the name" + name + " not found";
            }
        }
        return message;
    }

    public void changeDays(int amount) {

        int days = 0;

        switch (amount){

            case 1: days = 1;

            case 2: days = 5;

            case 3: days = 10;

            case 4: days = 30;

            case 5: days = 60;
        }

        if(clock.advanceDays(days)){
            changeToRotten();
        }

        for(int i = 0; i< plantedCrops.size(); i++){

            for(int j=0; j<days; j++){

                plantedCrops.get(i).grow();

            }

        }

    }

    private void changeToRotten() {
        for(int i = 0; i<plantedCrops.size(); i++){
            if(cropSeason(plantedCrops.get(i).getName())!=Season.OTHERS){
                plantedCrops.get(i).setStatus(CropStatus.ROTTEN);
            }
        }
    }

    public Season cropSeason(String name){

        return switch (name) {
            // Spring crops
            case "Garlic", "Blue Allium", "Unmilled Rice", "Parsnip" -> Season.SPRING;

            // Summer crops
            case "Poppy", "Blueberry", "Starfruit", "Hot Pepper" -> Season.SUMMER;

            // Autumn crops
            case "Artichoke", "Amaranth", "Sweet Gem Berry", "Eggplant" -> Season.AUTUMN;

            // Winter crops
            case "Winter Melon" -> Season.WINTER;

            // Other crops
            case "Fiber", "Ancient Fruit", "Qi Fruit" -> Season.OTHERS;

            default -> Season.OTHERS;
        };

    }

    //revisa si puede ser plantada en la estación actual
    public boolean checkIfCanBePlanted(String name){

        Season actual = clock.getSeason();
        Season cropSeason = cropSeason(name);

        if(cropSeason == actual || cropSeason == Season.OTHERS){

            return true;
        }else{
            return false;
        }

    }

    //planta un nuevo crop
    public void newPlantedCrop(String name, int amount){

        if(checkIfCanBePlanted(name)){
            plantedCrops.add(new PlantedCrop(name, amount));
        }
    }

    //lista de los cultivos plantados y su estatus
    public String listCropsStatus(){

        StringBuilder list = new StringBuilder();

        for(int i = 0; i < plantedCrops.size(); i++){
            list.append(plantedCrops.get(i).toString()).append("\n");
        }

        return list.toString();
    }

}
