/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timerdemo;

import java.util.Timer;

/**
 *
 * @author kmhasan
 */
public class TimerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Timer timer = new Timer();
        PrintMessage task = new PrintMessage();
        timer.schedule(task, 0, 1000);
    }
}
