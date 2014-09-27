/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inetaddresstest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author RANA_CSE
 */
public class InetAddressTest 
{

    
    public static void main(String[] args) throws UnknownHostException
    {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        
        address = InetAddress.getByName("facebook.com");
        System.out.println(address);
        
        InetAddress sw[] = InetAddress.getAllByName("facebook.com");
        for(int i = 0;i<sw.length;i++)
        {
        System.out.println(sw[i]);
        }
                
                
                
                
    }
}
