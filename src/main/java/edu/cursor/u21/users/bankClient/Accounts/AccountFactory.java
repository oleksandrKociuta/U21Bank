package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by vk on 2/16/17.
 */
@NoArgsConstructor
class AccountFactory {
    private Logger log = Logger.getLogger(AccountFactory.class);

    Account getNewAccount(BankClient bankClient, AccountType accountType, Currency currency) {
        Account account = new Account();
        account.setCurrency(currency);
        account.setAccountNumber(Utility.getSalt());
        account.setAccountType(accountType);
        account.setStatus(StatusOfAccount.OPEN);
        account.setCreationDate(LocalDate.now());
        account.setBalance(BigDecimal.valueOf(0));
        account.setExpDate(LocalDate.ofEpochDay(20 - 2 - 2020));

        if (accountType.equals(AccountType.TRANSFER) && checkIfBankClientHasTransferAccount(bankClient)) {
            System.out.println("You already have Transfer Account");
            log.error(accountType + " Transfer Account was not created by " + bankClient.getId() + " because user has one already.");
        } else if (!accountType.equals(AccountType.TRANSFER) ||
                (accountType.equals(AccountType.TRANSFER) && !checkIfBankClientHasTransferAccount(bankClient))) {
            bankClient.getAccountHashMap().put(account.getAccountNumber(), account);
            System.out.printf("Your %s Account # %s successfully created\n", accountType, account.getAccountNumber());
            log.info("New " + accountType + " Account created by " + bankClient.getId());
        } else {
            System.out.println("Can't create new account. Something went wrong.");
            log.info("User %s cannot create new account" + bankClient.getId());
        }
        return account;
    }

    void deleteAccount(BankClient bankClient, String accountNumber) {
        if (bankClient.getAccountHashMap().containsKey(accountNumber)) {
            bankClient.getAccountHashMap().remove(accountNumber);
            System.out.printf("Your Account %s successfully deleted\n", accountNumber);
            log.info("Account " + accountNumber + " deleted by " + bankClient.getId());
        } else {
            System.out.printf("There is no Account #%s\n", accountNumber);
        }
    }

    private boolean checkIfBankClientHasTransferAccount(BankClient bankClient) {
        return bankClient.getAccountHashMap().values().stream().anyMatch(a ->
                (a.getAccountType()).equals(AccountType.TRANSFER));
    }
}