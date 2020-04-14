/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

/**
 *
 * @author Jan Österreicher
 */
public class Square extends Rectangle {
    public Square(double a) {
        super(a, a);
    }
    
    @Override
    public String toString() {
        return "Square{" + "a=" + getA() + '}';
    }
    
    public static void main(String[] args) {
        Square s = new Square(5);
        System.out.println(s);
        System.out.println(s.computeArea());
        System.out.println(s.computeCircumference());
    }
}