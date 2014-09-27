/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package replace1;

/**
 *
 * @author RANA_CSE
 */
public class Replace1 
{

    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String s="i,love,java,hi, this, is, saddam, "
                + "hossain ,rana, i ,am ,a ,student, of, southeast, university, my"
    
           + "department, name, is ,cse, departmen,t i, am, a ,good ,student"
                + " i ,want, to ,be ,a,good ,java ,programmer";
      s=s.replace("java","php");
      System.out.println(s);
    }
}
