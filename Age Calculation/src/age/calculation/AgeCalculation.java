/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package age.calculation;

/**
 *
 * @author Mridul
 */
import java.io.*;
import java.util.*;
public class AgeCalculation {

    /**
     * @param args the command line arguments
     */
    public AgeCalculation()
    {
        
    }
    public void agecalculation(String p, String name)
    {
       
        Calendar cal = Calendar.getInstance();
        int user_day,user_month,user_year;
        String userdate="",usermonth="",useryear="";
        int ud=0,um=0,uy=0,td=0,tm=0,ty=0;
        StringTokenizer token = new StringTokenizer(p,"/");
        while(token.hasMoreTokens())
        {
            userdate = token.nextToken();
            usermonth = token.nextToken();
            useryear = token.nextToken();
        }
        td = cal.get(Calendar.DATE);
        tm = (cal.get(Calendar.MONTH))+1;
        ty = cal.get(Calendar.YEAR);
        ud = Integer.parseInt(userdate);
        um = Integer.parseInt(usermonth);
        uy = Integer.parseInt(useryear);
        
        if(ud>td)
        {
            td+=30;
            tm--;
            if(tm<1)
            {
                tm+=12;
                ty--;
            }
        }
        if(um>tm)
        {
            tm+=12;
            ty--;
        }
        if(ty<uy)
        {
            user_day=0;
            user_month=0;
            user_year=0;
        }
        else
        {
            user_day = (td - ud);
            user_month = (tm - um);
            user_year = (ty - uy);
        }
        
        System.out.println(name + " Present Age is : "  + user_year + " year(s)" + user_month + " month(s)" + user_day + " day(s)");
    }
    
    public void readstring()
    {
        try
        {
            AgeCalculation ob = new AgeCalculation();
            RandomAccessFile file = new RandomAccessFile("Output.txt","r");
            String line ="";
            while((line = file.readLine())!=null)
            {
                StringTokenizer token = new StringTokenizer(line,",");
                while(token.hasMoreTokens())
                {
                    String name = token.nextToken();
                    String id = token.nextToken();
                    String dob = token.nextToken();
                    ob.agecalculation(dob,name);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void writestring()
    {
        try
        {
            RandomAccessFile file = new RandomAccessFile("Output.txt","rw");
            //String line = file.readLine();
            file.seek(file.length());
            file.writeBytes("saddam,3,26/09/1989" + "\r\n");
            System.out.println("File Write Successfully");
            file.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        AgeCalculation obj = new AgeCalculation();
        obj.writestring();
        obj.readstring();
    }
}
