/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author janka
 */
public interface CmdInterface {

    public boolean isRunning();

    public File getActualDir();

    public String parseAndExecute(String line);
}