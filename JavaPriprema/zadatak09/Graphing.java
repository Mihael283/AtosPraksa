package zadatak09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Graphing {
	
	public static void setX(int[] electricityBill, int price_point) {
		int pozicija_mj[] = {0,3,6,9,12,15,18,21,24,27,30,33}; //odre�uju razmak izme�u mjeseci,npr visekratnici broja 3 su dva razmaka izme�u svakog x-a , 2 razmak + 1 za x. 
		
		
		int i = 0;
		int j = 0;
		while(i<=33) { //Sve dok ne do�emo do kraja grafa ilitiga 33 charactera 
			if(electricityBill[j] == price_point) { 
					if(i == pozicija_mj[j]) {	//kada je i jednak pozicija mjeseca stavi x a i pove�avamo sve dok ne prona�edmo mjesec 
						System.out.print(" x");
						j++;
						i +=1;
					}else {
						System.out.print("  "); //1 character za x
						i+=1;
						
					}
					System.out.print(" "); //za svaki ne prona�eni pomaknemo se za 2 mjesta sto je jednako razmaku izme�u mjeseci
					i+=2;
			}
			else {
				j++;
			}
			
			if(j == 12) { //stajemo kada pro�emo kroz svih 12 mjeseci
				break;
			}

		}

	}
	
	public static void approxValue(int[] electricityBill) {
		
		for(int i = 0; i < 12; i++) {
			if(electricityBill[i] <= 500) {
				electricityBill[i] = 0;
			}
			else if(electricityBill[i] > 500 && electricityBill[i] <=1500 )		
			{
				electricityBill[i] = 1000;
			}
			else if(electricityBill[i] > 1500 && electricityBill[i] <=2500  )		
			{
				electricityBill[i] = 2000;
			}
			else if(electricityBill[i] > 2500 && electricityBill[i] <=3500 )		
			{
				electricityBill[i] = 3000;
			}
			else if(electricityBill[i] > 3500 && electricityBill[i] <4500 )		
			{
				electricityBill[i] = 4000;
			}
			else if(electricityBill[i] >= 4500)		
			{
				electricityBill[i] = 4500;
			}
				
		}
	}
	
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
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int electricityBill[] = new int[12];
		
		
		int i = 0;

		for( i = 0; i < 12; i++) {
			System.out.format("Enter the amount Luka has to pay for %d. month:\n", i+1);			
			electricityBill[i] = numberCheck(in);

		}
		
		in.close();

		
		approxValue(electricityBill);

		int prices[] = {4500 , 4000, 3000, 2000, 1000, 0};
		int max = 5000;

		
		System.out.format("%5dkn - |",max);
		System.out.format("\n          |");
		setX(electricityBill,prices[0]);
		System.out.format("\n%5dkn - |",prices[1]);
		setX(electricityBill,prices[1]);
		
		for(i = 2; i <= 5; i++) {
			System.out.format("\n          |");
			System.out.format("\n%5dkn - |",prices[i]);
			setX(electricityBill,prices[i]);
		}

		
		System.out.println("\n           -- -- -- -- -- -- -- -- -- -- -- --");
		System.out.println("           01 02 03 04 05 06 07 08 09 10 11 12");
		
    }
    
}
