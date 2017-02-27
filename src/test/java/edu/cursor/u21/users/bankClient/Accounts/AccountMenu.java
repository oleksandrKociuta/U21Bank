package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;

/**
 * Created by uiv on 2/18/17.
 */
public class AccountMenu {
    private AccountMenu() {
        throw new IllegalStateException();
    }

    public static void accountMenu(BankClient bankClient) {
        System.out.println("Enter \n" +
                "1 - for list of Your accounts\n" +
                "2 - to create DEPOSIT account\n" +
                "3 - to create CREDIT account\n" +
                "4 - to create SAVING account\n" +
                "5 - to create TRANSFER account\n" +
                "6 - to delete account\n" +
                "7 - to information on DEPOSIT account \n" +
                "8 - to information on CREDIT account \n" +
                "9 - for EXIT\n");
        boolean x = true;
        while (x) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("Your Accounts list:\n Account Number\t\t\t\t\t Account Type");
                    try {
                        bankClient.getAccountHashMap().forEach((k, v) -> System.out.println(k + "\t\t" + v.toString()));
                    } catch (NullPointerException e) {
                        System.out.println("You don't have any accounts(deposit, credit, saving or transfer)");
                    }
                    break;
                case 2:
                    System.out.println("Choose currency for Credit: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    int operator = Utility.getInt();
                    if (operator == 1) {
                        AccountFactory.createAccount(new Credit(), Currency.EUR, bankClient);
                    } else if (operator == 2) {
                        AccountFactory.createAccount(new Credit(), Currency.USD, bankClient);
                    } else if (operator == 3) {
                        AccountFactory.createAccount(new Credit(), Currency.PLN, bankClient);
                    } else {
                        AccountFactory.createAccount(new Credit(), Currency.UAH, bankClient);
                    }
                    break;
                case 3:
                    System.out.println("Choose currency for Deposit: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    int operator1 = Utility.getInt();
                    if (operator1 == 1) {
                        AccountFactory.createAccount(new Deposit(), Currency.EUR, bankClient);
                    } else if (operator1 == 2) {
                        AccountFactory.createAccount(new Deposit(), Currency.USD, bankClient);
                    } else if (operator1 == 3) {
                        AccountFactory.createAccount(new Deposit(), Currency.PLN, bankClient);
                    } else {
                        AccountFactory.createAccount(new Deposit(), Currency.UAH, bankClient);
                    }
                    break;
                case 4:
                    System.out.println("Choose currency for Saving account: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    int operator2 = Utility.getInt();
                    if (operator2 == 1) {
                        AccountFactory.createAccount(new Saving(), Currency.EUR, bankClient);
                    } else if (operator2 == 2) {
                        AccountFactory.createAccount(new Saving(), Currency.USD, bankClient);
                    } else if (operator2 == 3) {
                        AccountFactory.createAccount(new Saving(), Currency.PLN, bankClient);
                    } else {
                        AccountFactory.createAccount(new Saving(), Currency.UAH, bankClient);
                    }
                    break;
                case 5:
                    System.out.println("Choose currency for Transfer account: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    int operator3 = Utility.getInt();
                    if (operator3 == 1) {
                        AccountFactory.createAccount(new Transfer(), Currency.EUR, bankClient);
                    } else if (operator3 == 2) {
                        AccountFactory.createAccount(new Transfer(), Currency.USD, bankClient);
                    } else if (operator3 == 3) {
                        AccountFactory.createAccount(new Transfer(), Currency.PLN, bankClient);
                    } else {
                        AccountFactory.createAccount(new Transfer(), Currency.UAH, bankClient);
                    }
                    break;
                case 6:
                    System.out.println("Enter the Account Number without spaces to Delete account\n");
                    AccountFactory.deleteAccount(Utility.sc.nextLine(), bankClient);
                    break;
                case 7:
                    System.out.println("Information on deposit account\n");
                    bankClient.getAccountHashMap().values().forEach(a -> {
                        if (a instanceof Deposit) {
                            System.out.println(a.toString());
                        }
                    });
                    break;
                case 8:
                    System.out.println("Information on credit account\n");
                    bankClient.getAccountHashMap().values().forEach(a -> {
                        if (a instanceof Credit) {
                            System.out.println(a.toString());
                        }
                    });
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