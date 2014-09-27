/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package server;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadedServer implements Runnable {
    Socket connection;
    ObjectInputStream input;
    ObjectOutputStream output;
    
    public ThreadedServer(Socket connection) {
        this.connection = connection;
    }
    
    public void run() {
        String message;
        try {
//            getStreams();
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            
//            processConnection();
            try {
                while ((message = (String) input.readObject()) != null 
                        && !message.equals(".")) {
                    System.out.println("Client sent: [" + message + "]");
                    output.writeObject(message.toUpperCase());
                    output.flush();
                }
            } catch (EOFException eofe) {
                connection.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

/**
 *
 * @author kmhasan
 */
public class Server {
    ServerSocket server;
    Socket connection;
    ObjectInputStream input;
    ObjectOutputStream output;
    
    public Server() throws Exception {
        server = new ServerSocket(12345, 100);
        System.out.println("Waiting on clients");
        while (true) {
//            waitForConnection();
            connection = server.accept();
            System.out.println("Accepted connection from client: " 
                    + connection.getInetAddress());
            ThreadedServer ts = new ThreadedServer(connection);
            Thread t = new Thread(ts);
            t.start();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Server server = new Server();
    }
}
