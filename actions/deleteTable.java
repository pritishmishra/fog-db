import java.util.*;

public class deleteTable {
    private HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();
    private String tableName;
    
    public deleteTable(String Table) {
	    this.tableName = Table;
	    initializeColumn();
    }

    private void initializeColumn() {
	  // this is the hard coded function just to check implementation and uses the BooleanData.java file as a datatype
	  ArrayList<BooleanData> value= new ArrayList<BooleanData>();
	  value.add(new BooleanData("Id", 1));
	  value.add(new BooleanData("Id", 0));
	  column.put("Id", value);
	
	  ArrayList<BooleanData> newval= new ArrayList<BooleanData>();
	  newval.add(new BooleanData("Name", 0));
	  newval.add(new BooleanData("Name", 1));
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
