package edu.cursor.u21.users.Admin;

import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;

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
                "1 - for a list of BankClients\n" +
                "2 - to filter Bank Clients by age (Age is needed to be entered)\n" +
                "3 - for a list of Users Phone Numbers\n" +
                "4 - for a list of Users date of birth\n" +
                "5 - for a list of Users Accounts\n" +
                "6 - for a list of Users CREDIT Accounts\n" +
                "7 - for a list of Users DEPOSIT Accounts\n" +
                "8 - for a list of User TRANSFER Accounts\n" +
                "9 - for a list of User SAVING Accounts\n" +
                "10 - Print Bank Clients list sorted by username\n" +
                "11 - to display detail Bank Clients accounts\n" +
                "12 - for EXIT\n");
        boolean x = true;
        while (x) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("BankClients list:");
                    AdminMethods.displayListOfUsers(listOfUsers);
                    break;
                case 2:
                    System.out.printf("Filter Bank Clients by age. \n " +
                            "Enter age to filter by:");
                    AdminMethods.filterByAge(scanInt(), listOfUsers);
                    break;
                case 3:
                    System.out.println("Bank Clients Phone Numbers");
                    AdminMethods.displayUsersPhoneNumbers(listOfUsers);
                    break;
                case 4:
                    System.out.println("Bank Clients date of birth");
                    AdminMethods.displayUsersDateOfBirth(listOfUsers);
                    break;
                case 5:
                    System.out.println("Bank Clients Accounts Numbers");
                    AdminMethods.displayUsersAccountsNumbers(listOfUsers);
                    break;
                case 6:
                    System.out.println("Bank Clients Credit Accounts");
                    AdminMethods.displayUsersCreditAccounts(listOfUsers);
                    break;
                case 7:
                    System.out.println("Bank Clients Deposit Accounts");
                    AdminMethods.displayUsersDepositAccounts(listOfUsers);
                    break;
                case 8:
                    System.out.println("Bank Clients Transfer Accounts");
                    AdminMethods.displayUsersTransferAccounts(listOfUsers);
                    break;
                case 9:
                    System.out.println("Bank Clients Saving Accounts");
                    AdminMethods.displayUsersSavingAccounts(listOfUsers);
                    break;
                case 10:
                    System.out.println("Print Bank Clients list sorted by username");
                    AdminMethods.printBankClientsBySurname(listOfUsers);
                    break;
                case 11:
                    System.out.println("Display detail Bank Clients accounts");
                    AdminMethods.displayDetailUsersAccounts(listOfUsers);
                    break;
                case 12:
                    x = false;
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Wrong number! ");
            }
        }
    }
}
