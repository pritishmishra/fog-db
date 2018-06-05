package actions;

import java.util.*;
import com.google.gson.Gson;

public class DeleteTable {
    private HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();
    private String tableName;
    
    public DeleteTable(String Table) {
	    this.tableName = Table;
	    initializeColumn();
    }

    private void initializeColumn() {
	// this is the hard coded function just to check implementation
	ArrayList<Integer> value= new ArrayList<Integer>();
	value.add(1);
	value.add(2);
	column.put("Id", value);
	
	ArrayList<String> newval= new ArrayList<String>();
	newval.add("A");
	newval.add("B");
	column.put("Name", newval);  
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

    public boolean deleteTable(String[] cmdArr) {
	    if(isValid(cmdArr)) {
             this.tableName = cmdArr[2];
	     for(String key: column.keySet()) {
		     ArrayList<?> dataArray = (ArrayList<?>) column.get(key);
		     int counter = 0;
		     while(counter <  dataArray.size()) {
		       dataArray.remove(counter);
		     }
	     }
	     return true;
	    } 
	    else {
	      System.out.println(" Table does not exist ");
	      return false;
	    }   
    }
	
    private boolean isValid(String[] cmdArr){
	if(cmdArr[0].toUpperCase.equals("DELETE") && cmdArr[1].toUpperrCase.equals("FROM") {
		return true;
	}
	else
	        return false;
	}
    }
	   	
    public void convertGson() {
	Gson gson=new Gson();
	String json=gson.toJson(this);
	System.out.println(json);
   }   

}
