import java.net.*;
import java.io.*;
public class MultiJabberClient {
  static final int MAX_THREADS = 1;
  public static void main(String[] args) 
      throws IOException, InterruptedException {
   // InetAddress addr = InetAddress.getByName(null);
    while(true) {
      if(JabberClientThread.threadCount() < MAX_THREADS)
        new JabberClientThread();
      Thread.currentThread().sleep(100);
    }
  }
} 

