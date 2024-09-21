package model;

import java.util.ArrayList;

public class Controller {

    private final Clock clock;
    private ArrayList<Crop> crops;

    public Controller() {
        this.crops = new ArrayList<>();
        this.clock = new Clock();
    }

    public void addCrop(String name){

        
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

        clock.advanceDays(days);

        for(int i=0; i<crops.size(); i++){

            for(int j=0; j<days; j++){

                crops.get(i).grow();

            }

        }

    }

    public String cropList(){


    }




}
