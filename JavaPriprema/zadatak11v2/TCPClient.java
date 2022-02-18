package zadatak11v2;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
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

    static public ResourceBundle languagePicker() {

        String language;
        String country;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Pick a language:   \n1. ENG\n2. DE\n3. FR");
        int lng=0;
        
        do {
            lng = numberCheck(in);
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
        
        messages = ResourceBundle.getBundle("zadatak11v2.MessagesBundle", currentLocale);
        return messages;
    }


    public static void main(String[] args) throws IOException {

        String ip = "127.0.0.1"; //Lokalni ip
        Integer port=8000; //port
        System.out.println ("Pokusavam se spojiti na ip:  " + ip + ":"+port);


        PrintWriter out=null;
        BufferedReader in=null;
        Socket echoSocket=null;

        try {
            echoSocket = new Socket(ip, port);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Ip: " + ip + " nije prepoznat");
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String text; //String u koji se sprema BufferedReader stdIn i realLine();
        System.out.println("Uspjesno spojeno sa servrom!");

        ResourceBundle translation;
        translation = languagePicker();

        System.out.println("Input:");

        while ((text = stdIn.readLine()) != null) { //Sve dok postoji neki text input while funkcija radi
            out.println(text);

            System.out.print("\n[SERVER]: "); //server response
            String temp = in.readLine();

            if(temp.contains("hi") || temp.contains("Hi") || temp.contains("Hello") || temp.contains("hello")){
                System.out.print(translation.getString("greetings"));    
            }else if(temp.contains("bye") || temp.contains("Bye")){
                System.out.print(translation.getString("farewell"));
            }else if(temp.contains("How are you?") || temp.contains("how are you?")){
                System.out.print(translation.getString("inquiry"));
            }else{
                System.out.print(temp);
            }

            System.out.println("\nInput: ");

            if (text.equals("quit")) //Ukoliko je input quit ,gašenje clienta
                break;
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }

}