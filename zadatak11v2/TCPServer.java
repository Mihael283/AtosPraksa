package zadatak11v2;

import java.net.*;
import java.io.*;

public class TCPServer
{
    private static String[] ids={"User1","User2","User3"};
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = null;

        try {
            server = new ServerSocket(8000); //Server na portu 8000
        }
        catch (IOException e)
        {
            System.err.println("Port je zauzet!");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println ("Waiting for connection....");

        try {
            clientSocket = server.accept(); //Pokusaj privatiti dolazeci zahtjev za spajanje
        }
        catch (IOException e)
        {
            System.exit(1);
        }

        System.out.println ("Connection successful");
        System.out.println ("Cekanje na input..");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));

        String input;
        String userid=getRandomId(); //pomocu getrandomid funkcije dodijeljemo klijentu id

        while ((input = in.readLine()) != null)  //Sve dok postoji neki text input while funkcija radi
        {
            System.out.println (userid+":" + input);
            out.println(input); //ispis rijeci
            if (input.equals("quit"))
                break;
        }

        out.close();
        in.close();
        clientSocket.close();
        server.close();
    }

    public static String getRandomId() {
        String id = ids[(int) (Math.random() * ids.length)];
        return id;
    }

  
}