package zadatak08;
import java.util.*;


public class Calendar {

    public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);

    // Enter month
    System.out.print("Enter month in number between 1 and 12: ");
    int month = 0;

    do{
        try {
            month=Integer.parseInt(scan.next());         
        }
        catch(NumberFormatException e){
        	
            System.out.println("That is not an integer, please try again:" );
        }
    }while(month <= 0 || month > 12 );
    
     printMonth(month);
     scan.close();
     
  }
   /** Print the calendar for a month in a year */

    static void printMonth(int month) {

    //Printing days
    System.out.println("   P   U   S   C   P   S   N  ");

    //Print the body of the calendar
    int startDay = 0;

    // Get number of days in the month
    int numberOfDaysInMonth = getNumberOfDaysInMonth(month);

    // Pad space before the first day of the month
    int i = 0;
    for (i = 0; i < startDay; i++)
      System.out.print("    ");
    for (i = 1; i <= numberOfDaysInMonth; i++) {
      if (i < 10)
        System.out.print("   " + i);
      else
        System.out.print("  " + i);
      if ((i + startDay) % 7 == 0)
        System.out.println();

    }
    System.out.println();
   }

   /** Get the number of days in a month */

   static int getNumberOfDaysInMonth(int month) {
     if (month == 1 || month == 3 || month == 5 || month == 7 ||
       month == 8 || month == 10 || month == 12)
       return 31;

     if (month == 4 || month == 6 || month == 9 || month == 11)
       return 30;

     if (month == 2) return 29;

     return 0; 
   }

}
