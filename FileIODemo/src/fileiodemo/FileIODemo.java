/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileiodemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

/**
 *
 * @author kmhasan
 */
public class FileIODemo {

  /*  public void writeDemo() {
        RandomAccessFile output;
        try {
            output = new RandomAccessFile("output.txt", "rw");
            //output.seek(output.length());
            output.setLength(0);
            for (int i = 1; i <= 10; i++)
                output.writeBytes(i*i + "\n");
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIODemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIODemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    public void readDemo() {
        RandomAccessFile input;
        try {
            ArrayList array;
            array = new ArrayList();
            input = new RandomAccessFile("output.txt", "r");
            String line;

            while ((line = input.readLine()) != null)
                array.add(line);
            for (int i = 0; i < array.size(); i++)
            {
                
                System.out.println(array.get(i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIODemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIODemo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public FileIODemo() {
//        writeDemo();
        readDemo();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileIODemo object;
        object = new FileIODemo();
    }
}
