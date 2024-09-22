package model;

import java.util.ArrayList;

public class Controller {

    private final Clock clock;
    private ArrayList<PlantedCrop> plantedCrops;

    public Controller() {
        this.plantedCrops = new ArrayList<>();
        this.clock = new Clock();
    }

    public void changeDays(int amount){

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
