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
public class Company extends Client {
    public Company(String name) {
        super(name);
    }
    
    @Override
    public String getName() {
        return "firma " + getNameString();
    }
}