package edu.cursor.u21.users.BankClient.Accounts;

import edu.cursor.u21.users.BankClient.BankClient;

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
            credit.setAccountNumber(00000001);
            bankClient.getAccountHashMap().put(credit.getAccountNumber(), credit);
        } else if (account instanceof Deposit) {Deposit deposit = new Deposit();
            deposit.setCurrency(currency);
            deposit.setBalance(BigDecimal.valueOf(0));
            deposit.setAccountNumber(00000002);
            bankClient.getAccountHashMap().put(deposit.getAccountNumber(), deposit);
        } else if (account instanceof Saving) {Saving saving = new Saving();
            saving.setCurrency(currency);
            saving.setBalance(BigDecimal.valueOf(0));
            saving.setAccountNumber(00000003);
            bankClient.getAccountHashMap().put(saving.getAccountNumber(), saving);
        } else if (!(bankClient.getAccountHashMap().values() instanceof Transfer)) {
            Transfer transfer = new Transfer();
            transfer.setCurrency(currency);
            transfer.setBalance(BigDecimal.valueOf(0));
            transfer.setAccountNumber(00000004);
            bankClient.getAccountHashMap().put(transfer.getAccountNumber(), transfer);
        } else {
            System.out.printf("\nBankClient with ID %s already have transfer account. \n" +
                    "Or something went wrong.", bankClient.getId());
        }
    }

    static void deleteAccount(Integer integer, BankClient bankClient) throws NullPointerException{
        bankClient.getAccountHashMap().remove(integer);
    }
}