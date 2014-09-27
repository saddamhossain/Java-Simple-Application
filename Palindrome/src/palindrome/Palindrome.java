/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author RANA_CSE
 */
public class Palindrome 
{

    public static boolean palindrome(String s)
    {
        for(int i=0,j=s.length()-1;i<=j;i++,j--)
            {
                 if(s.charAt(i) != s.charAt(j))
                    {
                          return false;
                    }
             }
        return true;
    }
    
    
    
    
    public static void main(String[] args) 
    {
        
        String s = "madamimadam";
        System.out.println("madamimadam is " + palindrome(s));
    }
}
