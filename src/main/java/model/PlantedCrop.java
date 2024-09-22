package model;

public class PlantedCrop {

    private String name;
    private int days;
    private int quantity;
    private int min = 5;
    private CropStatus status;


    public PlantedCrop(String name, int quantity){
        this.name = name;
        this.days=0;
        this.quantity=quantity;
    }

    public void grow() {
        days++;
    }

    public void setStatus(CropStatus status) {
        this.status = status;
    }

    public CropStatus getStatus() {

        if (days < min) {
            status = CropStatus.NOT_READY;
        } else {
            status = CropStatus.READY;
        }

        return status;
    }


    public String getName() {
        return name;
    }


    public int getDays() {
        return days;
    }

    public String toString() {
        return "Name =" + name + "amount"+ quantity +", Days =" + days + ", Status =" + getStatus();
    }
}
