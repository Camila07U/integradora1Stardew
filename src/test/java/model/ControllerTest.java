package model;

import model.Controller;
import model.Chest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void createChestWithNameAWhenChestNotExistsShouldReturnMessageThatChestAdded() {
        // Arrange
        Controller controller = new Controller();
        String chestName = "A";

        // Act
        String result = controller.createChest(chestName);

        // Assert
        assertEquals("Chest with the nameA added", result);
    }

    @Test
    public void createChestWithNameAWhenChestExistsShouldReturnMessageThatChestAlreadyExists() {
        // Arrange
        Controller controller = new Controller();
        String chestName = "A";
        controller.createChest(chestName); // Chest created first time

        // Act
        String result = controller.createChest(chestName); // Attempt to create with same name

        // Assert
        assertEquals("Chest with the nameA already exists", result);
    }

    @Test
    public void createChestWithNameBWhenChestExistsShouldReturnMessageThatChestAdded() {
        // Arrange
        Controller controller = new Controller();
        String chestNameA = "A";
        String chestNameB = "B";
        controller.createChest(chestNameA); // Chest A created first time

        // Act
        String result = controller.createChest(chestNameB); // Attempt to create Chest B

        // Assert
        assertEquals("Chest with the nameB added", result);
    }

    @Test
    public void createChestWithEmptyNameShouldReturnMessageThatChestAdded() {
        // Arrange
        Controller controller = new Controller();
        String emptyChestName = "";

        // Act
        String result = controller.createChest(emptyChestName);

        // Assert
        assertEquals("Chest with the name added", result);
    }
}