package model;

public class Crop {

    private String name;
    private Season station;
    private int days;
    private int min = 15;
    private int max = 27;
    private CropStatus status;

    public Crop(String name, Season station) {

        this.name = name;
        this.station = station;

    }

    public void grow() {
        days++;
    }

    public CropStatus getStatus() {

        if (days < min) {
            status = CropStatus.NOT_READY;
        } else if (days <= max) {
            status = CropStatus.READY;
        } else {
            status = CropStatus.ROTTEN;
        }

        return status;
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

    public String toString() {
        return "Name =" + name + ", Days =" + days + ", Status =" + getStatus();
    }
}
