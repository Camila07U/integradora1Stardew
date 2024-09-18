package ui;

import java.util.Scanner;
import model.Controller;

public class Main {
    private Controller mainController;
    public static Scanner sc = new Scanner(System.in);
    public Main() {

    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("---Welcome to Stardew Valley---");
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
}