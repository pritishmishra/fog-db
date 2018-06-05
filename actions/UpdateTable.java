package actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class UpdateTable {
	//update master set Name = xyz where Name = A
	String tableName;
	HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();

	public UpdateTable() {
	initializeColumn();
	}

	private void initializeColumn() {
		//this is the hard coded function just to check implementation
		tableName="master";
		ArrayList<Integer> value= new ArrayList<Integer>();
		value.add(1);
		value.add(2);
		value.add(3);
		column.put("Id", value);
		ArrayList<String> newval= new ArrayList<String>();
		newval.add("A");
		newval.add("B");
		newval.add("C");
		column.put("Name", newval);
		System.out.println(column);
		
	}
	public void convertGson() {
		Gson gson=new Gson();
		String json=gson.toJson(this);
		System.out.println(json);
	}


	public boolean updateTable(String[] cmdArr) {
		boolean validateCheck= validatator(cmdArr);
		if(validateCheck) {
			System.out.println("Correct Command now table will be updated");
			action(cmdArr);
		}
		return validateCheck;		
	}

	private boolean validatator(String[] cmdArr) {
		int whereIndex=findWhereIndex(cmdArr);
		if(!(
				keywordCheck(cmdArr[0],"UPDATE") &&
				keywordCheck(cmdArr[1], this.tableName) && 
				keywordCheck(cmdArr[2], "SET") && 
				whereIndex!=-1
			))
		return false;
		
		//checking for where clause condition begins
		HashMap<String, String> updateCondition= new HashMap<>();
		updateCondition=getUpdateCondition(cmdArr);
		Set<String> set=updateCondition.keySet();
		for (String condition : set) {
			if(column.containsKey(condition)) {
				if(!column.get(condition).contains(updateCondition.get(condition))) {
					return false; //if where condition key and value  is not present in column then false
				}
			}else {
				return false; // if key is not there
			}
		}
		//checking for where clause condition ends
		
		HashMap<String, String> updateValue=new HashMap<>();
		updateValue=getUpdateValue(cmdArr);
	
		//check updating values
		for (String updateCol : updateValue.keySet()) {
			if(!column.containsKey(updateCol)) {
				return false;
			}
		}
		
		
		return true;
}

	public boolean action(String[] cmdArr) {
			
		ArrayList<Integer> conditionIndex= new ArrayList<>();
			HashMap<String, String> updateValue=new HashMap<>();
			updateValue=getUpdateValue(cmdArr);
			
			HashMap<String, String> updateCondition= new HashMap<>();
			updateCondition=getUpdateCondition(cmdArr);
			
			Set<String> set=updateCondition.keySet();
			for (String condition : set) {
				if(column.get(condition).contains(updateCondition.get(condition))) {
						conditionIndex.add(column.get(condition).indexOf(updateCondition.get(condition)));
	//					conditionIndex.add(2);
						System.out.println("index to be changed " +conditionIndex);
						
					}
				}
		//updating values
			Boolean success=false;
			for (String updateCol : updateValue.keySet()) {
				success=false;
				if(column.containsKey(updateCol)) {
					for (Integer index : conditionIndex) {
						@SuppressWarnings("unchecked")
						ArrayList<String> alist1=(ArrayList<String>) column.get(updateCol);
						alist1.set(index,updateValue.get(updateCol));
						success=true;
					}
				}
			}
			 System.out.println(column);
			
			return success;
	
			
	}	
private HashMap<String, String> getUpdateValue(String[] cmdArr) {
		HashMap<String, String> updateValue =new HashMap<>();
		 for(int i=3;i<findWhereIndex(cmdArr);i++) {
			 if(keywordCheck(cmdArr[i],"=")){
				 updateValue.put(cmdArr[i-1], cmdArr[i+1]);
				 i++;
			 }
		 }
		// System.out.println("Update Values  :  "+updateValue);
		return updateValue;
	
}

	private HashMap<String, String> getUpdateCondition(String[] cmdArr) {
		HashMap<String, String> updateCondition =new HashMap<>();
		 for(int i=findWhereIndex(cmdArr)+1;i<cmdArr.length;i++) {
			 if(keywordCheck(cmdArr[i],"=")){
				 updateCondition.put(cmdArr[i-1], cmdArr[i+1]);
				 i++;
			 }
		 }
		// System.out.println("Update condition :  "+updateCondition);
		return updateCondition;
	}

	private int findWhereIndex(String[] cmdArr) {
		for(int i=3;i<cmdArr.length;i++) {
			if(keywordCheck(cmdArr[i],"where")) {
				return i;
			}
		}
		return -1;
	}

	private boolean keywordCheck(String string, String string2) {
		return string.toUpperCase().equals(string2.toUpperCase());
	}

}
