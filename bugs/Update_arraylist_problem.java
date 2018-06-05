import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
public class Update_arraylist_problem {
	
		
	 String table_name;
	 HashMap<String,ArrayList<?>> col=new HashMap<String,ArrayList<?>>();
	
	 
	 
	public Update_arraylist_problem(String cmd) {
		super();
		
		check_update(cmd);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// update table set name=b where roll=4
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please enter your command:");
		String cmd=sc.nextLine();
		Update_arraylist_problem ob = new Update_arraylist_problem(cmd);
	}
	
	public void check_update(String cmd)
	{
		
	
		
		String cmd_parts[]=cmd.split(" ");
	
		if((cmd_parts[0].toLowerCase()).equals("update") && (cmd_parts[2].toLowerCase()).equals("set") )
		{
			
			
			updateTable(cmd_parts);
		}
		else
			System.out.println("please enter correct command");
	}
	
	public void updateTable(String cmd_parts[])
	{
		table_name=cmd_parts[1];
		
		
		ArrayList<Integer> col1_data=new ArrayList<Integer>();
		col1_data.add(1);
		col1_data.add(2);
		col1_data.add(3);
		col1_data.add(4);
		col1_data.add(5);
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
		updating_table(cmd_parts);
	}
	public void updating_table(String cmd_parts[])
	{	Update_arraylist_problem up2=new Update_arraylist_problem();
		up2.table_name=cmd_parts[1];
		
		//finding the where clause
		String condition_parts[]=null;
		for(int j=4;j<cmd_parts.length;j++)
		{
			
			if(cmd_parts[j].equals("where"))
			{	//splitting the condition i.e. key and values according to which updation will be done
				System.out.println("done");
				condition_parts=cmd_parts[j+1].split("=");
				
				
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
					ArrayList<?> alist1=col.get(parts[0]);
					alist1.set(index, parts[1]);
					System.out.println(col);
					up2.col=col;
					
					System.out.println(up2.table_name);
					System.out.println(up2.col);
					System.out.println(up2.toString());
					
					//JSONObject json = new JSONObject(col);
					Gson gson=new Gson();
					String json1 = gson.toJson(col); 
					System.out.println(json1);
					
					
					
					
					String json2 = gson.toJson(up2); 
					System.out.println(json2);
					
					
					try {
				        JSONObject request = new JSONObject(json2);
				        System.out.println(request.toString());
				    } catch (JSONException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
				    }
					

			}
				
			}

	}
			
	}

	public Update_arraylist_problem() {
		super();
	}
	
}
