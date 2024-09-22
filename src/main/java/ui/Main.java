package ui;

import java.util.Scanner;
import model.Controller;
import model.Crop; // Elminar este import despues, es solo para pruebas

public class Main {
    private Controller controller;
    public static Scanner sc = new Scanner(System.in);
    public Main() {
        controller = new Controller();
    }

    public static void main(String[] args) {
        Main objMain = new Main();
        System.out.println("---Welcome to Stardew Valley---");

        //    ESPACIO DE PRUEBAS, AQUI VENGO A PROBAR COSITAS

        /*Crop crop1 = new Crop("Garlic");

        System.out.println(crop1.getName());
        System.out.println(crop1.getStation());

         */

        boolean exit = false;
        int menu;

        do{
            menu = menuCode();
            switch(menu){
                case 1:

            }
        }while(!exit);
    }
    public static int menuCode(){
        int optionMenu;
        System.out.println(" 0. To generate test subjects (colaborators, requests, areas, projects) ");
        System.out.println(" 1. To create the chest ");
        System.out.println(" 2. To add an upgrade colaborator ");
        System.out.println(" 3. To add an transformation colaborator ");
        System.out.println(" 4. To calculate the efficency of a colaborator ");
        System.out.println(" 5. To delete a colaborator ");
        System.out.println(" 23. to exit ");
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
    }


}