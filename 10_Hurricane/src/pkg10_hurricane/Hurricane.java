/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_hurricane;

/**
 *
 * @author Jan Österreicher
 */
public class Hurricane implements Comparable<Hurricane> {
    private int year;
    private String month;
    private int pressure;
    private int speedInchPerHour;
    private String name;
    
    public Hurricane(int year, String month, int pressure, int speedInchPerHour, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speedInchPerHour = speedInchPerHour;
        this.name = name;
    }
    
    public int getKmPerHour() {
        return (int)(speedInchPerHour*1.852);
    }
    
    public int getCategory() {
        int speed = getKmPerHour();
        if (speed >= 119 && speed <= 153) return 1;
        if (speed >= 154 && speed <= 177) return 2;
        if (speed >= 178 && speed <= 208) return 3;
        if (speed >= 209 && speed <= 251) return 4;
        if (speed >= 252) return 5;
        return 0;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return String.format("%5d%5s%5d%5d%12s", year, month, pressure, getKmPerHour(), name);
    }

    @Override
    public int compareTo(Hurricane o) {
        if (getKmPerHour() < o.getKmPerHour()) return -1;
        if (getKmPerHour() > o.getKmPerHour()) return 1;
        return 0;
    }
}