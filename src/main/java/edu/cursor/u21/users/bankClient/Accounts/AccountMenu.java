package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.Admin.AdminMethods;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;
import edu.cursor.u21.util.UtilityScanner;

/**
 * Created by uiv on 2/18/17.
 */
public class AccountMenu {
    private AccountMenu() {
        throw new IllegalStateException();
    }

    public static void accountMenu(BankClient bankClient) {

        boolean x = true;
        while (x) {
            System.out.println("Press \n" +
                    "1 - for list of Your accounts\n" +
                    "2 - to create NEW Account\n" +
                    "6 - to change Account Status\n" +
                    "9 - for EXIT\n");
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("Your Accounts:");
                   new AdminMethods().displayUserAccounts(bankClient.getId());
                    break;
                case 2:
                    System.out.println("Enter currency for your Account: 0 - EUR, 1 - USD, 2 - PLN, 3 - UAH");
                    Currency[] currencies = Currency.values();
                    int currency = UtilityScanner.scanNumberFromZeroToThree();

                    System.out.println("Enter type of Account: 0 - Credit, 1 - Deposit, 2 - Saving, 3 - Transfer");
                    AccountType[] accountTypesArray = AccountType.values();
                    int accountType = UtilityScanner.scanNumberFromZeroToThree();

                    new AccountFactory().getNewAccount(bankClient, accountTypesArray[accountType], currencies[currency]);
                    break;
                case 6:
                    System.out.println("Enter the Account Number without spaces to Change Account STATUS\n");
                    new AccountFactory().changeAccountStatus(bankClient.getId(), UtilityScanner.sc.nextLine());
                    break;
                case 9:
                    x = false;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}