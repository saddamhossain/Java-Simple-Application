import java.io.*;
import java.net.*;
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
			int flag = 0,k=0;
			z = serverinput.readUTF();
			for(int i=(z.length()-1);i>=0;i--)
			{
				if(z.charAt(i)==z.charAt(k))
				{
					flag = 1;
					k++;
				}
				else
				{
					flag = 0;
					break;
				}
			}
			System.out.println("Server send: " + flag);
			serveroutput.writeUTF("" + flag);
			
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
