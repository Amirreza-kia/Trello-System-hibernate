package ir.maktabsharif.menu;

import ir.maktabsharif.model.Role;
import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.Printer;
import ir.maktabsharif.util.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu {

    public static void startMenu() {
        while (true) {
            Printer.printItem(ApplicationContext.LOGIN_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    public static void loginMenu() {
        String username = Util.getStringInput("Enter Username");
        String password = Util.getStringInput("Enter Password");
        Role userType = ApplicationContext.usersService.login(username, password);
        switch (userType) {
            case ADMIN -> adminMenu();
            case USER -> memberMenu();
            default -> System.out.println("Invalid User");
        }
    }
//    System.out.println("date born Enter a date (dd/mm/yyyy)");
//    String dob =scan.nextLine();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//try {
//        Date dateDob = sdf.parse(dob);

    public static void adminMenu() {
        Printer.printItem(ApplicationContext.ADMIN_MENU_ITEM);
        int choice = Util.getIntInput("SELECT ONE ITEM --> ");
        switch (choice) {
            case 1 :
                String title = Util.getStringInput("Enter Title");
                String description = Util.getStringInput("Enter Description");
                System.out.println("date born Enter a date (dd/mm/yyyy)");
                String dob =Util.getStringInput("Enter DeadLine");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(dob);
                    ApplicationContext.taskService.addTask(date,title,description);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            default:
                System.out.println("Invalid Choice");
        }
    }
    public static void memberMenu(){

    }
}

