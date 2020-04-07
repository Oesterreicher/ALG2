/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_bank;

/**
 *
 * @author Jan Österreicher
 */
public class Account {
    private int money;
    
    public Account() {
        this.money = 0;
    }
    
    public Account(int money) {
        if (money < 0) money = 0;
        this.money = money;
    }
    
    public void deposit(int money) {
        this.money += money;
    }
    
    public void withdraw(int money) {
        if (money > this.money) money = this.money;
        this.money -= money;
    }
    
    public int getBalance() {
        return money;
    }
}