import java.util.*;

public class UTable {
    private HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();
    private String tableName;
    
    public UTable(String Table) {
	this.tableName = Table;
	initializeColumn();
    }

    private void initializeColumn() {
	// this is the hard coded function just to check implementation
	ArrayList<BooleanData> value= new ArrayList<BooleanData>();
	value.add(new BooleanData("Id", 1));
	value.add(new BooleanData("Id", 0));
	column.put("Id", value);
	
	ArrayList<BooleanData> newval= new ArrayList<BooleanData>();
	newval.add(new BooleanData("Name", 0));
	newval.add(new BooleanData("Name", 1));
	column.put("Name", newval);
	    
    }
	

	// may include methods insert, update, delete and so on.
	
    public void deleteTable(String Table) {

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

    public void toString(String Table) {
	if(this.tableName == Table) {
	    System.out.println(this.column);
	}
	else {
	    System.out.println(" Table does not exist ");
	}
    }

	    
}
