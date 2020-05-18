package competition.filehandling;

import competition.app.Runner;
import competition.filehandling.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author janvit
 */
public class TextWriter extends Writer{

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException{
        //try with resources - automaticky zavře soubor i když nastane chyba
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFilepath, true)))) { //append true
            //PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp1250"), true); //nasteveni kódovaní
            pw.println("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                pw.print(n + ". ");
                pw.println(runner.toString());
                n++;
            }
        }
    }
}
