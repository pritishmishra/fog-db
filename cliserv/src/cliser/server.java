package cliser;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

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
Multi() throws IOException{


}
Multi(Socket s) throws IOException{
    this.s=s;
    infromClient = new DataInputStream(s.getInputStream());
}
public void run(){  

    String SQL=new String();
    try {
        SQL = infromClient.readUTF();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("Thank you for connecting to " + s.getLocalSocketAddress()
            + "\nGoodbye!");
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Query: " + SQL); 
    try {
        System.out.println("Socket Closing");
        s.close();
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
       }
   }  
}






