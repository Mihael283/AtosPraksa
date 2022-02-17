package zadatak15;

import java.util.*;
import java.io.*;
import java.sql.*;

class Employee{
    String name;
    String last_name;
    String workplace;
    String oib;
    public String lastname;


    public Employee(String name, String last_name, String workplace, String oib) {
        this.name = name;
        this.last_name = last_name;
        this.workplace = workplace;
        this.oib = oib;
    }

    
}



class Main extends TaskManagment{

    static String name;
    static String last_name;
    static String workplace;
    static String oib;

    static ArrayList<Employee> emp_list = new ArrayList<Employee>();

    /*static String task_name;
    static String desc;
    static String[] type = {"Bug","Task"};
    static String[] current_status = {"Open","Closed","In progress"};
    static String complexity;
    static String time_spent;
    static String starting_date_time;
    static String end_date_time;
    static ArrayList<Tasks> tasks = new ArrayList<Tasks>();
    */

    static Scanner sc = new Scanner(System.in);
			
    static File f = null;
    static Connection conn = null;

    public static int[] login(Scanner in)
	{	try{
        System.out.println("\nEnter Username : ");
        String username = in.next();

        System.out.println("Enter Password : ");
        String password = in.next();

        String databaseUsername = "";
        String databasePassword = "";

        int[] permissions = {0 , 0};

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

    

    public static void main(String[] args) throws ClassNotFoundException, IOException
	{

        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/task15","root", "");
        } catch (SQLException e) {         
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);
        }
        System.out.print("Database is connected !");
        
        int[] permissions;
        Scanner in = new Scanner(System.in);
        permissions = login(in);

        boolean admin = false;
        boolean superuser = false;
        if(permissions[0]>=1){
            admin = true;
        }

        if(permissions[1]>=1){
            superuser = true;
        }

        
        

        do
		{
			System.out.println("\n*********Welcome**********\n");


			System.out.println("1). Employee Managment\n" +
								"2). Task Managment\n" +
								"3). Reports\n" +
								"4). EXIT\n");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
                EmployeeMenu(admin, superuser);
                break;
						
			case 2:
                TaskMenu(admin, superuser, conn);
                break;
            
            case 3:
                //
                break;
            
            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("\nEnter a correct choice from the List :");
                break;
		    }
        }
		while(true);

    }

    

    public static void EmployeeMenu(boolean admin, boolean superuser) throws IOException{
        try{

            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM employee";
            
            ResultSet rs = stmt.executeQuery(SQL);
    
            while (rs.next()) {
                name = rs.getString("name");
                last_name = rs.getString("last_name");
                workplace = rs.getString("workplace");
                oib = rs.getString("oib");
                emp_list.add(new Employee(name,last_name,workplace,oib));
    
            }
    
            
    
        }catch(Exception e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);

        }



		do
		{
			System.out.println("\n*********Welcome to the Employee Management System**********\n");


			System.out.println("1). Add Employee to the DataBase\n" +
								"2). List Employees\n" +
								"3). Edit Employee details\n" +
								"4). Delete Employee Details\n" +
								"5). GO BACK\n");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
            if(admin == false && superuser == true && ch == 3 || ch == 4){
                do{
                    System.out.println("You don't have permissions to enter this section! Please repeat the input:");
                    ch = sc.nextInt();
                }while(ch == 3 || ch == 4);
            }else if(admin == false && superuser == false && ch !=2){
                do{
                    System.out.println("You don't have permissions to enter this section! Please repeat the input:");
                    ch = sc.nextInt();
                }while(ch !=2);
            }

			switch(ch)
			{
			case 1:
                System.out.println("\nEnter the following details to ADD list:\n");
                addEmployee();
                break;
						
			case 2:
                System.out.println("Enter the Employee oib to search :");
                listEmployee();
                break;
            
            case 3:
                System.out.println("Enter the Employee oib to search :");
                editEmployee();
                break;

            case 4:
                System.out.println("Enter the Employee oib to search :");
                deleteEmployee();
                break;

            case 5:
                return;


            default:
                System.out.println("\nEnter a correct choice from the List :");
                break;
		    }
        }
		while(true);
    }


    public static void addEmployee(){

        System.out.println("Enter Name :");
        name = sc.next();
        System.out.println("Enter LastName :");
        last_name = sc.next();
        System.out.println("Enter Workplace :");
        workplace = sc.next();
        System.out.println("Enter Oib :");
        oib = sc.next();

        emp_list.add(new Employee(name,last_name,workplace,oib));

        String SQL = "INSERT INTO `employee`(`name`, `last_name`, `workplace`, `oib`) VALUES ('"+name+"','"+last_name+"','"+workplace+"','"+oib+"');";
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(SQL);
            stmt.execute();
        } catch (SQLException e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);
        }
        
        

    }

    public static void listEmployee(){

        System.out.println("\n--------------Employee List---------------\n");
		System.out.println(String.format("%-15s%-15s%-20s%-10s","Name","Last Name","Workplace","OIB"));
		for(Employee e : emp_list)
		{
			System.out.println(String.format("%-15s%-15s%-20s%-10s",e.name,e.last_name,e.workplace,e.oib));
		}
    }

    public static void editEmployee(){

        oib = sc.next();
        int j = 0;

        PreparedStatement stmt;
        String SQL="";
        
        
        for(Employee e: emp_list)
        {
            if(e.oib.equals(oib))
            {	

                j++;
            do{
                int ch1 =0;
                System.out.println("\nEDIT Employee Details :\n" +
                                    "1). Name\n" +
                                    "2). LastName\n" +
                                    "3). Workplace.\n" +
                                    "4). GO BACK\n");
                System.out.println("Enter your choice : ");
                String temp;
                ch1 = sc.nextInt();
                switch(ch1)
                {
                case 1: 
                        System.out.println("Enter new Employee Name:");
                        temp = sc.next();

                        SQL = "UPDATE `employee` SET `name`='"+temp+"' WHERE `oib`='"+oib+"' ;";
                        sendQuery(SQL);
                        e.name = temp;
                        break;
                        
                case 2: System.out.println("Enter new Employee LastName:");
                        temp = sc.next();

                        SQL = "UPDATE `employee` SET `last_name`='"+temp+"' WHERE `oib` = '"+oib+"' ;";
                        sendQuery(SQL);
                        e.last_name = temp;
                        break;
                        
                case 3: System.out.println("Enter new Employee Workplace:");
                        temp = sc.next();

                        SQL = "UPDATE `employee` SET `workplace`='"+temp+"' WHERE `oib` = '"+oib+"' ;";
                        sendQuery(SQL);
                        e.workplace = temp;
                        break;
                        
                case 4: j++;
                        break;
                        
                default : System.out.println("\nEnter a correct choice from the List :");
                            break;
                
                }
                }
            while(j==1);
            }
        }
        if(j == 0)
        {
            System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
        }
    
    }

    public static void deleteEmployee(){

        oib = sc.next();

        boolean trigger = false;
        String SQL;
        try{
            for(Employee e: emp_list)
            {
                if(e.oib.equals(oib))
                {       
                        SQL = "DELETE FROM `employee` WHERE `oib` = '"+oib+"' ;";
                        sendQuery(SQL);
                        emp_list.remove(e);
                        System.out.println("Employee successfully deleted");
                        trigger = true;
                        break;
                }
            }
            if(!trigger)
            {
                System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
            }
        }catch(Exception ex){        
            System.out.println(ex);
        }

    }

    public static void sendQuery(String SQL){

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(SQL);
            stmt.execute();
        } catch (SQLException er) {
            System.out.print("Connection to DB - Error:"+er);
            System.exit(0);
        }

    }
}   

