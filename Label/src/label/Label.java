
package label;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author RANA_CSE
 */
public class Label
{

    public Label()
        {
            JFrame jfrm = new JFrame("Label Example");
            jfrm.setSize(300,500);
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jfrm.setVisible(true);
            jfrm.setLayout(new GridLayout(6,1));
            
            
            JLabel jlab = new JLabel("This is first Label",JLabel.LEFT);
            JLabel jlab2 = new JLabel("This is second Label",JLabel.RIGHT);
            JLabel jlab3 = new JLabel("This is third Label",JLabel.CENTER);
            
            JLabel jlab4 = new JLabel("This is fourth Label",JLabel.RIGHT);
            JLabel jlab5 = new JLabel("This is fifth Label",JLabel.CENTER);
            JLabel jlab6 = new JLabel("This is sixth Label",JLabel.CENTER);
            
            
            
            jfrm.add(jlab);
            jfrm.add(jlab2);
            jfrm.add(jlab3);
            jfrm.add(jlab4);
            jfrm.add(jlab5);
            jfrm.add(jlab6);
                  
            
            
            
        }
    
    public static void main(String[] args) 
    {
       Label obj = new Label(); 
    }
}
