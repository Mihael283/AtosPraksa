package hr.atos.praksa.mihaelspanovic.zadatak05;

public class Counter {
	public static void main(String args[])
    {
        int start = 5;
        int end = 101;
        int counter = 0;
        
        
        if (start >= 10 || end <= 100) {
            System.out.println("Conditions not met , please change start and end variables. Program will exit.");
            System.exit(0);
        }
        
        
        for(int i = start; i < end; i++ ) {
        	
        	if( i <= 18) {
        		counter += 4;
        	}else if( i > 18) {
        		counter -= 1;
        	}else if(i % 20 == 0) {
        		continue;
        	}
        	
        	if(i >= 75) {
        		System.out.println("Value of counter is: " + counter +".");
        		break;
        	}
        	
        }
    }
}
