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
public class Rename extends Command {

    @Override
    public String execute(CmdEditor editor) {
        if (params.length == 3) {
            File originalName = new File(editor.getActualDir().getAbsolutePath() + "\\\\" + params[1]);
            File newName = new File(editor.getActualDir().getAbsolutePath() + "\\\\" + params[2]);
            originalName.renameTo(newName);
        }
        return null;
    }
}