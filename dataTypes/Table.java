import java.util.*;

public class Table {
    private HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();
    private String tableName;
    
    public Table(String Table) {
	this.tableName = Table;
	initializeColumn();
    }

    private void initializeColumn() {
	// this is the hard coded function just to check implementation
	// ArrayList<Integer> value= new ArrayList<Integer>();
	// value.add(1);
	// value.add(2);
	// column.put("Id", value);
	
	// ArrayList<String> newval= new ArrayList<String>();
	// newval.add("A");
	// newval.add("B");
	// column.put("Name", newval);
	
	ArrayList<BooleanData> value= new ArrayList<BooleanData>();
	value.add(new BooleanData("Id", 1));
	value.add(new BooleanData("Id", 0));
	column.put("Id", value);
	
	ArrayList<BooleanData> newval= new ArrayList<BooleanData>();
	newval.add(new BooleanData("Name", 0));
	newval.add(new BooleanData("Name", 1));
	column.put("Name", newval);
	    
    }

    public void toString(String Table) {
	if(this.tableName == Table) {
	    System.out.println(this.column);
	}
	else {
	    System.out.println(" Table does not exist ");
	}
    }

    public void deleteTable(String Table) {

	// Iterator mapCounter = column.entrySet().iterator();
	// while(mapCounter.hasNext()) {
	//     Map.Entry item = (Map.Entry)mapCounter.next();
	//     ListIterator valueIterator = item.getValue().iterator();
	//     while(valueIterator.hasNext()) {
	// 	valueIterator.remove();
	// 	valueIterator.next();
	//     }
	// }

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
