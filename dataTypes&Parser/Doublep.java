package dataTypes;

public class Doublep {
	private Double d;
	
	public int getPrecision() {
		
		// num in string
		String str1 = String.valueOf(d);
		// cut out the num after decimal dot
		String[] arrNum = str1.split(".");
		
		// get your current precision, could be used as a check
		int precise = arrNum[1].length();
		return precise;
	}

}
