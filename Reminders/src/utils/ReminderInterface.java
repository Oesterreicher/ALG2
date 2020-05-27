package utils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jan Österreicher
 */
public interface ReminderInterface {
    public boolean isRunning();
    
    public void exit();
    
    public void loadTXT(String file) throws FileNotFoundException;
    
    public void loadBIN(String file) throws FileNotFoundException, IOException;
    
    public void saveTXT(String file) throws IOException;
    
    public void saveBIN(String file) throws FileNotFoundException, IOException;
    
    public void addReminder(String name, String description, String dates);
    
    public void removeReminder(String name);

    public String getAll();

    public String getSorted(int count);

    public void generatePDF();
}