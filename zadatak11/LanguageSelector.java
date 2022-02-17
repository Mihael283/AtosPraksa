package zadatak11;

import java.util.*;

public class LanguageSelector {
	static public void main(String[] args) {

		String language;
    String country;
    
    Scanner in = new Scanner(System.in);
		System.out.println("Pick a language:   \n1. ENG\n2. DE\n3. FR");
		int lng=0;
		
		do {
			 lng = in.nextInt();
		}while(lng < 0 || lng >3);

        
    switch(lng) {
    case 1:
      language = new String("en");
      country = new String("US");
      break;
    case 2:
      language = new String("de");
      country = new String("DE");
      break;
    case 3:
      language = new String("fr");
      country = new String("FR");
      break;
    default:
      language = new String("en");
      country = new String("US");
    }
        
        
        
        Locale currentLocale;
        ResourceBundle messages;

        currentLocale = new Locale(language, country);
        
        
        System.out.println("WELCOME!\nYou are about to see three lines of text from the most advanced translation bot ever :)");  
        messages = ResourceBundle.getBundle("zadatak11.MessagesBundle", currentLocale);
        System.out.println(messages.getString("greetings"));         
        System.out.println(messages.getString("inquiry"));        
        System.out.println(messages.getString("farewell"));
        in.close();
    }
}
