/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trim1;

import java.util.Scanner;

/**
 *
 * @author RANA_CSE
 */
public class Trim1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String str;
        
        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter State: ");
        
        do{
            str = sc.nextLine();
            str = str.trim();
            
            if(str.equals("Illinois"))
                System.out.println("Capital is Springfield");
            else if(str.equals("Capital is Jefferson City"));
            
        
        }while(!str.equals("stop"));
        
        
        
        
    }
}
