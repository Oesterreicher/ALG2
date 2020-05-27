package cmd;

import java.io.File;

/**
 *
 * @author janka
 */
public class CmdEditor implements CmdInterface {
    private boolean isRunning;
    private File actualDir;
    private Command command;    
    
    public CmdEditor(){
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }
    
    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public File getActualDir() {
        return actualDir;
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute 
        String s = command.execute(this);
        if (command.params != null && command.params[0].equals("cd")) actualDir = new File(s);
        return s;
    }
}