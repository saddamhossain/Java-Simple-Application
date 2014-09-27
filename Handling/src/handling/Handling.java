
package handling;

/**
 *
 * @author RANA_CSE
 */
public class Handling 
{

   
    public static void main(String[] args) 
    {
      int d,a;
      
         try
         {
           d= 0;
           a=42/d;
           System.out.println("It is not dizplayed"+a);
         }
         catch(ArithmeticException e)
         {
         System.out.println("Division by zero");
         }
         System.out.println("After catch statement");
    }
}
