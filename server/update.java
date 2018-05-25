import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class update {
	
	static Scanner sc=new Scanner(System.in);	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// update table set name=b where roll=4
		
		
		System.out.println("Please enter your command:");
		String cmd=sc.nextLine();
		check_update(cmd);
	}
	
	public static void check_update(String cmd)
	{
		
	
		//String cmd_parts[]=cmd.split("\\s*(=|,|\\s|<|>|!=)\\s*");
		//String cmd_parts[]=cmd.split(" ", 3);
		String cmd_parts[]=cmd.split(" ");
		for(int j=0;j<cmd_parts.length;j++)
			System.out.println(cmd_parts[j]);
		if((cmd_parts[0].toLowerCase()).equals("update") && (cmd_parts[2].toLowerCase()).equals("set") )
		{
			
			
			updateTable(cmd_parts);
		}
		else
			System.out.println("please enter correct command");
	}
	
	public static void updateTable(String cmd_parts[])
	{
		@SuppressWarnings("unused")
		String table_name;
		table_name=cmd_parts[1];
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
		System.out.println(col);
		updating_table(col,cmd_parts);
	}
	public static void updating_table(HashMap<String,ArrayList<String>> col, String cmd_parts[])
	{	//finding the where clause
		String condition_parts[]=null;
		for(int j=4;j<cmd_parts.length;j++)
		{
			
			if(cmd_parts[j].equals("where"))
			{	//splitting the condition i.e. key and values according to which updation will be done
				System.out.println("done");
				condition_parts=cmd_parts[j+1].split("=");
				
				for(int i=0;i<condition_parts.length;i++)
				System.out.println(condition_parts[i]);
			}
		}
		
		
	
			//checking the condition
			if(col.containsKey(condition_parts[0]))
			{
				//System.out.println("done1");
			ArrayList<?> alist2=col.get(condition_parts[0]);
				//System.out.println(alist2);
			if(alist2.contains(condition_parts[1]))
			
			{	System.out.println("done2");
				//retriving index for updating at that index
					 
				int index=alist2.indexOf(condition_parts[1]);
				System.out.println(index);
				
				//splitting the key and value to be updated
				String parts[]=cmd_parts[3].split("=");
				
				//for(int i=0;i<parts.length;i++)
				//	System.out.println(condition_parts[i]);
				
				if(col.containsKey(parts[0]))
				{		//System.out.println("done3");
					ArrayList<String> alist1=col.get(parts[0]);
					alist1.set(index, parts[1]);
					System.out.println(col);
				}
			}
				
			}
		//}
		
		//String parts[]=cmd_parts[4].split("\\s*(=|,|\\s*)\\s*");
		
	/**	for(int i=0;i<parts.length;i++)
		{
			if(col.containsKey(parts[0]))
			{if(col.containsValue(parts[1]))
			{
				
			}
				
			}
		}
		**/
	}
}
