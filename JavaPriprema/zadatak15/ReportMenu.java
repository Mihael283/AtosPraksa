package zadatak15;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReportMenu {

    public void openReportMenu(boolean admin, boolean superuser, Connection conn, Scanner sc) throws IOException{ //Menu
        
		do
		{          
			System.out.println("\n*********Welcome to the Report Menu**********\n");


			System.out.println("1). Count number of workers on a workplace\n" +
								"2). Time spent per person\n" +
								"3). Longest open task\n" +
								"4). GO BACK\n");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
            if(admin == false && superuser == false){
                System.out.println("You don't have permissions to enter this section!");
                sc.close();
                return;
            }

			switch(ch)
			{
			case 1:
                countEmployeeWorkplace(conn);
                break;
						
			case 2:
                timeSpent(conn);
                break;
            
            case 3:
                longestOpenTask(conn);
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

    public static void countEmployeeWorkplace(Connection conn){             //Ispisuje broj radnika na pojedinom radnom mjestu
        String workplace;
        /*SELECT COUNT(oib), workplace FROM employee GROUP BY workplace;*/
        try{

            Statement stmt = conn.createStatement();
            String SQL = "SELECT COUNT(oib), workplace FROM employee GROUP BY workplace;";
            
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println(String.format("%-15s%-15s","Count","Workplace"));

            String count;
            while (rs.next()) {
                count = rs.getString("COUNT(oib)");
                workplace = rs.getString("workplace");
                	        
                System.out.println(String.format("%-15s%-15s",count,workplace));
            }
            
       
        }catch(Exception e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);

        }
        

    }

    public static void timeSpent(Connection conn){ //Ispis zdataka po potrošenom vremenu

        String name;
        String task_name;
        String time_spent;
        try{

            Statement stmt = conn.createStatement();
            String SQL = "SELECT name,task_name,spent_time FROM tasks,employee WHERE oib_task = oib ORDER BY spent_time ASC";
            
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println("\n--------------Task per Employee list---------------\n");

            while (rs.next()) {
                name = rs.getString("name");
                task_name = rs.getString("task_name");
                time_spent = rs.getString("spent_time");
                
                
		        System.out.println(String.format("%-15s%-15s%-20s","Name","Task Name","Time Spent"));
                System.out.println(String.format("%-15s%-15s%-20s",name,task_name,time_spent));
            }
            
       
        }catch(Exception e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);

        }
        
        

    }

    public static void longestOpenTask(Connection conn){ //ispis zadatka koji je najduže otvoren

        String task_name ="";
        String starting_date_time="";

        try{

            Statement stmt = conn.createStatement();
            String SQL = "SELECT task_name, start_time FROM tasks ORDER BY start_time ASC LIMIT 1";
            
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                task_name = rs.getString("task_name");
                starting_date_time = rs.getString("start_time");
                
    
            }
            System.out.println("Longest opet task is :"+task_name+" with start date "+starting_date_time);
       
        }catch(Exception e) {
            System.out.print("Connection to DB - Error:"+e);
            System.exit(0);

        }
        
        

    }
}
