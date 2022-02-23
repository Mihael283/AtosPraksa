package zadatak15;

import java.util.*;
import java.io.*;
import java.sql.*;

public class TaskManagment {
    ArrayList<Tasks> task_list = new ArrayList<Tasks>();
    Scanner sc = new Scanner(System.in);
    File f = null;
    Connection connt = null;

    public void TaskMenu(boolean admin, boolean superuser, Connection conn) throws IOException {

        try {
            connt = conn;
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM tasks";

            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {

                Tasks temp = new Tasks();
                temp.setOib(rs.getString("oib_task"));
                temp.setTask_name(rs.getString("task_name"));
                temp.setDesc(rs.getString("task_desc"));
                temp.setType(rs.getString("type"));
                temp.setCurrent_status(rs.getString("current_status"));
                temp.setComplexity(rs.getInt("complexity"));
                temp.setTime_spent(rs.getString("spent_time"));
                temp.setStarting_date_time(rs.getString("start_time"));
                temp.setEnd_date_time(rs.getString("end_time"));

                task_list.add(temp);

            }

        } catch (Exception e) {
            System.out.print("Connection to DB - Error:" + e);
            System.exit(0);

        }

        do {
            System.out.println("\n*********Welcome to the Task Management System**********\n");

            System.out.println("1). Add Task to the DataBase\n" +
                    "2). List Tasks\n" +
                    "3). Edit Task details\n" +
                    "4). Delete Task\n" +
                    "5). GO BACK\n");
            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();

            if ((admin == false) && (superuser == true) && (ch == 3 || ch == 4)) {
                do {
                    System.out.println("You don't have permissions to enter this section! Please repeat the input:");
                    ch = sc.nextInt();
                } while (ch == 3 || ch == 4);
            } else if ((admin == false) && (superuser == false) && ch != 2) {
                do {
                    System.out.println("You don't have permissions to enter this section! Please repeat the input:");
                    ch = sc.nextInt();
                } while (ch != 2);
            }

            switch (ch) {
                case 1:
                    System.out.println("\nEnter the following details to ADD list:\n");
                    addTask();
                    break;

                case 2:
                    System.out.println("Enter the task name to search :");
                    listTasks();
                    break;

                case 3:
                    System.out.println("Enter the task name to search :");
                    editTask();
                    break;

                case 4:
                    System.out.println("Enter the task name to search :");
                    deleteTask();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("\nEnter a correct choice from the List :");
                    break;
            }
        } while (true);
    }

    public void addTask() {

        Tasks temp = new Tasks();
        
        System.out.println("Enter Task Name :");
        temp.setTask_name(sc.next());
        System.out.println("Enter Desc :");
        temp.setDesc(sc.next());
        System.out.println("Enter Type :");
        temp.setType(sc.next());
        System.out.println("Enter Current Status :");
        temp.setCurrent_status(sc.next());
        System.out.println("Enter Complexity :");
        temp.setComplexity(sc.nextInt());
        System.out.println("Enter Time Spent :");
        temp.setTime_spent(sc.next());
        System.out.println("Enter Starting date :");
        temp.setStarting_date_time(sc.next());
        System.out.println("Enter End date :");
        temp.setEnd_date_time(sc.next());
        System.out.println("Enter Worker Oib :");
        temp.setOib(sc.next());

        task_list.add(temp);

        String SQL = "INSERT INTO `tasks`(`oib_task`, `task_name`, `task_desc`, `type`, `current_status`, `complexity`, `spent_time`, `start_time`, `end_time`) VALUES ('"
                + temp.getOib() + "','" + temp.getTask_name() + "','" + temp.getDesc() + "','" + temp.getType() + "','" + temp.getCurrent_status() + "','" + temp.getComplexity()
                + "','" + temp.getTime_spent() + "','" + temp.getStarting_date_time() + "','" + temp.getEnd_date_time() + "');";

        PreparedStatement stmt;

        try {
            stmt = connt.prepareStatement(SQL);
            stmt.execute();
        } catch (SQLException e) {
            System.out.print("Connection to DB - Error:" + e);
            System.exit(0);
        }

    }

    public void listTasks() {

        System.out.println("\n--------------Task List---------------\n");
        System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-10s", "Name", "Desc", "Type",
                "Status", "Complexity", "Time spent", "Starting date", "End date", "OIB"));
        for (Tasks t : task_list) {
            System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-10s", t.task_name, t.desc,
                    t.type, t.current_status, t.complexity, t.time_spent, t.starting_date_time, t.end_date_time,
                    t.oib));
        }
    }

    public void editTask() {

        String name = sc.next();
        int j = 0;

        String SQL = "";

        for (Tasks t : task_list) {
            if (t.task_name.equals(name)) {

                j++;
                do {
                    int ch1 = 0;
                    System.out.println("\nEDIT Task Details :\n" +
                            "1). Desc\n" +
                            "2). Status\n" +
                            "3). End time.\n" +
                            "4). GO BACK\n");
                    System.out.println("Enter your choice : ");
                    String temp;
                    ch1 = sc.nextInt();
                    switch (ch1) {
                        case 1:
                            System.out.println("Enter new description:");
                            temp = sc.next();

                            SQL = "UPDATE `tasks` SET `task_desc`='" + temp + "' WHERE `task_name` = '" + name + "' ;";
                            sendQuery(SQL);
                            t.desc = temp;
                            break;

                        case 2:
                            System.out.println("Enter new status:");
                            temp = sc.next();

                            SQL = "UPDATE `tasks` SET `current_status`='" + temp + "' WHERE `task_name` = '" + name
                                    + "' ;";
                            sendQuery(SQL);
                            t.current_status = temp;
                            break;

                        case 3:
                            System.out.println("Enter end time:");
                            temp = sc.next();

                            SQL = "UPDATE `tasks` SET `end_time`='" + temp + "' WHERE `task_name` = '" + name + "' ;";
                            sendQuery(SQL);
                            t.end_date_time = temp;
                            break;

                        case 4:
                            j++;
                            break;

                        default:
                            System.out.println("\nEnter a correct choice from the List :");
                            break;

                    }
                } while (j == 1);
            }
        }
        if (j == 0) {
            System.out.println("\nTask Details are not available, Please enter a valid name!!");
        }

    }

    public void deleteTask() {

        String name = sc.next();

        boolean trigger = false;
        String SQL;
        try {
            for (Tasks t : task_list) {
                if (t.task_name.equals(name)) {
                    SQL = "DELETE FROM `task` WHERE `task_name` = '" + name + "' ;";
                    sendQuery(SQL);
                    task_list.remove(t);
                    System.out.println("Task successfully deleted");
                    trigger = true;
                    break;
                }
            }
            if (!trigger) {
                System.out.println("\nTask Details are not available, Please enter a valid name!!");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void sendQuery(String SQL) {

        PreparedStatement stmt;

        try {
            stmt = connt.prepareStatement(SQL);
            stmt.execute();
        } catch (SQLException er) {
            System.out.print("Connection to DB - Error:" + er);
            System.exit(0);
        }

    }

    public int numberCheck(Scanner in) {
        boolean isNumber = false;
        while (!isNumber)
            try {
                int temp = in.nextInt();
                in.nextLine();
                isNumber = true;// numeric value entered, so break the while loop
                return temp;
            } catch (InputMismatchException ime) {
                // Display Error message
                System.out.println("Invalid character found, please enter a number:");
                in.nextLine();// Advance the scanner
            }

        return -1;
    }
}
