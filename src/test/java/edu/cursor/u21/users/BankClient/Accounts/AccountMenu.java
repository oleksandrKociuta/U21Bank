package edu.cursor.u21.users.BankClient.Accounts;

import edu.cursor.u21.Utils.Utility;
import edu.cursor.u21.users.BankClient.BankClient;

/**
 * Created by uiv on 2/18/17.
 */
public class AccountMenu {
    private AccountMenu() {
    throw new IllegalStateException();
}

    public static void accountMenu(BankClient bankClient) {
        System.out.println("Enter \n" +
                "1 - for list of BankClient accounts\n" +
                "2 - create Deposit account\n" +
                "3 - create Credit account\n" +
                "4 - create Saving account\n" +
                "5 - create Transfer account\n" +
                "6 - delete account\n" +
                "7 -  " +
                "8 -  " +
                "9 - for list of For exit press 9");
        while (true) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("BankClients list:");

                    break;
                case 2:
                    System.out.printf("List of user operations. \n Enter User ID:");

                    break;
                case 3:
                    System.out.println("Users Phone Numbers");

                    break;
                case 4:
                    System.out.println("Users date of birth");
                    break;

                case 5:
                    System.out.println("Users Accounts");
                    break;

                case 6:
                    System.out.println("Users Credit Accounts");
                    break;

                case 7:
                    System.out.println("Users Deposit Accounts");
                    break;

                case 8:
                    System.out.println("User Transfer BankClient");
                    break;

                case 9:
                    System.out.println("For exit press 9");
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}