package ui;

import app.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import utils.*;

/**
 *
 * @author Jan Österreicher
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReminderInterface r = new Reminder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Vítejte v programu Reminders (Upomínky)");
        while (r.isRunning()) {
            StringBuilder sb = new StringBuilder();
            sb.append("------\n");
            sb.append("1 - Nahrát textový soubor\n");
            sb.append("2 - Nahrát binární soubor\n");
            sb.append("3 - Uložit do textového souboru\n");
            sb.append("4 - Uložit do binárního souboru\n");
            sb.append("5 - Vytvořit novou událost\n");
            sb.append("6 - Odebrat událost\n");
            sb.append("7 - Vypsat všechny události\n");
            sb.append("8 - Vypsat prvních 10 událostí podle prvních termínů\n");
            sb.append("9 - Vygenerovat PDF soubor\n");
            sb.append("10 - Ukončit program\n");
            sb.append("------");
            System.out.println(sb.toString());
            boolean ask = true;
            int choice = 0;
            while (ask) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    ask = false;
                } catch (Exception e) {
                    System.out.println("Zadej číslo!");
                }
            }
            switch(choice) {
                case 0:
                    break;
                case 1:
                    System.out.print("Zadej jméno souboru bez přípony: ");
                    String s = sc.nextLine();
                    try {
                        r.loadTXT(s);
                        System.out.println("Data načtena!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Soubor nebyl nalezen");
                    }
                    break;
                case 2:
                    System.out.print("Zadej jméno souboru bez přípony: ");
                    String s2 = sc.nextLine();
                    try {
                        r.loadBIN(s2);
                        System.out.println("Data načtena!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Soubor nebyl nalezen");
                    } catch (IOException e) {
                        System.out.println("Chyba při načítání souboru");
                    }
                    break;
                case 3:
                    System.out.print("Zadej jméno souboru bez přípony: ");
                    String s3 = sc.nextLine();
                    try {
                        r.saveTXT(s3);
                        System.out.println("Data uložena!");
                    } catch (IOException e) {
                        System.out.println("Chyba při zapisování do souboru");
                    }
                    break;
                case 4:
                    System.out.print("Zadej jméno souboru bez přípony: ");
                    String s4 = sc.nextLine();
                    try {
                        r.saveBIN(s4);
                        System.out.println("Data uložena!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Soubor nebyl nalezen");
                    } catch (IOException e) {
                        System.out.println("Chyba při zapisování do souboru");
                    }
                    break;
                case 5:
                    System.out.print("Napište název události: ");
                    String name = sc.nextLine();
                    System.out.print("Popište svou událost: ");
                    String description = sc.nextLine();
                    System.out.print("Zadej termíny oddělené tečkou a mezerou (ve formátu dd. mm. yyyy): ");
                    String dates = sc.nextLine();
                    try {
                        r.addReminder(name, description, dates);
                        System.out.println("Nová událost byla vytvořena");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Napište název události: ");
                    String name2 = sc.nextLine();
                    try {
                        r.removeReminder(name2);
                        System.out.println("Událost byla odebrána!");
                    } catch (NonexistentNameException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println(r.getAll());
                    break;
                case 8:
                    System.out.println(r.getSorted(10));
                    break;
                case 9:
                    r.generatePDF();
                    System.out.println("PDF soubor vygenerován");
                    break;
                case 10:
                    r.exit();
                    break;
                default:
                    System.out.println("Zadej číslo od 1 do 10!");
            }
        }
    }
}