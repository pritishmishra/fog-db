import java.util.*;
class Schema{
    
  
static List<String> column = new ArrayList<String> ();
static List<String> datatype = new ArrayList<String>(); 
  
  static Varchar varchar_object = new Varchar();
  static String table;
 
public Schema ()
{
table="";

}
 
public void accept(String s,String s1)
{
  
column.add(s1);
datatype.add(s);

}
public void tName(String s)
{
  table = s;

}
public void print ()
{
  int length = column.size();
  System.out.println("Table name ="+table);
  System.out.println("Table Elements");
  for (int i = 0; i<length;i++)
  {
  System.out.print(column.get(i)+" "+datatype.get(i)+" ");
  }

}


}