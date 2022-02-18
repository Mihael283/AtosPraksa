package zadatak12;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
	
	static void CountWords(String filename, Map< String, Integer> words) throws FileNotFoundException
	{
		Scanner file=new Scanner (new File(filename));
		
		/* Idemo kroz datoteku rijec po rijec te nakon toga pregledamo cijeli dokument za tu rijec, za svako ponavljanje dodamo counter*/
		while(file.hasNext()){
			String word=file.next();
			word = word.toLowerCase();
			word = word.replaceAll("[^a-zA-Z]", "");
			Integer count=words.get(word);
			if(count!=null) {
				count++;
			}
			else {
				count=1;
			}
			words.put(word,count);
		}
		file.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Map<String,Integer> words=new TreeMap<String, Integer>();
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a path to directory: ");  
		String path= sc.nextLine(); 
		File dir = new File(path);
		
		
		if(dir.isFile()) {
			System.out.println("You have entered: "+ dir);
		}
		else {
			System.out.print("Path is not valid, program will now exit!");
			System.exit(0);
		}
		sc.close();
		CountWords(path,words);
		
		System.out.println("U datoteci "+path+" nalaze se sljedece rijeci:");
		System.out.println("------------------------\r\n"
				+ "Rijec (broj ponavljanja)\r\n"
				+ "------------------------");
		words.forEach((k,v)->System.out.printf("%s (%s)\n", k,v));
		System.out.println("------------------------");

	}
	
}
