
package labeldemo;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author RANA_CSE
 */
public class LabelDemo 
{
    
    public LabelDemo()
        {
            JFrame jfrm = new JFrame("Student From");
            jfrm.setSize(500,200);
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jfrm.setVisible(true);
            jfrm.setLayout(new GridLayout(5,1));
            
            
            JLabel lab1 = new JLabel("Username :",JLabel.RIGHT);
            JLabel lab2 = new JLabel("Password :",JLabel.RIGHT);
            JLabel lab3 = new JLabel("Confirm Password :",JLabel.RIGHT);
            JLabel lab4 = new JLabel("Remember Me!",JLabel.LEFT);
            JLabel lab5 = new JLabel("Hello...",JLabel.CENTER);
            
            
           // lab5.setVerticalAlignment(JLabel.TOP);
           // lab5.setToolTipText("a TOOL TRIP WITH ME!");
            
            
          jfrm. add(lab1);
          jfrm.add(lab2);
          jfrm.add(lab3);
          jfrm.add(lab4);
          jfrm.add(lab5);
            
            
            
        }
    
    
    
    
    public static void main(String[] args) 
    {
       LabelDemo obj = new LabelDemo();
    }
}
