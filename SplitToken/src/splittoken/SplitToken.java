package splittoken;

//import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author RANA_CSE
 */
public class SplitToken
{

   
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String s = "hi,this,is,saddam,hossain,rana.i,am,a,computer,engineer";
        String tokens[]=s.split(",");
        Arrays.sort(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
