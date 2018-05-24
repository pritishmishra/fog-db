public class BooleanData {
	int default_value=0;
	int actual_value;
	String column_name="";

	public BooleanData(String column_name) {
		super();
		this.column_name = column_name;
		this.actual_value=this.default_value;
	}

	public BooleanData(String column_name,int actual_value) {
		super();
		this.column_name = column_name;
		if(actual_value==0||actual_value==1)
			this.actual_value = actual_value;
		else
			this.actual_value=this.default_value;
		
	}

	@Override
	public String toString() {
		return "Boolean [default_value=" + default_value + ", actual_value=" + actual_value + ", column_name="
				+ column_name + "]";
	}

	public int getActual_value() {
		return actual_value;
	}

	public void setActual_value(int actual_value) {
		this.actual_value = actual_value;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	
}
