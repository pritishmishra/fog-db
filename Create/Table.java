import java.util.*;
class Table {

static  String table_name ;
//static List<String> colmn = new ArrayList<String> ();
//static List<String> data = new ArrayList<String>();
//static List<String> table = new ArrayList<String>();
static  HashSet<String> colmn = new HashSet<String>();
static  HashSet<String> data =  new HashSet<String>();

static Date date_object = new Date();
static Schema schema_object = new Schema();

public Table()
{
table_name=" ";
}
public void tableName(String s)
{
    table_name=s;
    schema_object.tName(table_name);
}
public Table (String s)
{
    table_name=s ;
}
public void createTable (String s ,String s1)
{
//System.out.println(s1 + " " + s );
 colmn.add(s); 
 data.add(s1);


}
public void print ()
{
  System.out.println("Table name ="+table_name);
  System.out.println("Table Elements");
  Iterator<String> i = colmn.iterator();
  while(i.hasNext())
  System.out.print(i.next()+" ");
  Iterator<String> j = data.iterator();
  while(j.hasNext())
  System.out.print(j.next()+" ");
    
}

/*public void giveSchema()
{ 
  int length = data.size(); 
  for(int i = 0; i<length; i++)
  {
      
      schema_object.accept(data.get(i),colmn.get(i));
     /** if(s.equals("date"))
      {
        
        checkDatatype( data.get(i),colmn.get(i));  
       

      }**/
 
    
}
/**public void checkDatatype(String s,String s1)
{
//if(date_object.acceptTable(s1)==1)
//{
System.out.println(s);
System.out.println(s1);
//}

}**/
/**public void display()
{    
table.addAll(colmn);
table.addAll(data);
System.out.println(table);
}**/








