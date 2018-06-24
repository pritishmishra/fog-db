package ClientServer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;


public class InsertTable {

	//insert into tablename (roll,name,subject) values (111,xyz,ABC)
	  	
	  String table_name;
	  HashMap<String,ArrayList<String>> col=new HashMap<String,ArrayList<String>>();
	  ArrayList<String> col1_data=new ArrayList<String>();
	  ArrayList<String> col2_data=new ArrayList<String>();
	  ArrayList<String> col3_data=new ArrayList<String>();
	  
	public InsertTable() {
		super();
	}

	public   String check_insert(String cmd)
	{
		String cmd_parts[]=cmd.split(" ");
		if((cmd_parts[0].toLowerCase()).equals("insert") && (cmd_parts[1].toLowerCase()).equals("into")&&( (cmd_parts[3].toLowerCase()).equals("values") || (cmd_parts[4].toLowerCase()).equals("values"))) 
		{
			
			String w=insertTable(cmd_parts);
			return w;
		}
		else
		return "please enter correct command ";
	}
	
	public   String insertTable(String cmd_parts[])
	{
		table_name=cmd_parts[2];
		col1_data.add("1");
		col1_data.add("2");
		col1_data.add("3");
		col1_data.add("4");
		col1_data.add("5");
		col.put("roll", col1_data);
	
		col2_data.add("a");
		col2_data.add("b");
		col2_data.add("c");
		col2_data.add("d");
		col2_data.add("e");
		col.put("name", col2_data);
		
		col3_data.add("daa");
		col3_data.add("dbms");
		col3_data.add("cc");
		col3_data.add("iot");
		col3_data.add("java");
		col.put("subject", col3_data);
		String r=inserting_table(col,cmd_parts);
		return r;
	}
	
	public String inserting_table(HashMap<String,ArrayList<String>> col, String cmd_parts[])
	{	InsertTable in=new InsertTable();
		in.table_name=cmd_parts[2];
		String condition_parts[]=null;
		String s="";
		String s1=" ";
		//finding the value clause
		
		for(int j=0;j<cmd_parts.length;j++)
		{
			
			if(cmd_parts[j].equals("values"))
			{	//splitting the condition i.e. values
				condition_parts=cmd_parts[j+1].split(",");
				
			}
		}
		
		for(int j=1;j<condition_parts[0].length();j++)
		{
			s=s+condition_parts[0].charAt(j);
		}
		for(int j=0;j<condition_parts[2].length()-1;j++)
		{
			s1=s1+condition_parts[2].charAt(j);
		}
		condition_parts[0]=s;
		condition_parts[2]=s1;
		
		 col1_data.add(5,condition_parts[0]);
		 col2_data.add(5,condition_parts[1]);
		 col3_data.add(5,condition_parts[2]);
		 col.clear();
		 col.put("roll", col1_data);
		 col.put("name", col2_data);
		 col.put("subject", col3_data);
		 
		 in.col=col;
		
		 Gson gson=new Gson();
		String json1 = gson.toJson(in); 
	 	return json1;
	}
	public static void main(String[] args) {
    
		
	}

}

