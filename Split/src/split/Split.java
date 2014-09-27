/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package split;

import java.util.Arrays;

/**
 *
 * @author RANA_CSE
 */
public class Split {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String s = "This,is,a,saddam,hossain,rana.";
        String tokens[] = s.split(",");
        Arrays.sort(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
