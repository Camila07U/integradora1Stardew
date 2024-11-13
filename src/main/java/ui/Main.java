package ui;

import java.util.Scanner;
import model.Controller;
import model.PlantedCrop;

public class Main {
    private Controller controller;
    public static Scanner sc = new Scanner(System.in);

    // Constructor de la clase Main
    public Main() {
        controller = new Controller(); // Asegúrate de inicializar tu controlador
    }

    public static void main(String[] args) {
        Main objMain = new Main();
        System.out.println("---Welcome to Stardew Valley---");

        boolean exit = false;
        int menu;

        do {
            menu = menuCode(); // Llamar al método del menú
            switch (menu) {
              //  case 1 -> objMain.generateTestSubjects();
                case 1 -> objMain.createChest();
                case 2 -> objMain.searchChest();
                case 3 -> objMain.removeChest();
                case 4 -> objMain.addCrop();
                case 5 -> objMain.createCrop();
                case 6 -> objMain.mostrarContenidoDeUnCofre();
                case 7 -> objMain.sortCropsInChest();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (!exit);
        System.out.println("Thank you for playing Stardew Valley!");
    }

    // Método del menú
    public static int menuCode() {
        int optionMenu;
        //System.out.println(" 0. To generate test subjects (collaborators, requests, areas, projects) ");
        System.out.println(" 1. To create the chest ");
        System.out.println(" 2. To search the chest ");
        System.out.println(" 3. To remove the chest ");
        System.out.println(" 4. To add Crop to the chest ");
        System.out.println(" 5. To create crop ");
        System.out.println(" 6. Mostrar contenido de un cofre ");
        System.out.println(" 7. Sort crops in Chest ");
        System.out.println(" 0. To exit ");
        optionMenu = sc.nextInt();
        sc.nextLine();
        return optionMenu;
    }

    public void createChest() {
        System.out.println("==========CREATE THE CHEST==========" + "\n");
        System.out.println("Enter the name chest: ");
        String name = sc.nextLine();
        String result = controller.createChest(name);
        System.out.println(result);
    }

    public void searchChest(){
        System.out.println("==========SEARCH THE CHEST==========" + "\n");
        System.out.println("Enter the name chest that want to search: ");
        String name = sc.nextLine();
        String result = String.valueOf(controller.findChestContents(name));
        System.out.println(result);
    }

    public void removeChest(){
        System.out.println("==========REMOVE THE CHEST==========" + "\n");
        System.out.println("Enter the name chest that want to remove: ");
        String name = sc.nextLine();
        String result = controller.removeChest(name);
        System.out.println(result);
    }

    public void listChests(){
        System.out.println("==========LIST CHESTS==========" + "\n");

    }

    public void addCrop(){
        System.out.println("=============ADD CROP============" + "\n");
        System.out.println("Enter the name chest: ");
        String nameChest = sc.nextLine();
        boolean chestExist = controller.searchChestBoolean(nameChest);
        if(chestExist) {
            System.out.println("Enter the name Crop");
            String nameCrop = sc.nextLine();
            System.out.println("Enter the quantity of Crop");
            int quantity = sc.nextInt();
            String result = controller.addCropToChest(nameChest, nameCrop, quantity);
            System.out.println(result);
        } else {
            System.out.println("Chest with name: " + nameChest + "Not found");
        }

    }

    public void createCrop() {
        System.out.println("===========CREATE CROP============" + "\n");
        String nameCrop = "";
        System.out.println("Seleccione el tipo de cultivo que desea crear: ");
        System.out.println("1. Spring");
        System.out.println("2. Summer");
        System.out.println("3. Autumn");
        System.out.println("4. Winter");
        System.out.println("5. Others");

        int optionMenu = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Seleccione el cultivo que desea crear: ");
        switch (optionMenu) {
            case 1:
                System.out.println("1. Garlic, 2. Blue Allium, 3. Unmilled Rice, 4. Parsnip");
                int optionNameCrop = sc.nextInt();
                switch (optionNameCrop) {
                    case 1 -> nameCrop = "Garlic";
                    case 2 -> nameCrop = "Blue Allium";
                    case 3 -> nameCrop = "Unmilled Rice";
                    case 4 -> nameCrop = "Parsnip";
                    default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
                break;

            case 2:
                System.out.println("1. Poppy, 2. Blueberry, 3. Starfruit, 4. Hot Pepper");
                optionNameCrop = sc.nextInt();
                switch (optionNameCrop) {
                    case 1 -> nameCrop = "Poppy";
                    case 2 -> nameCrop = "Blueberry";
                    case 3 -> nameCrop = "Starfruit";
                    case 4 -> nameCrop = "Hot Pepper";
                    default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
                break;

            case 3:
                System.out.println("1. Artichoke, 2. Amaranth, 3. Sweet Gem Berry, 4. Eggplant");
                optionNameCrop = sc.nextInt();
                switch (optionNameCrop) {
                    case 1 -> nameCrop = "Artichoke";
                    case 2 -> nameCrop = "Amaranth";
                    case 3 -> nameCrop = "Sweet Gem Berry";
                    case 4 -> nameCrop = "Eggplant";
                    default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
                break;

            case 4:
                System.out.println("1. Winter Melon");
                optionNameCrop = sc.nextInt();
                switch (optionNameCrop) {
                    case 1 -> nameCrop = "Winter Melon";
                    default -> System.out.println("Opcion no valida. Intentalo de nuevo");
               }
                break;

            case 5:
                System.out.println("1. Fiber, 2. Ancient Fruit, 3. Qi Fruit");
                optionNameCrop = sc.nextInt();
                switch (optionNameCrop) {
                    case 1 -> nameCrop = "Fiber";
                    case 2 -> nameCrop = "Ancient Fruit";
                    case 3 -> nameCrop = "Qi Fruit";
                    default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
                break;

            default:
                System.out.println("Opción de estación no válida. Inténtalo de nuevo.");
                return;
        }
        System.out.println("Enter the quantity: ");
        int quantity = sc.nextInt();
        String result = controller.createCrop(nameCrop, quantity);
        System.out.println(result);
    }

    public void mostrarContenidoDeUnCofre(){
        System.out.println("=======================MOSTRAR CONTENIDO DE COFRES==================================\n");
        controller.displayChests();
    }

    public void sortCropsInChest() {
        System.out.println("Ingrese el nombre del cofre que desea ordenar:");
        String chestName = sc.nextLine();
        sc.nextLine();

        System.out.println("Elige la opción de ordenamiento de los cultivos:");
        System.out.println("1) Por nombre");
        System.out.println("2) Por tipo");
        System.out.println("3) Por días de crecimiento");
        int option = sc.nextInt();
        sc.nextLine();

        System.out.println("Elige el orden de los cultivos:");
        System.out.println("1) Ascendente");
        System.out.println("2) Descendente");
        int order = sc.nextInt();
        sc.nextLine();

        boolean ascending = order != 2; // Si order es 2, ascending es false (descendente)

        if (controller.sortCropsInChest(chestName, option, ascending)) {
            System.out.println("Cultivos ordenados exitosamente.");
        }
    }
}