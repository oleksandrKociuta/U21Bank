package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.dao.SessionFactory;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;
import edu.cursor.u21.util.UtilityScanner;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by vk on 2/16/17.
 */
@NoArgsConstructor
class AccountFactory {
    private Logger log = Logger.getLogger(AccountFactory.class);

    Account getNewAccount(BankClient bankClient, AccountType accountType, Currency currency) {
        Session session = SessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Account account = new Account();
        account.setCurrency(currency);
        account.setAccountNumber(Utility.getSalt());
        account.setAccountType(accountType);
        account.setStatus(AccountStatus.OPEN);
        account.setCreationDate(LocalDate.now());
        account.setExpDate(account.getCreationDate().plusYears(3));
        account.setBalance(BigDecimal.valueOf(0));

        if (accountType.equals(AccountType.TRANSFER) && checkIfBankClientHasTransferAccount(bankClient.getId())) {
            System.out.println("You already have Transfer Account");
            log.error(accountType + " Transfer Account was not created by " +
                    bankClient.getId() + " because user has one already.");
        } else if (!accountType.equals(AccountType.TRANSFER) ||
                (accountType.equals(AccountType.TRANSFER) &&
                        !checkIfBankClientHasTransferAccount(bankClient.getId()))) {
            transaction.commit();
            SessionFactory.closeSession();
            System.out.printf("Your %s Account  %s successfully created\n", accountType, account.getAccountNumber());
            log.info("New " + accountType + " Account №: " + account.getAccountNumber() + " created by " + bankClient.getId());
        } else {
            System.out.println("Can't create new account. Something went wrong.");
            log.info("User %s cannot create new account" + bankClient.getId());
        }

        return account;
    }

    void changeAccountStatus(int userID, String accountNumber) {
        String sqlForStatus = "UPDATE u21bankusers.accounts " +
                "SET status =? " +
                "WHERE accountNumber= ?" +
                "AND userID= ?";
        System.out.println("Press 0 - to OPEN account, 1 - to CLOSE, 2 - to SUSPEND, 3 - to EXIT");
        int i = UtilityScanner.scanNumberFromZeroToThree();
        if (i == 3) {
            System.out.println("You pressed 0 - to Exit. Have a nice day!");
        } else {
            AccountStatus[] accountStatusArray = AccountStatus.values();
            String accountStatusName = accountStatusArray[i].toString();

            System.out.printf("Account %s STATUS is set to %s\n", accountNumber, accountStatusName);
            log.info("User " + userID + " changed Account " + accountNumber + " Status to" + accountNumber);
        }
    }

    private boolean checkIfBankClientHasTransferAccount(int userID) {
        Session session = SessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        BankClient dbBankClient = (BankClient) session.get(BankClient.class, userID);
        transaction.commit();
        SessionFactory.closeSession();
        return dbBankClient.getAccountList().stream()
                .anyMatch(account -> account.getAccountType().equals(AccountType.TRANSFER));
    }

    private void increaseAccountBalance(Account account, BigDecimal bigDecimal) {
        Session session = SessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Account dbAccount = (Account) session.get(Account.class, account.getAccountNumber());
        AccountStatus accountStatus = dbAccount.getStatus();

        if (!(accountStatus.equals(AccountStatus.CLOSED) ||
                accountStatus.equals(AccountStatus.SUSPENDED))) {
            dbAccount.setBalance(dbAccount.getBalance().add(bigDecimal));
        } else {
            System.out.println("You cannot increase balance, this account is closed or suspended. Call the police.");
        }
        session.flush();
        transaction.commit();
        SessionFactory.closeSession();
    }

    private void decreaseAccountBalance(Account account, BigDecimal bigDecimal) {
        Session session = SessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Account dbAccount = (Account) session.get(Account.class, account.getAccountNumber());
        AccountStatus accountStatus = dbAccount.getStatus();

        if (!(accountStatus.equals(AccountStatus.CLOSED) ||
                accountStatus.equals(AccountStatus.SUSPENDED))) {
            dbAccount.setBalance(dbAccount.getBalance().subtract(bigDecimal));
        } else {
            System.out.println("You cannot withdraw, because this account is closed");
        }
    }
}