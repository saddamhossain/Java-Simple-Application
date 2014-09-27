
package palindrome1;

/**
 *
 * @author RANA_CSE
 */
public class Palindrome1

{

    public static boolean palindrome(String s)
    {
    for(int i = 0,j=s.length()-1;i<=j;i++,j--)
    {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
    }
    return true;
    }
    
    
    public static void main(String[] args)
    {
        // TODO code application logic here
        String s="lksdhfsaklhsdszf";
        System.out.println("lksdhfsaklhsdszf "+ palindrome(s));
        
    }
}
