/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents.mycomparing;

import comparingstudents.Student;

/**
 *
 * @author Jan Österreicher
 */
public class PorovnavacStudentByLastname implements ComparatorInterface {
    
    @Override
    public boolean bigger(Object o1, Object o2) {
        return ((Student)o1).getLastName().compareTo(((Student)o2).getLastName()) > 0;
    }
}