/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.pkg03.pkg2019.Student;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
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

public class Utils {
   public static void writeToFile(String filename, List<Student>student) throws IOException{
       File destfile = new File(filename+ ".txt");
       
       if(destfile.exists()==false){
           System.out.println("Creating a new file!");
           destfile.createNewFile();
       }
       
       PrintWriter out = new PrintWriter(new FileWriter(destfile, true));
       for(Student s : student){
           out.append(s.getId()+ ", "+s.getName()+", "+s.getAge()+", "+ s.getEmail()+", "+s.getGender()+", "+s.getCourse()+", "+s.getRound()+", "+s.getAddress()+"\n");
           
           
       }
       out.close();
       
   }
   public static void displayStudentsDataFromFile(String filename, DefaultTableModel model) throws IOException{
       String line;
       BufferedReader reader;
       
       try {
           reader = new BufferedReader(new FileReader(filename+".txt"));
           while((line=reader.readLine())!=null){
               model.addRow(line.split(", "));
               
           }
           reader.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
