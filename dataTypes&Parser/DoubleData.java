
public class DoubleData {
	
		double default_value=0;
		double actual_value;
		String column_name="";

		public DoubleData(String column_name) {
			super();
			this.column_name = column_name;
			this.actual_value=this.default_value;
		}

		public DoubleData(String column_name,int actual_value) {
			super();
			this.column_name = column_name;
			this.actual_value = actual_value;
			
		}

		@Override
		public String toString() {
			return "DoubleData [default_value=" + default_value + ", actual_value=" + actual_value + ", column_name="
					+ column_name + "]";
		}

		public double getActual_value() {
			return actual_value;
		}

		public void setActual_value(double actual_value) {
			this.actual_value = actual_value;
		}

		public String getColumn_name() {
			return column_name;
		}

		public void setColumn_name(String column_name) {
			this.column_name = column_name;
		}

		
		
	}
