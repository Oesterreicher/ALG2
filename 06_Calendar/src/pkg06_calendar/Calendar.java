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
public class Calendar {
    private int day;
    private int month;
    private int year;
    
    private static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getWeekday(int day, int month, int year) {
        if (month == 1) {
            month = 13;
            year--;
        }
        else if (month == 2) {
            month = 14;
            year--;
        }
        int K = year % 100;
        int J = year / 100;
        int h = day + 13*(month + 1) / 5 + K + K / 4 + J / 4 + 5 * J;
        h %= 7;
        return ((h + 5) % 7) + 1;
    }
    
    public String[] getFormattedCalendar() {
        StringBuilder[] s = new StringBuilder[7];
        for (int i = 0; i < 7; i++) s[i] = new StringBuilder();
        s[0].append("po út st čt pá so ne");
        int days = daysInMonth[month - 1];
        int dayCount = 1;
        if (isLeapYear(year) && days == 28) days++;
        for (int i = 0; i < (getWeekday(dayCount, month, year) - 1)*3; i++) s[1].append(" ");
        for (int i = 1; i < 7; i++) {
            int weekday = getWeekday(dayCount, month, year);
            for (int j = 0; j <= 7 - weekday; j++) {
                if (dayCount > days) break;
                if (dayCount < 10) {
                    s[i].append("  ");
                } else s[i].append(" ");
                s[i].append(dayCount);
                dayCount++;
            }
            if (s[i].length() > 0) s[i].deleteCharAt(0);
        }
        int length = s[6].length() == 0 ? 6 : 7;
        String[] str = new String[length];
        for (int i = 0; i < str.length; i++) str[i] = s[i].toString();
        return str;
    }
    
    public void goToNextMonth() {
        day = 1;
        if (month < 12) {
            month++;
        }
        else {
            month = 1;
            year++;
        }
    }
    
    public void goToPreviousMonth() {
        day = 1;
        if (month > 1) {
            month--;
        }
        else {
            month = 12;
            year--;
        }
    }
    
    public static boolean isLeapYear(int year) {
        return ((year % 100 == 0 & year % 400 == 0) || (year % 4 == 0));
    }
    
    public static int getDaysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }
}