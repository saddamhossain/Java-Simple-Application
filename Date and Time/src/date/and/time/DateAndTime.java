/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package date.and.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RANA_CSE
 */
public class DateAndTime 
{

    
    public static void main(String[] args) 
    {
        
       // Current date and time
        Date date = new Date();
        System.out.println(date.toString());
        
        //
        Date dNow = new Date();
        SimpleDateFormat sdf =   new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
        
        System.out.println("Current Date: "+ sdf.format(dNow));
        
    }
}
