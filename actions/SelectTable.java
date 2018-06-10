package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SelectTable {
static Scanner sc=new Scanner(System.in);
public static void main(String args[])
{
	String com=null;
	System.out.println("enter the command");
	com=sc.nextLine();
	check_command(com);
}
static void check_command(String com)
{
	String com_parts[]=com.split(" ");
	if((com_parts[0].toLowerCase()).equals("select"))
		update_table(com_parts);
	else
		System.out.println("please enter a valid command");
}
static void update_table(String[] com_parts) {
		String table_name;
		table_name=com_parts[1];
		HashMap<String,ArrayList<String>> col=new HashMap<String,ArrayList<String>>();
		ArrayList<String> col1_data=new ArrayList<String>();
		col1_data.add("1");
		col1_data.add("2");
		col1_data.add("3");
		col1_data.add("4");
		col1_data.add("5");
		col.put("roll", col1_data);
		ArrayList<String> col2_data=new ArrayList<String>();
		col2_data.add("a");
		col2_data.add("b");
		col2_data.add("c");
		col2_data.add("d");
		col2_data.add("e");
		col.put("name", col2_data);
		ArrayList<String> col3_data=new ArrayList<String>();
		col3_data.add("daa");
		col3_data.add("dbms");
		col3_data.add("cc");
		col3_data.add("iot");
		col3_data.add("java");
		col.put("subject", col3_data);
		//System.out.println(col);
		select(col,com_parts);
	}
static void select(HashMap<String, ArrayList<String>> col, String[] com_parts)
{
	if(com_parts[1].equals("*")&&com_parts.length==4)
        System.out.println(col);
	else
	{
		String condition_parts[]=null;
	
		for(int j=4;j<com_parts.length;j++)
		{
			if(com_parts[j].equals("where"))
			{	
				condition_parts=com_parts[j+1].split("=");
			}
		}
	
		if(col.containsKey(condition_parts[0]))
		{	
			ArrayList<?> alist2=col.get(condition_parts[0]);	
			if(alist2.contains(condition_parts[1]))
			{
				int i=alist2.indexOf(condition_parts[1]);
				    if(col.containsKey(com_parts[1]))
				    	{
				    	ArrayList<?> alist1=col.get(com_parts[1]);
				    	System.out.println(com_parts[1]+"="+alist1.get(i));
				    	}
				    else if(com_parts[1].equals("*"))
				   {
				    for(String key:col.keySet())
				    {
				    	ArrayList<?> alist=col.get(key);
				    	System.out.println(key+"="+alist.get(i));
				    }
				   }
				    else if(com_parts[1].contains(","))
				    {
				    	String seq[]=com_parts[1].split(",");
				    	for(int j=0;j<seq.length;j++)
				    	{
				    		 if(col.containsKey(seq[j]))
						    	{
						    	ArrayList<?> alist3=col.get(seq[j]);
						    	System.out.println(seq[j]+"="+alist3.get(i));
						    	}
				    	}
				    }
			}
		}
	}
}
}



