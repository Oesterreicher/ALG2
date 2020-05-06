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
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute 
        String s = command.execute(actualDir);
        actualDir = new File(actualDir.getAbsolutePath() + "\\\\" + s);
        return s;
    }
}