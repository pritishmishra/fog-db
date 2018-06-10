import java.io.*;
import java.util.*;
class Test{
    Scanner obj = new Scanner (System.in);
    static Table table_object = new Table();
    static Schema schema_object = new Schema();   
    static Parser  parserObject = new Parser();


    public static void main(String args[])throws IOException {
    Test ob = new Test();
    
    try{
       BufferedReader in = new BufferedReader(new FileReader("input.txt"));

        String s;
       while ((s = in.readLine()) != null){
               ob.sendValue(s); 
               

               
       }

    }catch(IOException e){
        System.out.println("Wrong Input");
    }
    table_object.print();
}
public void sendValue(String s)//sending the value to parser class
{ 
  parserObject.receiveValue(s);    

}
    

   

    
}