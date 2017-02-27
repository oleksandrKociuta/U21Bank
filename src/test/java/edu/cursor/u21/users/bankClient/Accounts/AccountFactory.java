package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;

import java.math.BigDecimal;

/**
 * Created by uiv on 2/16/17.
 */
class AccountFactory {
    private AccountFactory(){throw new IllegalStateException();}
    static void createAccount(Account account, Currency currency, BankClient bankClient) throws NullPointerException{
        if (account instanceof Credit) {
            Credit credit = new Credit();
            credit.setCurrency(currency);
            credit.setBalance(BigDecimal.valueOf(0));
            credit.setAccountNumber(Utility.getSalt());
            bankClient.getAccountHashMap().put(credit.getAccountNumber(), credit);
        } else if (account instanceof Deposit) {Deposit deposit = new Deposit();
            deposit.setCurrency(currency);
            deposit.setBalance(BigDecimal.valueOf(0));
            deposit.setAccountNumber(Utility.getSalt());
            bankClient.getAccountHashMap().put(deposit.getAccountNumber(), deposit);
        } else if (account instanceof Saving) {Saving saving = new Saving();
            saving.setCurrency(currency);
            saving.setBalance(BigDecimal.valueOf(0));
            saving.setAccountNumber(Utility.getSalt());
            bankClient.getAccountHashMap().put(saving.getAccountNumber(), saving);
        } else if (!(bankClient.getAccountHashMap().values() instanceof Transfer)) {
            Transfer transfer = new Transfer();
            transfer.setCurrency(currency);
            transfer.setBalance(BigDecimal.valueOf(0));
            transfer.setAccountNumber(Utility.getSalt());
            bankClient.getAccountHashMap().put(transfer.getAccountNumber(), transfer);
        } else {
            System.out.printf("\nBankClient2 with ID %s already have transfer account. \n" +
                    "Or something went wrong.", bankClient.getId());
        }
    }

    static void deleteAccount(String accountNumber, BankClient bankClient) throws NullPointerException {
        bankClient.getAccountHashMap().remove(accountNumber);
    }
}