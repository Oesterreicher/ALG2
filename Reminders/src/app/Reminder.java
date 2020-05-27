package app;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import utils.ReminderInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import utils.NonexistentNameException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jan Österreicher
 */
public class Reminder implements ReminderInterface {
    private ArrayList<Event> events = new ArrayList<>();
    private boolean isRunning = true;
    
    /**
     * Function for determining if the program is running
     * @return true if the program is running
     */
    @Override
    public boolean isRunning() {
        return isRunning;
    }
    
    /**
     * Function that sets isRunning to false, preparing for exit
     */
    @Override
    public void exit() {
        isRunning = false;
    }
    
    /**
     * Loads data from a text file
     * @param file name of the file as String
     * @throws FileNotFoundException if the file was not found
     */
    @Override
    public void loadTXT(String file) throws FileNotFoundException {
        File f = new File("./data/" + file + ".txt");
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                try {
                    String name = sc.nextLine();
                    String description = sc.nextLine();
                    String dates = sc.nextLine();
                    String[] str = dates.split(", ");
                    TimeData[] TDDates = new TimeData[str.length];
                    for (int i = 0; i < str.length; i++) {
                        TDDates[i] = new TimeData(str[i]);
                    }
                    events.add(new Event(name, description, TDDates));
                } catch (ParseException e) {
                    System.out.println("Nastala chyba při parsování termínu");
                }
            }
        }
    }
    
    /**
     * Loads data from a bin file
     * @param file name of the file as String
     * @throws FileNotFoundException if the file was not found
     * @throws IOException if there was a problem with loading
     */
    @Override
    public void loadBIN(String file) throws FileNotFoundException, IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("./data/" + file + ".bin"))) {
            boolean isEnd = false;
            while(!isEnd) {
                try {
                    String name = dis.readUTF();
                    String description = dis.readUTF();
                    String dates = dis.readUTF();
                    String[] s = dates.split(", ");
                    TimeData[] TDDates = new TimeData[s.length];
                    for (int i = 0; i < s.length; i++) {
                        TDDates[i] = new TimeData(s[i]);
                    }
                    events.add(new Event(name, description, TDDates));
                } catch (EOFException e) {
                    isEnd = true;
                } catch (ParseException e) {
                    System.out.println("Nastala chyba při parsování termínu");
                }
            }
        }
    }
    
    /**
     * Saves data to a text file
     * @param file name of the file as String
     * @throws IOException if there was a problem with saving
     */
    @Override
    public void saveTXT(String file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./data/" + file + ".txt", true)))) {
            for (Event e : events) {
                pw.println(e.getName());
                pw.println(e.getDescription());
                pw.println(e.datesToString());
            }
        }
    }
    
    /**
     * Saves data to a bin file
     * @param file name of the file as String
     * @throws FileNotFoundException if the file was not found
     * @throws IOException if there was a problem with saving
     */
    @Override
    public void saveBIN(String file) throws FileNotFoundException, IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("./data/" + file + ".bin"))) {
            for (Event e : events) {
                dos.writeUTF(e.getName());
                dos.writeUTF(e.getDescription());
                dos.writeUTF(e.datesToString());
            }
        }
    }
    
    /**
     * Adds a reminder to the list
     * @param name name of the reminder
     * @param description brief description
     * @param dates String of dates separated by space
     */
    @Override
    public void addReminder(String name, String description, String dates) {
        try {
            String[] s = dates.split(", ");
            TimeData[] TDDates = new TimeData[s.length];
            for (int i = 0; i < s.length; i++) {
                if (!s[i].matches("[0-3][0-9]\\.\\s[0-1][0-9]\\.\\s20[2-9][0-9]")) {
                    throw new IllegalArgumentException("Špatný formát termínu");
                }
                TDDates[i] = new TimeData(s[i]);
            }
            events.add(new Event(name, description, TDDates));
        } catch (ParseException e) {
            System.out.println("Nastala chyba při parsování termínu");
        }
    }
    
    /**
     * Finds and removes a reminder from the list
     * @param name name of the reminder
     */
    @Override
    public void removeReminder(String name) {
        for (Event e : events) {
            if (e.getName().equals(name)) {
                events.remove(e);
                return;
            }
        }
        throw new NonexistentNameException("Název " + name + " nebyl nalezen");
    }

    /**
     * Returns the information about all loaded reminders
     * @return reminders as String
     */
    @Override
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Event e : events) {
            sb.append(e.toString());
        }
        return sb.toString();
    }
    
    /**
     * Finds and returns a specified number of reminders sorted by first dates
     * @param count number of returned reminders
     * @return reminders as String
     */
    @Override
    public String getSorted(int count) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(events);
        for (Event e : events) {
            sb.append(e);
            count--;
            if (count == 0) break;
        }
        return sb.toString();
    }
    
    /**
     * Generates a new PDF file and saves all reminders to it
     */
    @Override
    public void generatePDF() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("document.pdf"));
            document.open();
            for (Event e : events) {
                document.add(new Paragraph(e.getName()));
                document.add(new Paragraph(e.getDescription()));
                document.add(new Paragraph(e.datesToString()));
                document.add(new Paragraph(""));
            }
            document.close();
        } catch (Exception e) {
            System.out.println("Nastala chyba při generování dokumentu");
        }
    }
}