package zadatak15;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagment employee_obj = new EmployeeManagment();
        Connection conn = employee_obj.connectToDB();

        Login loginObj = new Login(); // Login handler
        int[] permissions = loginObj.login(sc, conn); // Return permissions which are defined by 1 or 0

        boolean admin = false;
        boolean superuser = false;

        if (permissions[0] >= 1) { // simple permission asigners
            admin = true;
        }
        if (permissions[1] >= 1) {
            superuser = true;
        }

        do // Simple menu
        {
            System.out.println("\n*********Welcome**********\n");

            System.out.println("1). Employee Managment\n" +
                    "2). Task Managment\n" +
                    "3). Reports\n" +
                    "4). EXIT\n");
            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    EmployeeManagment employeeMngmt_obj = new EmployeeManagment()
                    employeeMngmt_obj.EmployeeMenu(admin, superuser);
                    break;

                case 2:
                    TaskManagment taskMen_obj = new TaskManagment();
                    taskMen_obj.TaskMenu(admin, superuser, conn);
                    break;

                case 3:
                    ReportMenu reportMenu_obj = new ReportMenu();
                    reportMenu_obj.openReportMenu(admin, superuser, conn, sc);
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nEnter a correct choice from the List :");
                    break;
            }
        } while (true);

    }
}
