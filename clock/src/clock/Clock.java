
package clock;

/**
 *
 * @author RANA_CSE
 */
public class Clock {

    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        


   
    {
        int sec = 0;
        int min = 0;
        int hour = 0;
        {
            for(hour=1;hour<3;hour++)
            {
                for(min=0;min<60;min++)
                {
                    for(sec=0;sec<60;sec++)
                    {
                        System.out.println(hour+":"+ min+":"+sec);
                        try{Thread.sleep(1000);}
                        catch(Exception e){}
                       /* for(int i=0;i<100;i++)
                        {
                            System.out.print("");
                        }*/
                    }

                }
            }

        }
    }
}
    }

