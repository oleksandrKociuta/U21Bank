package edu.cursor.u21.users.Admin;

import edu.cursor.u21.util.Utility;
import edu.cursor.u21.users.BankClient.BankClient;

import java.util.HashMap;

import static edu.cursor.u21.util.UtilityScanner.scanInt;

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
                "3 - for list of Users Phone Numbers\n" +
                "4 - for list of Users date of birth\n" +
                "5 - for list of Users Accounts\n" +
                "6 - for list of Users CREDIT Accounts\n" +
                "7 - for list of Users DEPOSIT Accounts\n" +
                "8 - for list of User TRANSFER Accounts\n" +
                "9 - for list of User SAVING Accounts\n" +
                "10 - Print Bank Clients list sorted by username\n"+
                "11 - for EXIT\n");
        boolean x = true;
        while (x) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("BankClients list:");
                    AdminMethods.displayListOfUsers(listOfUsers);
                    break;
                case 2:
                    System.out.printf("List of user operations. \n " +
                                      "Enter User age to filter by:");
                    AdminMethods.filterByAge(scanInt(), listOfUsers);
                    break;
                case 3:
                    System.out.println("Users Phone Numbers");
                    AdminMethods.displayUsersPhoneNumbers(listOfUsers);
                    break;
                case 4:
                    System.out.println("Users date of birth");
                    AdminMethods.displayUsersDateOfBirth(listOfUsers);
                    break;
                case 5:
                    System.out.println("Users Accounts");
                    AdminMethods.displayUsersAccounts(listOfUsers);
                    break;
                case 6:
                    System.out.println("Users Credit Accounts");
                    AdminMethods.displayUsersCreditAccounts(listOfUsers);
                    break;
                case 7:
                    System.out.println("Users Deposit Accounts");
                    AdminMethods.displayUsersDepositAccounts(listOfUsers);
                    break;
                case 8:
                    System.out.println("User Transfer Accounts");
                    AdminMethods.displayUserTransferAccount(listOfUsers);
                    break;
                case 9:
                    System.out.println("User Saving Accounts");
                    AdminMethods.displayUserSavingAccount(listOfUsers);
                    break;
                case 10:
                    System.out.println("Print Bank Clients list sorted by username");
                    AdminMethods.printBankClientsBySurname(listOfUsers);
                    break;
                case 11:
                    x = false;
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}
