
package split1;

import java.util.Arrays;

/**
 *
 * @author RANA_CSE
 */
public class Split1
{

    
    public static void main(String[] args)
    {
        // TODO code application logic here
        //String s="this is a number one programmer,he,loves him,very much";
        String ss = "Hello_world";
        String str[] = ss.split("_");
        for(int i = 0;i<str.length;i++)
            System.out.println(str[i]);
        
       // String tokens[]=s.split(",");
        //Arrays.sort(tokens);
      //  System.out.println(Arrays.toString(tokens));
    }
}
