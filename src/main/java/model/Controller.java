package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Exceptions.*;
import structures.*;

// Import para persistencia

import java.util.ArrayList;

public class Controller {

    private SinglyLinkedList<Chest> chests; // Lista de cofres
    private final Clock clock;
    private ArrayList<PlantedCrop> plantedCrops;
    private SinglyLinkedList<PlantedCrop> crops;


    public Controller() {
        this.chests = new SinglyLinkedList<>();
        this.crops = new SinglyLinkedList<>();
        this.plantedCrops = new ArrayList<>();
        this.clock = new Clock();
    }

    public String createChest(String name) {
        for (Chest chest : chests) {
            if (chest.getName().equals(name)) {
                return "Chest with the name " + name + " already exists.";
            }
        }
        // Si no se encontró ningún cofre con ese nombre, se crea uno nuevo
        Chest newChest = new Chest(name);
        chests.add(newChest);
        return "Chest with the name " + name + " added.";
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

    /**
     * Searches for a chest by its name in the collection of chests.
     *
     * @param name The name of the chest to search for.
     * @return True if the chest is found, otherwise false.
     */
    public boolean searchChestBoolean(String name) {
        Node<Chest> found = chests.search(name);

        if (found != null) {
            return true; // Cofre encontrado
        } else {
            return false; // Cofre no encontrado
        }
    }

    public String findChestContents(String name) {
        try {
            Chest chest = searchChest(name); // Busca el cofre
            return chest.showChestContents(); // Devuelve el contenido
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

    public String addCropToChest(String nameChest, String nameCrop, int quantity){
        Chest found = chests.search(nameChest).getData();
        PlantedCrop crop = findCropByName(nameCrop);
        if(found != null){
            found.addCrop(crop, quantity);
            return "Crop with the name" + nameCrop + " added";
        } else {
            return "Chest with the name" + nameChest + " not found"; // Crear excepcion
        }
    }

    public boolean sortCropsInChest(String chestLocation, int option, boolean ascending) {
        Chest chest = searchChest(chestLocation);
        if (chest != null) {
            SinglyLinkedList<PlantedCrop> cropsInChest = chest.getCrops();
            switch (option) {
                case 1:
                    // Ordenar por nombre
                    cropsInChest.sortByName(ascending);
                    break;
                case 2:
                    // Ordenar por días de crecimiento
                    cropsInChest.insertionSortByGrowthDays(ascending);
                    break;
                default:
                    System.out.println("Opción inválida");
                    return false;
            }
            chest.setCrops(cropsInChest);
            return true;
        } else {
            System.out.println("Cofre no encontrado");
            return false;
        }
    }

    // Mostrar todos los cofres con sus cultivos
    public void displayChests() {
        System.out.println("Lista de cofres:");
        for (Chest chest : chests) {
            System.out.println(
                    "Cofre en la ubicación " + chest.getName() + " con etiqueta " + chest.getType());
            chest.showChestContents(); // Mostrar los cultivos en el cofre
        }
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

    //Crear un nuevo crop
    public String createCrop(String name, int quantity){

        if(checkIfCanBePlanted(name)){
            plantedCrops.add(new PlantedCrop(name, quantity));
        }

        PlantedCrop newCrop = new PlantedCrop(name, quantity);
        crops.add(newCrop);
        return "Culitvo: " + name + " agregado de manera exitosa!";
    }

    public PlantedCrop findCropByName(String nameCrop){
        Node<PlantedCrop> found = crops.search(nameCrop);

        if (found != null) {
            return found.getData(); // Devuelve el crop si es encontrado
        } else {
            throw new CropNotFoundException("Crop with name " + nameCrop + " not found.");
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

    public String saveChests(String file){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(chests, writer); // Guardar la lista de cofres en el archivo
            return "Chests saved successfully.";
        } catch (IOException e) {
            return "Error saving chests: " + e.getMessage();
        }

    }

    public String loadChests(String file){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            // Define el tipo de la lista de cofres para que Gson lo interprete correctamente
            Type chestListType = new TypeToken<SinglyLinkedList<Chest>>(){}.getType();
            chests = gson.fromJson(reader, chestListType); // Cargar la lista de cofres desde el archivo
            return "Chests loaded successfully.";
        } catch (IOException e) {
            return "Error loading chests: " + e.getMessage();
        }
    }

}
