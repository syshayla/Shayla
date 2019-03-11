package PerfectForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ReadWrite {

    public static void WriteToFile(String filename, List<Student> student) {
        File destfile = new File(filename + ".txt");
        System.out.println("Creating a file");
        if (destfile.exists() == false) {
            try {
                destfile.createNewFile();
                PrintWriter out = new PrintWriter(new FileWriter(destfile, true));
                for (Student s : student) {
                    out.append(s.getId() + ", " + s.getName() + ", " + s.getAge() + ", " + s.getEmail() + ", " + s.getGender() + ", " + s.getCourse() + ", " + s.getRound() + ", " + s.getAddrss() + "\n");

                }
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void ReadfromFile(String filename, DefaultTableModel model) throws FileNotFoundException {
        String line;
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(filename + ".txt"));
        try {
           while((line=reader.readLine()) !=null){
               model.addRow(line.split(", "));
            }
           reader.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
