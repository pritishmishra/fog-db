package dataTypes;

public class FloatData {
		
			float default_value=0;
			float actual_value;
			String column_name="";

			public FloatData(String column_name) {
				super();
				this.column_name = column_name;
				this.actual_value=this.default_value;
			}

			public FloatData(String column_name,int actual_value) {
				super();
				this.column_name = column_name;
				this.actual_value = actual_value;
				
			}

			@Override
			public String toString() {
				return "FloatData [default_value=" + default_value + ", actual_value=" + actual_value + ", column_name="
						+ column_name + "]";
			}

			public float getActual_value() {
				return actual_value;
			}

			public void setActual_value(float actual_value) {
				this.actual_value = actual_value;
			}

			public String getColumn_name() {
				return column_name;
			}

			public void setColumn_name(String column_name) {
				this.column_name = column_name;
			}

			
		}


