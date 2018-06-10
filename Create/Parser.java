import java.util.Scanner;


class Parser {
  static Scanner ob = new Scanner(System.in); 
  static Table table_object = new Table();
  static Create create_object = new Create ();
  static Schema schema_object = new Schema();
  
 
   int check;
   
  public Parser()
  {
    check = 0;
  }

  public Parser(String cmd)
  {
    String cmd_parts[]= cmd.split(" ");
  
    if(cmd_parts[0].equals("create")==true) 
    {       
      System.out.println(cmd);
            createT(cmd_parts);
    }
       } 
  public void createT (String cmd_parts[])
  {
     int length = cmd_parts.length;
     
      if(cmd_parts[1].equals("TABLE"))
      {
        System.out.println(cmd_parts[2]);
        table_object.tableName(cmd_parts[2]);
      }
      for (int i=0;i<length;i++)
      {
        if(cmd_parts[i].equals(",")||cmd_parts[i].equals("("))
        {
          table_object.createTable(cmd_parts[i+1] , cmd_parts[i+2]);
        }
       
      }
     }   

  

   public void  receiveValue(String s)
   {
    
    String cmd = s;
    
    Parser obj = new Parser(cmd);
    //schema_object.print();
    //table_object.giveSchema();
    
                
    }


}