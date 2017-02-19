package edu.cursor.u21.users.BankClient.Accounts;

import edu.cursor.u21.util.Utility;
import edu.cursor.u21.users.BankClient.BankClient;

import java.math.BigDecimal;

/**
 * Created by uiv on 2/16/17.
 */
public class AccountFactory {
    public static void createAccount(Account account, Currency currency, BigDecimal balance, BankClient bankClient) {
        if (account instanceof Credit) {
            bankClient.getAccountHashMap().put(Utility.getSalt(), new Credit(currency));
        } else if (account instanceof Deposit) {
            bankClient.getAccountHashMap().put(Utility.getSalt(), new Deposit(balance, currency));
        } else if (account instanceof Saving) {
            bankClient.getAccountHashMap().put(Utility.getSalt(), new Saving(balance, currency));
        } else if (!(bankClient.getAccountHashMap().values() instanceof Transfer)) {
            bankClient.getAccountHashMap().put(Utility.getSalt(), new Transfer(balance, currency));
        } else {
            System.out.printf("\nBankClient with ID %s already have transfer account. \n" +
                    "Or something went wrong.", bankClient.getId());
        }
    }

    public static void deleteAccount(Account account, BankClient bankClient){
        bankClient.getAccountHashMap().values().remove(account);
    }
}