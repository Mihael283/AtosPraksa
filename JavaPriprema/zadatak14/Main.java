package zadatak14;

import java.util.*;


public class Main extends Integration{
	
	public static double numberCheck(Scanner in)
	{
		boolean isNumber = false;
		while(!isNumber)
		try {
			double temp = in.nextDouble(); 
					   in.nextLine();
			isNumber = true;//numeric value entered, so break the while loop
			return temp;
		} catch(InputMismatchException ime) {
			//Display Error message
			System.out.println("Invalid character found, please enter a number:");					
			in.nextLine();//Advance the scanner
		}

		return -1;
	}
	public static void main (String[] args)
	{	
		String type = "";
		Scanner in = new Scanner(System.in);
		
		double T1,T2,A,B=0;
		
		System.out.println("Enter starting point T1:");
		T1 = numberCheck(in);
		
		System.out.println("Enter end point T2:");
		T2 = numberCheck(in);
		
		if(T2 <= T1) {
			System.out.println("Please repeat the entry , T2 has to be larger than T1!");
			do {
				System.out.println("Enter end point T2:");
				T2 = numberCheck(in);
			}while(T2 <= T1);
		}
		
		
		System.out.println("Enter A for f(x) = A*function+B:");
		A = numberCheck(in);
		
		System.out.println("Enter B for f(x) = A*function+B:");
		B = numberCheck(in);
		
		
		System.out.println("Pick a function:   \n1. SIN\n2. COS\n3. TAN\n4. CON\n5. Enter 5 for exiting the program.\n Enter a number:");
		int pick=0;
		
		do {
			pick = (int) numberCheck(in);
		}while(pick < 0 || pick >5);

        switch(pick) {
        case 1:
        	type = "sin";
          break;
        case 2:
        	type = "cos";
          break;
        case 3:
        	type = "tan";
          break;
        case 4:
        	type = "con";
          break;
        case 5:
        	System.exit(0);
        default:
        	type = "sin";
        }
        
        
        Main.setType(type);
        System.out.println("Area under the curve is: "+Main.integrate(T1, T2, A, B));
        in.close();
        
        
	}
	
	
}
