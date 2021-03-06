/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author Jan Österreicher
 */
public class Cd extends Command {

    @Override
    public String execute(CmdEditor editor) {
        String dir = null;
        if (params.length == 2) {
            if (params[1].equals("..")) {
                dir = editor.getActualDir().getParentFile().getAbsolutePath();
            } else {
                File[] files = editor.getActualDir().listFiles();
                for (File file : files) {
                    if (file.isDirectory() && file.getName().equals(params[1])) {
                        dir = editor.getActualDir().getAbsolutePath() + "\\\\" + file.getName();
                        break;
                    }
                }
            }
            if (dir != null) return dir;
        }
        return null;
    }
}