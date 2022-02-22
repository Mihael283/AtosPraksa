package zadatak14;

public class Integration implements FunctionInterface{
		public static String type = "";
		
		public static void setType(String newType) {
			type = newType;
		}
		
		public static String getType() {
			return type;
		}
		
		
		static double f(double x,double A, double B) {
			switch(type) {
				case "sin":
					return A*Math.sin(x)+B;
				case "cos":
					return A*Math.cos(x)+B;
				case "tan":
					return A*Math.tan(x)+B;
				case "cot":
					return A*(1/Math.tan(x))+B;
				default:
					return 0;
			}
		}

	    static double integrate(double lowerRange, double upperRange, double A, double B) {
	    	int N = 2000; //Broj uzoraka
	    	double h = (upperRange - lowerRange) / N;              // Iznos koraka
	        double sum = 0.5 * (f(lowerRange,A,B) + f(upperRange,A,B));    // Povrsina
	        for (int i = 1; i < N; i++) {
	        	double x = lowerRange + h * i;
	            sum = sum + f(x,A,B);
	        }
	
	        return sum * h;
	    }

}