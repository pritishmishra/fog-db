package dataTypesParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Table {
	//update master set Name = B , Id = 5 where Name = A Id = 3
	String tableName;
	HashMap<String,ArrayList<?>> column=new HashMap<String,ArrayList<?>>();

	public Table() {
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
	
//	public static void main(String[] args) {
//		Table ob= new Table();
//				
//	}

	public boolean updateTable(String[] cmdArr) {
		int whereIndex=findWhereIndex(cmdArr);
		if(!(
				keywordCheck(cmdArr[0],"UPDATE") &&
				keywordCheck(cmdArr[1], this.tableName) && 
				keywordCheck(cmdArr[2], "SET") && 
				whereIndex!=-1
			))
		return false;
		
		/* UPDATE `masterdata` SET `Id`=[value-1],`State`=[value-2],`District`=[value-3],
		 * `DealerId`=[value-4],`Dealer`=[value-5],`DealerType`=[value-6],
		`MobileNo`=[value-7],`TotalUnits`=[value-8],`TotalRevenue`=[value-9],
		`CreatedOn`=[value-10] WHERE 1
		*/
		ArrayList<Integer> conditionIndex= new ArrayList<>();
			HashMap<String, String> updateValue=new HashMap<>();
			updateValue=getUpdateValue(cmdArr);
			
			HashMap<String, String> updateCondition= new HashMap<>();
			updateCondition=getUpdateCondition(cmdArr);
		Set<String> set=updateCondition.keySet();
		for (String condition : set) {
			if(column.containsKey(condition)) {
				
				if(column.get(condition).contains(updateCondition.get(condition))) {
					conditionIndex.add(column.get(condition).indexOf(updateCondition.get(condition)));
//					conditionIndex.add(2);
					System.out.println(conditionIndex);
					
				}
			}
		}
		
		// get final index code 
		
		//updating values
		Boolean success=false;
		for (String updateCol : updateValue.keySet()) {
			success=false;
			if(column.containsKey(updateCol)) {
				for (Integer index : conditionIndex) {
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
		 System.out.println("Update Values  :  "+updateValue);
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
		 System.out.println("Update condition :  "+updateCondition);
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
