package actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;

public class SelectTable {
	String table_name;
	HashMap<String,ArrayList<String>> col=new HashMap<String,ArrayList<String>>();
	HashMap<String, ArrayList<String>> selected=new HashMap<>();


public String selectTable(String com) {
	check_command(com);
	return convertGson(selected);
	
	// TODO Auto-generated method stub
	
}
private String convertGson(HashMap<String, ArrayList<String>> selected) {
	// TODO Auto-generated method stub
	Gson gson = new Gson();
	String json=gson.toJson(selected);
	return json;
}
public void check_command(String com)
{
	String com_parts[]=com.split(" ");
	if((com_parts[0].toLowerCase()).equals("select")) {
		init_table(com_parts);
	
	}
	else {

		System.out.println("please enter a valid command");
	}
}
public void init_table(String[] com_parts) {
		table_name=com_parts[1];

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
public void select(HashMap<String, ArrayList<String>> col, String[] com_parts)
{
	

	if(com_parts[1].equals("*") && com_parts.length==4) {

		selected.putAll(col);
      System.out.println(col);
	}
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
				    	ArrayList<String> alist1=col.get(com_parts[1]);
				    	ArrayList<String> alist4=new ArrayList<>();
				    	alist4.add(alist1.get(i));
				    	selected.put(com_parts[1], alist4);
				    	System.out.println(com_parts[1]+"="+alist1.get(i));
				    	}
				    else if(com_parts[1].equals("*"))
				   {
				    for(String key:col.keySet())
				    {
				    	ArrayList<String> alist=col.get(key);
				    	ArrayList<String> alist4=new ArrayList<>();
				    	alist4.add(alist.get(i));
				    	selected.put(key, alist4);
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
						    	ArrayList<String> alist3=col.get(seq[j]);
						    	ArrayList<String> alist4=new ArrayList<>();
						    	alist4.add(alist3.get(i));
					    	selected.put(seq[j], alist4);
						    	System.out.println(seq[j]+"="+alist3.get(i));
						    	}
				    	}
				    }
			}
		}
	}
}
}



