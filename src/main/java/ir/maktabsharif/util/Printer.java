package ir.maktabsharif.util;

public class Printer {
    public static void printItem(String[] menuItem) {
        System.out.println("\u001B[34m" + "🔥--------------------🔥");
        for (int i = 0; i < menuItem.length; i++) {
            System.out.printf("\u001B[34m" + "%d )☠️ %s \n", (i + 1), menuItem[i]);
        }
        System.out.println("\u001B[34m" + "🔥--------------------🔥");
    }
}
