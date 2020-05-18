/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_hurricane;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jan Österreicher
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Analyzer a = new Analyzer();
        try {
            a.load();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println("Zadej počáteční a koncový rok");
        int start = s.nextInt();
        int end = s.nextInt();
        a.getHurricanesByYear(start, end);
        System.out.println("Zadej jméno hurikánu");
        String name = s.next();
        a.getHurricane(name);
        System.out.println("Hurikány setříděné podle rychlosti:");
        a.sortBySpeed();
    }
}