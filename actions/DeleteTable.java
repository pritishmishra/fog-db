package actions;

import java.util.*;
import com.google.gson.Gson;

public class DeleteTable {
    private HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();
    private String tableName;
    
    public DeleteTable() {
	// this.tableName = Table;
	    initializeColumn();
    }

    private void initializeColumn() {
	// this is the hard coded function just to check implementation
    	ArrayList<String> col1_data=new ArrayList<String>();
		col1_data.add("1");
		col1_data.add("2");
		col1_data.add("3");
		col1_data.add("4");
		col1_data.add("5");
		column.put("roll", col1_data);
		ArrayList<String> col2_data=new ArrayList<String>();
		col2_data.add("a");
		col2_data.add("b");
		col2_data.add("c");
		col2_data.add("d");
		col2_data.add("e");
		column.put("name", col2_data);
		ArrayList<String> col3_data=new ArrayList<String>();
		col3_data.add("daa");
		col3_data.add("dbms");
		col3_data.add("cc");
		col3_data.add("iot");
		col3_data.add("java");
		column.put("subject", col3_data);
    }

    public String toString() {
    	String remark;
	    if(this.tableName != null) {
	      remark = this.column.toString();
	    }
	    else {
	    remark = " Table does not exist ";
	    }
	  return remark;
    }

    public String deleteTable(String[] cmdArr) {
	if(isValid(cmdArr)) {
	    this.tableName = cmdArr[2];
	    for(String key: column.keySet()) {
		ArrayList<?> dataArray = (ArrayList<?>) column.get(key);
		int counter = 0;
		while(counter <  dataArray.size()) {
		    dataArray.remove(counter);
		}
	    }
	    return this.convertGson();
	} 
	else {
	    // System.out.println(" Table does not exist ");
	    return " Table does not exist ";
	}   
    }
	
    private boolean isValid(String[] cmdArr){
	if(cmdArr[0].toUpperCase().equals("DELETE") && cmdArr[1].toUpperCase().equals("FROM")) {
	    return true;
	}
	else
	    return false;
    }

	   	
private String convertGson() {
    Gson gson=new Gson();
    String json=gson.toJson(this);
    // System.out.println(json);
    return json;
   }   

}
