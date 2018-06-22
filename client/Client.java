
package client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Handler;

import com.google.gson.Gson;

import log.Log;

public class Client
{
	private Socket s;
	private String cmd;
	
	public Client(String address,int port)
	{
		try
		{
			s = new Socket(address,port);  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public void sendMsg() throws Exception{
		Log logObj = new Log("clientlog.log");
		
		System.out.println("Enter your command");
		Client obj = new Client();
		String SQL1=" ";
        Scanner sc=new Scanner(System.in);
		String cmd = sc.nextLine();
		 obj.cmd=cmd;
		 Gson gson=new Gson();
			String json1 = gson.toJson(obj);
			logObj.logger.info(json1);
			//System.out.println(json1);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream infromServer = new DataInputStream(s.getInputStream());
		dos.writeUTF(json1);
		SQL1 = infromServer.readUTF();
		
		if(SQL1.charAt(0)=='{' && SQL1.charAt(SQL1.length()-1)=='}') {
			logObj.logger.info(SQL1);
		}else {
			logObj.logger.severe(SQL1);
		}
	    //System.out.println(SQL1);
		dos.close();
		for(Handler h:logObj.logger.getHandlers())
        {
            h.close();   //must call h.close or a .LCK file will remain.
        }
		

		
	}
	
	public void closeSocket() throws Exception{
		s.close();
	}
	
	public static void main(String str[])
	{//172.29.9.245
		Client ob=new Client("localhost",11111);
		try {
			Thread.sleep(1000);
			ob.sendMsg();
			Thread.sleep(1000);
			//ob.closeSocket();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}

	public String get(String string) {
		// TODO Auto-generated method stub
		return this.cmd;
	}
}
  