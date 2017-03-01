package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;
import edu.cursor.u21.util.UtilityScanner;

import java.util.HashMap;

import static edu.cursor.u21.users.bankClient.Accounts.AccountType.CREDIT;
import static edu.cursor.u21.users.bankClient.Accounts.Currency.EUR;

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
            System.out.println("Enter \n" +
                    "1 - for list of Your accounts\n" +
                    "2 - to create NEW Account account\n" +
                    "6 - to delete account\n" +
                    "9 - for EXIT\n");
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("Your Accounts list:\n Account Number\t\t\t\t\t Account Type");
                    if (bankClient.getAccountHashMap().isEmpty()) {
                        System.out.println("You don't have any accounts(deposit, credit, saving or transfer)");
                    } else {
                        bankClient.getAccountHashMap().forEach((k, v) -> System.out.println(k + "\t\t" + v.toString()));
                    }
                    break;
                case 2:
                    System.out.println("Enter currency for your Account: 0 - EUR, 1 - USD, 2 - PLN, 3 - UAH");
                    Currency[] currencies = Currency.values();
                    int currency = UtilityScanner.scanNumberFromZeroToThree();

                    System.out.println("Enter type of Account: 0 - Credit, 1 - Deposit, 2 - Saving, 3 - Transfer");
                    AccountType[] accountTypesArray = AccountType.values();
                    int accountType = UtilityScanner.scanNumberFromZeroToThree();

                    AccountFactory.createNewAccount(bankClient, accountTypesArray[accountType], currencies[currency]);
                    break;
                case 6:
                    System.out.println("Enter the Account Number without spaces to Delete account\n");
                    AccountFactory.deleteAccount(bankClient, Utility.sc.nextLine());
                    break;
                case 9:
                    x = false;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }

    public static void main(String[] args) {
        BankClient bankClient = new BankClient();
        bankClient.setAccountHashMap(new HashMap<>());
        AccountFactory.createNewAccount(bankClient, CREDIT, EUR);
        System.out.println(bankClient.getAccountHashMap().isEmpty());
        bankClient.getAccountHashMap().values().forEach(account -> {
                System.out.println(account.toString());
        });
        AccountMenu.accountMenu(bankClient);
    }
}