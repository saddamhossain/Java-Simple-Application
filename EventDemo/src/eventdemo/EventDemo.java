
package eventdemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author RANA_CSE
 */
public class EventDemo 
{
    
    JLabel jlab;
   
    
    EventDemo()
        {
         JFrame jfrm = new JFrame("Event Handling Software");
         jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jfrm.setSize(600,150);
         jfrm.setVisible(true);
         jfrm.setLayout(new FlowLayout());
         
         JButton jbtn1 = new JButton("Saddam");
         JButton jbtn2 = new JButton("Mridul");
         JButton jbtn3 = new JButton("Pavel");
         JButton jbtn4 = new JButton("Niaz");
         JButton jbtn5 = new JButton("Rana");
         
         jbtn1.addActionListener(new ActionListener()
          {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
           jlab.setText("Saddam is a good person");
           }
         });
         
         jbtn2.addActionListener(new ActionListener()
          {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
           jlab.setText("Mridul is a c# Programmer");
           }
         });
         
         jbtn3.addActionListener(new ActionListener()
          {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
           jlab.setText("Pavrl is a number one Hacker");
           }
         });
         
         jbtn4.addActionListener(new ActionListener()
          {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
           jlab.setText("Niaz is a extreme Student of our class");
           }
         });
         
         jbtn5.addActionListener(new ActionListener()
          {
            @Override
           public void actionPerformed(ActionEvent ae)
           {
           jlab.setText("This is my nick name");
           }
         });
         
         
         jfrm.add(jbtn1);
         jfrm.add(jbtn2);
         jfrm.add(jbtn3);
         jfrm.add(jbtn4);
         jfrm.add(jbtn5);
         
         
         jlab = new JLabel("Press a Button");
         jfrm.add(jlab);
         
         
         
         
         
         
         
        }
    

    
    public static void main(String[] args) 
    {
        EventDemo obj = new EventDemo();
        
    }
}
