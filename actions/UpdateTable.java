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
//		System.out.println(column);
		
	}
	public String convertGson() {
		Gson gson=new Gson();
		String json=gson.toJson(this);
		return json;
	}


	public String updateTable(String[] cmdArr) {
		boolean validateCheck= validatator(cmdArr);
		if(validateCheck) {
			System.out.println("Correct Command now table will be updated");
			if(action(cmdArr)) {
			String json=this.convertGson();
			return json;
			}
		}
		return "Please Enter valid Command";
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


