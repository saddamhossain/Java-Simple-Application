
package digital.clock;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class DigitalClock extends JFrame
{

    DigitalClock()
     {
      final JLabel timeField = new JLabel();
      timeField.setFont(new Font("sansserif",Font.PLAIN,20));
      
      Container content = this.getContentPane();
      content.setLayout(new FlowLayout());
      content.add(timeField);
      
      setTitle("Clock");
      setSize(500,300);
      
      javax.swing.Timer t = new javax.swing.Timer(100,new ActionListener(){
          
          public void actionPerformed(ActionEvent e){
              Calendar cal = new GregorianCalendar();
              
              String hour = String.valueOf(cal.get(Calendar.HOUR));
              String minute = String.valueOf(cal.get(Calendar.MINUTE));
              String second = String.valueOf(cal.get(Calendar.SECOND));
              
              
          }
      });
      t.start();;
     }
    
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JFrame clock = new  DigitalClock();
        clock.setVisible(true);
        
    }
}
