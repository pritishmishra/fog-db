package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import client.Client;
import log.Log;
import parser.Parser;

public class Server {

public static void main(String args[]) throws IOException{  

    while(true){
        ServerSocket ss=new ServerSocket(11111);
        System.out.println("Server is Awaiting"); 
        Socket s=ss.accept();
        Multi t=new Multi(s);
        t.start();

        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ss.close();
    }    
    }   
}

class Multi extends Thread{
private Socket s=null;
DataInputStream infromClient;
DataOutputStream out;

Log logObj =new Log("serverlog.log");

Multi() throws IOException{
}

Multi(Socket s) throws IOException{
    this.s=s;
    infromClient = new DataInputStream(s.getInputStream());
     out = new DataOutputStream(s.getOutputStream());
}
public void run(){  

    String SQL=new String();
    try {
        SQL = infromClient.readUTF();
		Gson gson = new Gson();
		logObj.logger.info(SQL);
		//System.out.println("file: "+SQL); 
		   // Convert JSON to Java Object.
            Client header = gson.fromJson(SQL, Client.class);
             
          String s1= header.get("cmd");
           
          Parser obj = new Parser();
         String msg= obj.parserString(s1);
         if(msg.charAt(0)=='{' && msg.charAt(msg.length()-1)=='}') {
        	 logObj.logger.info(msg);
         }else {
         logObj.logger.severe(msg);
         }
       //  System.out.println(msg);
        out.writeUTF(msg);
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    try {
    	logObj.logger.info("Socket Closing "+s.getInetAddress());
       // System.out.println("Socket Closing");
        s.close();
        for(Handler h:logObj.logger.getHandlers())
        {
            h.close();   //must call h.close or a .LCK file will remain.
        }
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
       }
   }  
}






