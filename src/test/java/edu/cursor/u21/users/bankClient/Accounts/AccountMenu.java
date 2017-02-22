package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.util.Utility;
import edu.cursor.u21.users.bankClient.BankClient;

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
                "7 -  \n" +
                "8 -  \n" +
                "9 - for EXIT\n");
        boolean x = true;
        while (x) {
            switch (Utility.getInt()) {
                case 1:
                    System.out.println("Your Accounts list:\n Account Number\t\t\t\t\t Account Type");
                    bankClient.getAccountHashMap().forEach((k,v) -> System.out.println(k+ "\t\t" + v.toString()));
                    break;
                case 2:
                    System.out.println("Choose currency for Credit: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    if(Utility.getInt() == 1){
                    AccountFactory.createAccount(new Credit(), Currency.EUR, bankClient);}
                    else if(Utility.getInt() == 2){ AccountFactory.createAccount(new Credit(), Currency.USD, bankClient);}
                    else if(Utility.getInt() == 3){ AccountFactory.createAccount(new Credit(), Currency.PLN, bankClient);}
                    else { AccountFactory.createAccount(new Credit(), Currency.UAH, bankClient);}
                    break;
                case 3:
                    System.out.println("Choose currency for Deposit: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    if(Utility.getInt() == 1){AccountFactory.createAccount(new Deposit(), Currency.EUR, bankClient);}
                    else if(Utility.getInt() == 2){ AccountFactory.createAccount(new Deposit(), Currency.USD, bankClient);}
                    else if(Utility.getInt() == 3){ AccountFactory.createAccount(new Deposit(), Currency.PLN, bankClient);}
                    else { AccountFactory.createAccount(new Deposit(), Currency.UAH, bankClient);}
                    break;
                case 4:
                    System.out.println("Choose currency for Saving account: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    if(Utility.getInt() == 1){AccountFactory.createAccount(new Saving(), Currency.EUR, bankClient);}
                    else if(Utility.getInt() == 2){ AccountFactory.createAccount(new Saving(), Currency.USD, bankClient);}
                    else if(Utility.getInt() == 3){ AccountFactory.createAccount(new Saving(), Currency.PLN, bankClient);}
                    else { AccountFactory.createAccount(new Saving(), Currency.UAH, bankClient);}
                    break;
                case 5:
                    System.out.println("Choose currency for Transfer account: 1 - EUR, 2 - USD, 3 - PLN, 4 - UAH");
                    if(Utility.getInt() == 1){AccountFactory.createAccount(new Transfer(), Currency.EUR, bankClient);}
                    else if(Utility.getInt() == 2){ AccountFactory.createAccount(new Transfer(), Currency.USD, bankClient);}
                    else if(Utility.getInt() == 3){ AccountFactory.createAccount(new Transfer(), Currency.PLN, bankClient);}
                    else { AccountFactory.createAccount(new Transfer(), Currency.UAH, bankClient);}
                    break;
                case 6:
                    System.out.println("Enter the Account Number without spaces or symbols to Delete account\n");
                    AccountFactory.deleteAccount(Utility.getInt(), bankClient);
                    break;
                case 7:
                    System.out.println(" ");

                    break;
                case 8:
                    System.out.println(" ");

                    break;
                case 9:
                    System.out.println("For exit press 9");
                    x = false;
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}