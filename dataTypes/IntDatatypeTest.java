import java.util.*;

class IntegerDatatype {
    private static Object dataValue;
    private static int dataLenInBits;
    private static String dataName;
    private static String intType;
    private static int counterLen = 0;

    IntegerDatatype(String name, String value){
	if(isValid(value)) {
	    insertValue(name, Long.valueOf(value));
	}
	else {
	    System.out.println(" Invalid value for int ");
	}
    }

    private static boolean isValid(String uncheckedValue) {
	if(uncheckedValue.matches("^-[0-9]*") || uncheckedValue.matches("^[0-9]*")) {
	    return true;
	}
	else
	    return false;
    }
			   
			   
    private void insertValue(String name, long value) {
	this.counterLen = 0;
	this.dataLenInBits = getLenInBits(value);
	this.dataName = name;
	this.intType = getType(this.dataLenInBits);

	this.dataValue = value;
	// this.dataValue = value;
	// setDataValue(this, this.dataLenInBits);
    }

    private int getLenInBits(long value) {
	if(value/2 == 0)
	    return counterLen;
	else {
	    this.counterLen++;
	    value /= 2;
	    return getLenInBits(value);
	}
    }

    private static String getType(int bitSize) {
	switch(bitSize / 8) {
	case 0:
	    return "TinyInt";

	case 1:
	    return "SmallInt";

	case 2:
	    return "MediumInt";

	case 3:
	    return "Int";

	case 4:	    
	case 5:
	case 6:
	case 7:
	    return "BigInt";

	case 8:
	    
	default:
	    return "Int";
	}
    }

    private static void setDataValue(IntegerDatatype object, int bitSize) {	
	switch(bitSize / 8) {
	case 0:
	    object.finalDataValue = (byte)(object.dataValue);
	    break;

	case 1:
	    object.dataValue = (short)(object.dataValue);
	    break;

	case 2:
	case 3:
	    object.dataValue = (int)(object.dataValue);
	    break;

	case 4:
	case 5:
	case 6:
	case 7:
	    object.dataValue = (long)(object.dataValue);
	    break;

	default:
	    object.dataValue = (int)(object.dataValue); 

	}
    }
    
    public static String toString(IntegerDatatype object) {
	String remark = "variable name: " +  object.dataName + "\nValue: " + object.dataValue + "\nof type: " + object.intType + "\nand bit size " + object.dataLenInBits + "\n\t is present in database.";

	return remark;
    }
}

public class IntDatatypeTest {
    public static void main(String[] args) {
	Scanner scnobj = new Scanner(System.in);
	System.out.println(" Enter variable name: ");
	String name = scnobj.nextLine();
	System.out.println(" Enter variable value: ");
	String value = scnobj.nextLine();
	IntegerDatatype inte = new IntegerDatatype(name,value);
	System.out.println(inte.toString(inte));
    }
}
