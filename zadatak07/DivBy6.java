package zadatak07;
import java.util.*;

public class DivBy6 {
	
	public static int numberCheck(Scanner in)
	{
		boolean isNumber = false;
		while(!isNumber)
		try {
			int temp = in.nextInt(); 
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

	


	public static int divisibleCounter(int start , int stop)
	{
	    int counter = 0;
	    
	    //Ne ukljucujemo pocetak i kraj intervala
	    for (int i = start+1; i < stop; i++) {
	    	if (i % 6 == 0) {
	    		counter++;
	    	}   
	    }
	    
	    return counter;
	}
	 

	public static void main (String[] args)
	{	
		Scanner in = new Scanner(System.in);
		System.out.println("Interval start:");
		int start = numberCheck(in);
		System.out.println("Interval end:");
		int stop = numberCheck(in);

	    
		int divby6 =divisibleCounter(start,stop);
		
	    System.out.print("Inside of chosen interval: <"+start+","+stop+"> there ");
	    
	    //Cisto za lijepsi/tocniji ispis
	    if(divby6 == 1) {
	    	 System.out.print("is one number divisible by 6.");
	    }
	    else {
	    	System.out.print("are "+divby6+" numbers divisible by 6.");
	    }
	    in.close();

	}
}



