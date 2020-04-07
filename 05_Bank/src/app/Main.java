/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import pkg05_bank.*;

import java.util.ArrayList;

/**
 *
 * @author Jan Österreicher
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        Person p1 = new Person("Pekar");
        p1.addAccount(1000);
        p1.addAccount(500);
        Person p2 = new Person("Svecova");
        p2.addAccount(1200);
        Company c1 = new Company("Skoda");
        c1.addAccount(120);
        clients.add(p1);
        clients.add(p2);
        clients.add(c1);
        
        for (Client c : clients) {
            System.out.println(c.getName());
            System.out.println(c.getCompleteBalance());
        }
    }
}