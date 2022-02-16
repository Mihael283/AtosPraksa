package hr.atos.praksa.mihaelspanovic.zadatak04;

public class EvenOrOdd {
	public static void main(String args[])
    {
        int arr[] = { 55, 22 ,46, 69, 14 };
        
        int visekratnik[] = {3, 5, 11};
        
        // Iteracija kroz arr array 
        for (int i=0; i<arr.length;i++)
        {	
        	
        	//Provjera parnosti
        	if(arr[i] % 2 == 0)
                System.out.println(arr[i] + " je paran broj.");
            else
                System.out.println(arr[i] + " je neparan broj.");
        	
        	// Iteracija kroz moguce visekratnike
        	for (int j=0; j<visekratnik.length;j++)
            {
        		//Provjera visekratnosti
            	if(arr[i] % visekratnik[j] == 0)
                    System.out.println(arr[i] + " je visekratnik broja "+ visekratnik[j] +".");
           	
            }
        }
    }
}
