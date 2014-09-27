/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author kmhasan
 */
public class Client {
    Socket client;
    ObjectOutputStream output;
    ObjectInputStream input;
    BufferedReader stdin;
    String line;
    
    public Client() throws Exception {
        //connectToServer()
        client = new Socket("127.0.0.1", 12345);
        
        //getStreams()
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
        
        //processConnection
        System.out.println("Type your text here:");
        stdin = new BufferedReader(new InputStreamReader(System.in));

        while ((line = stdin.readLine()) != null && !line.equals(".")) {
            output.writeObject(line);
            output.flush();
            System.out.println("Server sent: [" + input.readObject() + "]");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Client client = new Client();
    }
}
