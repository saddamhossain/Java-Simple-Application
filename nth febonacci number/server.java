import java.io.*;
import java.net.*;
import java.util.*;
public class server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Wait.....");
			ServerSocket serversocketcapture = new ServerSocket(8001);
			Socket serversocket = serversocketcapture.accept();
			DataInputStream serverinput = new DataInputStream(serversocket.getInputStream());
			DataOutputStream serveroutput = new DataOutputStream(serversocket.getOutputStream());
			String z = "";
			int ans=0,f1=0,f2=1;
			z = serverinput.readUTF();
			System.out.println("Server Receive: " + z);
			int num = Integer.parseInt(z);
			while(num>0)
			{
				ans = f1+f2;
				f1 = f2;
				f2 = ans;
				num--;
			}
			System.out.println("Server send: " + ans);
			serveroutput.writeUTF("" + ans);
			serveroutput.flush();
			serveroutput.close();
			serverinput.close();
			serversocket.close();
			serversocketcapture.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage().toString());
		}
	}

}
