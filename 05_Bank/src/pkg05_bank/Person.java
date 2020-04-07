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
public class Person extends Client {
    public Person(String name) {
        super(name);
    }
    
    @Override
    public String getName() {
        if (getNameString().length() > 3 && getNameString().substring(getNameString().length() - 3).equals("ova")) return "pani " + getNameString();
        return "pan " + getNameString();
    }
}