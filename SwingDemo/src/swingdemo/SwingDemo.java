
package swingdemo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author RANA_CSE
 */
public class SwingDemo 
{
      SwingDemo()
      {
      JFrame jfrm = new JFrame("A Normal Desktop Software");
      jfrm.setSize(300, 300);
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jfrm.setVisible(true);
      
      JLabel label = new JLabel("It is a important software");
      jfrm.add(label);
      
      
      }
    
    public static void main(String[] args)
    {
     SwingUtilities.invokeLater(new Runnable()
             {
            @Override
        public void run()
                {
                new SwingDemo();
                }
            });
             
    }
}
