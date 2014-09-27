import java.io.*;
import java.net.*;
import java.util.*;
public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Socket clientSocket = new Socket("localhost",8001);
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
			Scanner ob = new Scanner(System.in);
			System.out.print("Enter a number: ");
			String X = ob.next();
			output.writeUTF(X);
			output.flush();
			System.out.println("Clien send: " + X);
			String num = input.readUTF();
			System.out.println("Client receive: " + num);
			int ans = Integer.parseInt(num);
			if(ans == 1)
				System.out.println(X + " is a peridom word.");
			else
				System.out.println(X + " is not peridom word.");
			clientSocket.close();
			input.close();
			output.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage().toString());
		}

	}

}
