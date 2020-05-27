package app;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Jan Österreicher
 */
public class Event implements Comparable<Event> {
    private String name;
    private String description;
    private TimeData[] dates;

    Event(String name, String description, TimeData[] dates) {
        this.name = name;
        this.description = description;
        this.dates = dates;
        Arrays.sort(this.dates, new Comparator<TimeData>() {
            @Override
            public int compare(TimeData o1, TimeData o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }
    
    /**
     * Compares two events by their dates
     * @param o other event
     * @return -1 if this event is earlier, 1 if it is later and 0 for the same values
     */
    @Override
    public int compareTo(Event o) {
        return this.dates[0].getDate().compareTo(o.dates[0].getDate());
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the information about this event
     * @return name, description and dates as String
     */
    @Override
    public String toString() {
        return name + ", " + description + ", " + datesToString() + "\n";
    }
    
    /**
     * Returns all dates in the array
     * @return dates as String
     */
    public String datesToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dates.length - 1; i++) {
            sb.append(dates[i]).append(", ");
        }
        sb.append(dates[dates.length - 1]);
        return sb.toString();
    }
}