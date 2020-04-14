/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

import static pkg05_shapes.Main.shapes3;

/**
 *
 * @author Jan Österreicher
 */
public class MyComparing {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[shapes3.size()];
        shapes3.toArray(shapes);
        print(shapes);
        sort(shapes);
        System.out.println("-----");
        print(shapes);
    }
    
    public static void sort(CompareInterface[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1].isBigger(array[j])) {
                    CompareInterface temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    public static void print(Object[] array) {
        for (Object object : array) {
            System.out.println(object);
        }
    }
}