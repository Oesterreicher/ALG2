/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Jan Österreicher
 */
public class Analyzer {
    private ArrayList<Hurricane> hurricanes = new ArrayList<>();
    
    public void load() throws FileNotFoundException {
        File hurricaneFile = new File("hurricanedata.txt");
        try (Scanner s = new Scanner(hurricaneFile)) {
            while (s.hasNext()) {
                int year = s.nextInt();
                String month = s.next();
                int pressure = s.nextInt();
                int speedInchPerHour = s.nextInt();
                String name = s.next();
                Hurricane h = new Hurricane(year, month, pressure, speedInchPerHour, name);
                hurricanes.add(h);
            }
        }
    }

    public void getHurricanesByYear(int start, int end) {
        for (Hurricane h : hurricanes) {
            if (h.getYear() >= start && h.getYear() <= end) {
                System.out.println(h);
            }
        }
    }
    
    public void getHurricane(String name) {
        for (Hurricane h : hurricanes) {
            if (h.getName().equals(name)) {
                System.out.println("Kategorie: " + h.getCategory());
                System.out.println("Rychlost: " + h.getKmPerHour() + " km/h");
                break;
            }
        }
    }
    
    public void sortBySpeed() {
        Collections.sort(hurricanes);
        for (Hurricane h : hurricanes) {
            System.out.println(h);
        }
    }
}