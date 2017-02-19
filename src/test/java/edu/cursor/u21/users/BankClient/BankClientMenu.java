package edu.cursor.u21.users.BankClient;

import edu.cursor.u21.util.Utility;

/**
 * Created by uiv on 2/13/17.
 */
public class BankClientMenu {
    private BankClientMenu() {
        throw new IllegalStateException();
    }

    public static void userMenu(BankClient bankClient) {
        System.out.println("Enter \n" +
                "1 - to create Deposit Account\n" +
                "2 - to create Credit Account\n" +
                "3 - to create Saving Account\n" +
                "4 - to create Transfer Account\n" +
                "5 - for list of Your Accounts\n" +
                "6 - for exit\n");
        boolean x = true;
        while (x) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("Your Accounts list:\n Account Number\t\t\t\t\t Account Type");
                    bankClient.getAccountHashMap().forEach((k,v) -> System.out.println(k+ "\t\t" + v.));
                    break;
                case 2:
                    System.out.printf("List of user operations.");

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
                    default:
                        System.out.println("you should no be here");
            }
        }
    }
}