package zadatak06;

public class TablicaMnozenja {
	public static void main(String[] args) {
				
        int tableSize = 9;
        printMultiplicationTable(tableSize);
        printName();
        printDottedLines(tableSize);
    }
    
	public static void printDottedLines(int tableSize) {
        
        
        for(int i = 1; i<=tableSize*5-5;i++ ) {
        	System.out.print("-");
        }
        System.out.println();
         
    }
	
	public static void printName() {
        

         System.out.printf(":   :   :   :   :   :   :   :  by Mihael\n");
         
    }
	
	
    public static void printMultiplicationTable(int tableSize) {
    	
    	printDottedLines(tableSize);
    	System.out.println(":   :   :   TABLICA MNOZENJA   :   :   :");
    	printDottedLines(tableSize);
    	
        // first print the top header row
        System.out.format(" * |");
        for(int i = 1; i<=tableSize;i++ ) {
            System.out.format("%4d",i);
        }
        
        System.out.println("      ");
        printDottedLines(tableSize);
         
        for(int i = 1 ;i<=tableSize;i++) {
            // print left most column first
            System.out.format(" %d |",i);
            for(int j=1;j<=tableSize;j++) {
                System.out.format("%4d",i*j);
            }
            System.out.println();
        }
        
        printDottedLines(tableSize);
    }
}
