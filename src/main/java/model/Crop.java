package model;

public class Crop {

    private String name;
    private Season station;
    private int days;
    private int min=15;
    private int max=27;
    private boolean rotten;

    public Crop(String name, Season station) {

        this.name = name;
        this.station = station;

    }

    public void grow() {
        if(!rotten){
            days++;
            if(days > max){
                rotten = true;
            }
        }
    }

    public boolean isReady(){
        return days >= min && days <= max;
    }

    public boolean isRotten() {
        return rotten;
    }

    public String getName() {
        return name;
    }
    
    public Season getStation() {
        return station;
    }

    public int getDays() {
        return days;
    }
}
