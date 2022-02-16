package hr.atos.praksa.mihaelspanovic.zadatak10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StringSearch {
	

	public static void main(String[] argv) throws Exception {
		
		
			Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
			System.out.print("Enter a path to directory: ");  
			String filePath= sc.nextLine();              //reads string   
			
			File dir = new File(filePath); 
			
			/* Part that deals with inputs */
			
			if(dir.isDirectory()) {
				System.out.println("You have entered: "+ filePath);
			}
			else {
				System.out.print("Path is not valid, program will now exit.");
				System.exit(0);
			}
			
			
			System.out.println("Enter a string that you wish to check for: ");  
			String searchString = sc.nextLine();			
			sc.close();
			
			String[] children = dir.list();
			
			
			if (children == null) {				
				System.out.println("Could not find any files or directories. Program will now exit.");
				System.exit(0);		     
			} 
			else {
				
				/* Main logic of the program */
				
				//Go through each file in the directory, we get number of files by using children.length where children is an array or files in directory
				for (int i = 0; i < children.length; i++) {
					
					
			        String filename = children[i];		
			        
			        // We need a full path to each file to read them with buffered reader thats why we need to combine dir variable and filename		        
			        String path = dir +"\\"+ filename;
	
			        BufferedReader objReader = null;
			        
			        try {
			        	
						String strCurrentLine;					
						objReader = new BufferedReader(new FileReader(path));
						
						//Read line by line using while function 
						while ((strCurrentLine = objReader.readLine()) != null) {
							
							// If the current line matches our search string we print it out
							if(strCurrentLine.contains(searchString)) {				 
								System.out.println("I found " +searchString+ " in file " +path);
							}		          
						}
			
			        } catch (IOException e) {		
			        	e.printStackTrace();
			        } finally {			
			        	
			        	try {
			        		if (objReader != null)
			        			objReader.close();
			        	} catch (IOException ex) {
			        		ex.printStackTrace();
			        	}
			       }
				}
			  
			     
			}  	
	}
}
