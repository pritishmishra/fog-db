package server;
import java.util.logging.Level;


import java.util.logging.Logger;

import com.google.gson.Gson;

import client.Client;
import parser.Parser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
		System.out.println("file: "+SQL); 
		   // Convert JSON to Java Object.
            Client header = gson.fromJson(SQL, Client.class);
             
          String s1= header.get("cmd");
           
          Parser obj = new Parser();
         String msg= obj.parserString(s1);
         System.out.println(msg);
        out.writeUTF(msg);
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    try {
        System.out.println("Socket Closing");
        s.close();
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
       }
   }  
}






