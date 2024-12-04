package model;

import structures.Getters;

public class PlantedCrop implements Getters {

    private String name;
    private int days;
    private int quantity;
    private int min = 5;
    private Season cropType;
    private CropStatus status;


    public PlantedCrop(String name, int quantity){
        this.name = name;
        this.status = CropStatus.READY;
        this.days=0;
        this.quantity=quantity;
        this.cropType = this.getCropTypeByName(name);
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

    private Season getCropTypeByName(String name) {
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


    public String getName() {
        return name;
    }


    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Season getCropType() {
        return cropType;
    }

    public void setCropType(Season cropType) {
        this.cropType = cropType;
    }

    public String toString() {
        return "Name =" + name + "amount"+ quantity +", Days =" + days + ", Status =" + getStatus();
    }
}
