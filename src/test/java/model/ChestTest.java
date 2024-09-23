package model;

import model.Chest;
import model.LabelChest;
import model.PlantedCrop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChestTest {

    @Test
    public void testAddCrop() {
        //Setup
        Chest chest = new Chest("Test Chest");
        PlantedCrop Crop = new PlantedCrop("Gartic", 10);

        //Test case 1: Add crop to empty chest
        assertTrue(chest.addCrop(Crop, 5));

        //Test case 2: Add same crop to chest again
        assertTrue(chest.addCrop(Crop, 5));

        //Test case 3: Add different crop to chest with existing crops
        PlantedCrop cornCrop = new PlantedCrop("Corn", 10);
        assertTrue(chest.addCrop(cornCrop, 5));

        //Fill the chest to maximum
        for (int i = 0; i < 47; i++) {
            PlantedCrop sampleCrop = new PlantedCrop("Crop" + i, 10);
            assertTrue(chest.addCrop(sampleCrop, 5));
        }

        //Test case 4: Add crop to full chest
        PlantedCrop wheatCrop = new PlantedCrop("Wheat", 10);
        assertFalse(chest.addCrop(wheatCrop, 5));

        //Test case 5: Add crop with negative quantity 
        PlantedCrop riceCrop = new PlantedCrop("Rice", 10);
        assertFalse(chest.addCrop(riceCrop, -5));

    }
}