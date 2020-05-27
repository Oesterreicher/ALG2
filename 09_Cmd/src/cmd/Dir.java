package cmd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author janka
 */
public class Dir extends Command {

    @Override
    public String execute(CmdEditor editor) {
        File[] files; 
        if (params.length == 1) {
            files = editor.getActualDir().listFiles();
            return dirToString(files);
        }
        else if (params.length == 2) {
            if (params[1].equals("-o")) {
                files = editor.getActualDir().listFiles();
                Arrays.sort(files);
                return dirToString(files);
            }
            else if (params[1].equals("-r")) {
                // TODO
                files = editor.getActualDir().listFiles();
                return dirToString(files);
            }
        }
        else if (params.length == 3) {
            if (params[1].equals("-e")) {
                files = editor.getActualDir().listFiles((File dir, String name) -> name.toLowerCase().endsWith(params[2]));
                return dirToString(files);
            }
            else if (params[1].equals("-s")) {
                files = editor.getActualDir().listFiles((File dir, String name) -> {
                    if (dir.isDirectory()) return true;
                    return (dir.length() >= Integer.parseInt(params[2]));
                });
                return dirToString(files);
            }
        }
        return null;
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append(String.format("%s%n", file.getName()));
            } else {
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }
}