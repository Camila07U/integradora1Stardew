package model;

public class CropType {

    public Season Type(String name){

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
}
