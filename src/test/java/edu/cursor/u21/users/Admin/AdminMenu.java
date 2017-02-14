package edu.cursor.u21.users.Admin;

import edu.cursor.u21.Utils.Utility;
import edu.cursor.u21.users.BankClient.BankClient;

import java.util.HashMap;

import static edu.cursor.u21.Utils.UtilityScanner.sc;
import static edu.cursor.u21.Utils.UtilityScanner.scanInt;

/**
 * Created by uiv on 2/12/17.
 */
public class AdminMenu {
    private AdminMenu() {
        throw new IllegalStateException();
    }

    public static void adminMenu(HashMap<String, BankClient> listOfUsers) {
        System.out.println("Enter \n" +
                "1 - for list of BankClients\n" +
                "2 - for list of User operations (ID is needed to be entered)\n" +
                "3 - for list of Users Phone Numbers" +
                "4 - for list of Users date of birth" +
                "5 - for list of Users Accounts" +
                "6 - for list of Users Credit Accounts" +
                "7 - for list of Users Deposit Accounts" +
                "8 - for list of User Transfer Account" +
                "9 - for list of For exit press 9");
        while (true) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("BankClients list:");
                    AdminMethods.displayListOfUsers(listOfUsers);
                    break;
                case 2:
                    System.out.printf("List of user operations. \n Enter User ID:");
                    AdminMethods.filterByAge(scanInt(), listOfUsers);
                    break;
                case 3:
                    System.out.println("Users Phone Numbers");
                    AdminMethods.displayUsersPhoneNumbers(listOfUsers);
                    break;
                case 4:
                    System.out.println("Users date of birth");
                    AdminMethods.displayUsersDateOfBirth(listOfUsers);
                case 5:
                    System.out.println("Users Accounts");
                    AdminMethods.displayUsersAccounts(listOfUsers);
                case 6:
                    System.out.println("Users Credit Accounts");
                    AdminMethods.displayUsersCreditAccounts(listOfUsers);
                case 7:
                    System.out.println("Users Deposit Accounts");
                    AdminMethods.displayUsersDepositAccounts(listOfUsers);
                case 8:
                    System.out.println("User Transfer Account");
                    AdminMethods.displayUserTransferAccount(sc.next());
                case 9:
                    System.out.println("For exit press 9");
                    System.exit(0);
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}
