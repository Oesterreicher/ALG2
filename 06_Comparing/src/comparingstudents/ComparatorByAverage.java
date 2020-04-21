/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.util.Comparator;

/**
 *
 * @author Jan Österreicher
 */
public class ComparatorByAverage implements Comparator<Student> {
    
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverage() == o2.getAverage()) {
            return 0;
        } else if (o1.getAverage() > o2.getAverage()) {
            return 1;
        }
        return -1;
    }
}