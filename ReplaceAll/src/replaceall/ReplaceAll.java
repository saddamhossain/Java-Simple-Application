/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package replaceall;

/**
 *
 * @author RANA_CSE
 */
public class ReplaceAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        String s = "Her name is Liza.I love Liza";
        s=s.replaceAll("Liza", "Lizza");
        System.out.println(""+s);
    }
}
