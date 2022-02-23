package zadatak15;

import java.util.*;
import java.sql.*;

public class Login {



    public int[] login(Scanner in, Connection conn)
	{	
        
        String databaseUsername = "";
        String databasePassword = "";

        try{

        System.out.println("\nEnter Username : ");
        String username = in.next();

        System.out.println("Enter Password : ");
        String password = in.next();

        int[] permissions = {0 , 0}; // Default 0 0 znaci da nema ni superuser ni admin pravo suprotno je 1 1

                // Create SQL Query
        Statement stmt = conn.createStatement();
        String SQL = "SELECT * FROM users WHERE username='" + username + "' && password='" + password+ "'";

        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            databaseUsername = rs.getString("username");
            databasePassword = rs.getString("password");
            permissions[0] = rs.getInt("is_admin");
            permissions[1] = rs.getInt("is_superuser");

        }

        if (username.equals(databaseUsername) && password.equals(databasePassword)) {
            System.out.println("Successful Login!");
            return permissions;

        } else {
            System.out.println("Incorrect Password! Program will now exit.");
            System.exit(0);
        }

        }catch(Exception e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);

        }

        return null;
	}

}

