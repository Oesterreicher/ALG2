package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jan Österreicher
 */
public class TimeData implements Comparator<Date> {
    private Date date;
    public static SimpleDateFormat format = new SimpleDateFormat("dd. MM. yyyy", Locale.ENGLISH);
    
    TimeData(String date) throws ParseException {
        this.date = format.parse(date);
    }
    
    /**
     * Compares two dates
     * @param o1 first date
     * @param o2 second date
     * @return -1 if the first date is earlier, 1 if it is later and 0 if they are the same
     */
    @Override
    public int compare(Date o1, Date o2) {
        return o1.compareTo(o2);
    }
    
    public Date getDate() {
        return date;
    }
    
    /**
     * Gets the information about this date
     * @return formatted date as String
     */
    @Override
    public String toString() {
        return format.format(date);
    }
}