/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_calendar;

/**
 *
 * @author Jan Österreicher
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar c = new Calendar(14, 2, 2020);
        String[] s = c.getFormattedCalendar();
        for (int i = 0; i < s.length; i++) System.out.println(s[i]);
        c.goToNextMonth();
        c.goToNextMonth();
        c.goToPreviousMonth();
        String[] s2 = c.getFormattedCalendar();
        for (int i = 0; i < s2.length; i++) System.out.println(s2[i]);
    }
}