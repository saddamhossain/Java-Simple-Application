
package random;



public class Random
{

  
    
    public static void main(String[] args) 
    {
        int i;
        double a = 16.0 , b = 4.0;
        int[] randomNumber = new int [10];
        
        System.out.println(Math.sqrt(a));
        System.out.println(Math.pow(a,2));
        System.out.println(Math.pow(b,3));
        System.out.println(Math.random());
        
        for(i=0;i<randomNumber.length;i++)
        {
        randomNumber[i] = (int) (Math.random()*30);
        }
        
        for(i=0;i<randomNumber.length;i++)
        {
       System.out.println(randomNumber[i]);
        }
        
        
    }
}
