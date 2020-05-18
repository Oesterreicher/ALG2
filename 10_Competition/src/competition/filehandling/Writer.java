package competition.filehandling;

import competition.app.Runner;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author janvit
 */
public abstract class Writer {
    public abstract void saveResults(String resultFilepath, List<Runner> runners) throws IOException;
}
