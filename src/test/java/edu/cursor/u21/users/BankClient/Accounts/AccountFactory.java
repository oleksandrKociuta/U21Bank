package edu.cursor.u21.users.BankClient.Accounts;

import edu.cursor.u21.users.BankClient.BankClient;
import org.apache.log4j.Logger;
import java.math.BigDecimal;

/**
 * Created by uiv on 2/16/17.
 */
class AccountFactory {
    private static Logger log = Logger.getLogger(AccountFactory.class);

    private AccountFactory(){throw new IllegalStateException();}
    static void createAccount(Account account, Currency currency, BankClient bankClient) throws NullPointerException{
        if (account instanceof Credit) {
            Credit credit = new Credit();
            credit.setCurrency(currency);
            credit.setBalance(BigDecimal.valueOf(0));
            credit.setAccountNumber(00000001);
            bankClient.getAccountHashMap().put(credit.getAccountNumber(), credit);
            log.info("Credit account created for user #"+ bankClient.getId());
        } else if (account instanceof Deposit) {Deposit deposit = new Deposit();
            deposit.setCurrency(currency);
            deposit.setBalance(BigDecimal.valueOf(0));
            deposit.setAccountNumber(00000002);
            bankClient.getAccountHashMap().put(deposit.getAccountNumber(), deposit);
            log.info("Deposit account created for user #"+ bankClient.getId());
        } else if (account instanceof Saving) {Saving saving = new Saving();
            saving.setCurrency(currency);
            saving.setBalance(BigDecimal.valueOf(0));
            saving.setAccountNumber(00000003);
            bankClient.getAccountHashMap().put(saving.getAccountNumber(), saving);
            log.info("Saving account created for user #"+ bankClient.getId());
        } else if (!(bankClient.getAccountHashMap().values() instanceof Transfer)) {
            Transfer transfer = new Transfer();
            transfer.setCurrency(currency);
            transfer.setBalance(BigDecimal.valueOf(0));
            transfer.setAccountNumber(00000004);
            bankClient.getAccountHashMap().put(transfer.getAccountNumber(), transfer);
            log.info("Transfer account created for user #"+ bankClient.getId());
        } else {
            System.out.printf("\nBankClient with ID %s already have transfer account. \n" +
                    "Or something went wrong.", bankClient.getId());
            log.error("Bank Client #" + bankClient.getId() + " tried to create new Transfer Account " +
                    "(only one Transfer Account per Bank Client is allowed)");
        }
    }

    static void deleteAccount(Integer integer, BankClient bankClient) throws NullPointerException{
        bankClient.getAccountHashMap().remove(integer);
        log.info("Account #"+integer+" deleted by user #"+ bankClient.getId() +" with Access Permission: " + bankClient.getRole());
    }
}