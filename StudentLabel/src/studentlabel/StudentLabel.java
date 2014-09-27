
package studentlabel;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author RANA_CSE
 */
public class StudentLabel 
{
     StudentLabel()
        {
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(3,2,5,5));
            
              
           
            
            
            JFrame jfrm = new JFrame("Student From");
            jfrm.setSize(500,300);
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            jfrm.pack();
            jfrm.setVisible(true);
              jfrm.setContentPane(p);
           // jfrm.setLayout(new GridLayout(3,2,5,5));
            
            
            
            
            JTextField field1 = new JTextField(10);
            JTextField field2 = new JTextField(10);
            JTextField field3 = new JTextField(10);
            
            
            JLabel lab1 = new JLabel("First Name",JLabel.RIGHT);
            JLabel lab2 = new JLabel("Middle Name",JLabel.RIGHT);
            JLabel lab3 = new JLabel("Last Name",JLabel.RIGHT);
            
             
             p.add(lab1);
             p.add(field1);
             p.add(lab2);
             p.add(field2);
             p.add(lab3);
             p.add(field3);
             
             
           
            
            
            
            
        }
   
    public static void main(String[] args) 
    {
        StudentLabel obj = new StudentLabel();
    }
}
