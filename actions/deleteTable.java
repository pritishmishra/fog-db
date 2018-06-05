import java.util.*;

public class deleteTable {
    private HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();
    private String tableName;
    
    public deleteTable(String Table) {
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

    public void delete(String Table) {
	    if(this.tableName == Table) {
	     for(String key: column.keySet()) {
		     ArrayList<?> dataArray = (ArrayList<?>) column.get(key);
		     int counter = 0;
		     while(counter <  dataArray.size()) {
		       dataArray.remove(counter);
		     }
	     }
	    } 
	    else {
	      System.out.println(" Table does not exist ");
	    }   
    }

}
