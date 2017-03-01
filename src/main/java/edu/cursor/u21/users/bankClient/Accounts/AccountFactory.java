package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

/**
 * Created by vk on 2/16/17.
 */
class AccountFactory {
    private AccountFactory() {
        throw new IllegalStateException();
    }

    private static Logger log = Logger.getLogger(AccountFactory.class);

    static void createNewAccount(BankClient bankClient, AccountType accountType, Currency currency) {
        Account<AccountType, Currency> account = new Account<>();
        account.setCurrency(currency);
        account.setAccountNumber(Utility.getSalt());
        account.setAccountType(accountType);
        account.setCreationDate(LocalDateTime.now());

            bankClient.getAccountHashMap().values().forEach(ac -> {
                if (ac.getAccountType().equals(AccountType.TRANSFER)) {
                    System.out.println("You already have Transfer Account");
                } else {
                    bankClient.getAccountHashMap().put(account.getAccountNumber(), account);
                    System.out.printf("Your %s Account successfully created", accountType);
                    log.info("New " + accountType + " Account created by " + bankClient.getId());
                }
            });
        }


    static void deleteAccount(BankClient bankClient, String accountNumber) {
        bankClient.getAccountHashMap().remove(accountNumber);
    }
}