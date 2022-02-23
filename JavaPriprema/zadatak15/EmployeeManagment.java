package zadatak15;

import java.util.*;
import java.io.*;
import java.sql.*;


public class EmployeeManagment{

    ArrayList<Employee> emp_list = new ArrayList<Employee>();
 
    public Connection conn = null;
    public File f = null;
    public Scanner sc = new Scanner(System.in);
    public Connection connectToDB() throws ClassNotFoundException{
   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/task15","root", "");
        } catch (SQLException e) {         
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);
        }
        System.out.print("Database is connected !");
        
        return conn;

    }
    
       
    public void EmployeeMenu(boolean admin, boolean superuser) throws IOException{
        
        try{

            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM employee";
            
            ResultSet rs = stmt.executeQuery(SQL);
    
            while (rs.next()) {
                Employee temp = new Employee();
                temp.setName(rs.getString("name"));
                temp.setLast_name(rs.getString("last_name"));
                temp.setWorkplace(rs.getString("workplace"));
                temp.setOib(rs.getString("oib"));

                emp_list.add(temp);
    
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
			
            
            if((admin == false) && (superuser == true) && (ch == 3 || ch == 4)){
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

    public void addEmployee(){

        Employee temp = new Employee();
        temp.setName(sc.next());
        temp.setLast_name(sc.next());
        temp.setWorkplace(sc.next());
        temp.setOib(sc.next());

        emp_list.add(temp);

        String SQL = "INSERT INTO `employee`(`name`, `last_name`, `workplace`, `oib`) VALUES ('"+temp.getName()+"','"+temp.getLast_name()+"','"+temp.getWorkplace()+"','"+temp.getOib()+"');";
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(SQL);
            stmt.execute();
        } catch (SQLException e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);
        }
        
        

    }

    public void listEmployee(){

        System.out.println("\n--------------Employee List---------------\n");
		System.out.println(String.format("%-15s%-15s%-20s%-10s","Name","Last Name","Workplace","OIB"));
		for(Employee e : emp_list)
		{
			System.out.println(String.format("%-15s%-15s%-20s%-10s",e.name,e.last_name,e.workplace,e.oib));
		}
    }

    public void editEmployee(){

        String oib = sc.next();
        int j = 0;

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

    public void deleteEmployee(){

        String oib = sc.next();

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

    public void sendQuery(String SQL){

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

