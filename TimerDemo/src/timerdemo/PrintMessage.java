/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timerdemo;

import java.util.TimerTask;

/**
 *
 * @author kmhasan
 */
public class PrintMessage extends TimerTask {
    int count = 10;
    
    @Override
    public void run() {
        System.out.println("Printing this. " + count);
        count--;
        if (count <= 0)
            this.cancel();
    }
    
}
