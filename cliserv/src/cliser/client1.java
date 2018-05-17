package cliser;




import java.net.*;
import java.io.*;

class client1
{
	private Socket s;
	
	public client1(String address,int port)
	{
		try
		{
			s = new Socket(address,port);
			System.out.println(s);   
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void sendMsgToServer() throws Exception{
		OutputStream outToServer = s.getOutputStream();
		DataOutputStream out = new DataOutputStream(outToServer);
		   
		out.writeUTF("Hello from client1 " + s.getLocalSocketAddress());
	}
		public void msgrec() throws Exception {
	InputStream inFromServer = s.getInputStream();
	   DataInputStream in = new DataInputStream(inFromServer);
	  String msg =(String)in.readUTF();
     System.out.println("Server says " + msg);
	}
	
	public void closeSocket() throws Exception{
		s.close();
	}
	
	public static void main(String str[])
	{
		client1 ob=new client1("localhost",11111);
		try {
			Thread.sleep(10000);
			ob.sendMsgToServer();
			Thread.sleep(10000);
			ob.msgrec();
			Thread.sleep(1000);
			ob.closeSocket();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}
}
  