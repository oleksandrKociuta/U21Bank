package edu.cursor.u21.users.Admin;

import edu.cursor.u21.Utils.Read;
import edu.cursor.u21.Utils.Utility;

import java.util.ArrayList;

import static edu.cursor.u21.Utils.UtilityScanner.sc;

/**
 * Created by uiv on 2/12/17.
 */
public class AdminMenu {
    private AdminMenu(){
        throw new IllegalStateException();
    }

    public static void adminMenu() {
        System.out.println("Enter \n" +
                            "1 - for list of BankClients\n" +
                            "2 - for list of User operations (ID is needed to be entered)\n" +
                            "3 - for list of ");
        while (true) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("BankClients id list:");
                    ArrayList<Admin> al = (ArrayList<Admin>) Read.readFile("admin.md");
                    System.out.println("\tLogin \tPassword \t\t\t\t\t\t\tRole");
                    al.forEach(admin -> System.out.printf("\t%s \t%s \t%s\n",admin.getLogin(), admin.getPassword(), admin.getRole()));

                    break;
                case 2:
                    System.out.printf("List of user operations. \n Enter User ID");
                    sc.next();

                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("For exit press 4");
                    System.exit(0);
                default:
                    System.out.println("Wrong number!");
            }
         }
    }
}
