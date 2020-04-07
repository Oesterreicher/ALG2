/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_bank;

import java.util.ArrayList;

/**
 *
 * @author Jan Österreicher
 */
public abstract class Client {
    private String name;
    private ArrayList<Account> accounts;
    
    public Client(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }
    
    public void addAccount(int money) {
        accounts.add(new Account(money));
    }
    
    public int getCompleteBalance() {
        int balance = 0;
        for (Account a : accounts) {
            balance += a.getBalance();
        }
        return balance;
    }
    
    public String getNameString() {
        return name;
    }
    
    public abstract String getName();
}