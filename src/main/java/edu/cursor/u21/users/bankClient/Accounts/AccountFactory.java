package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.jdbcConnector.JDBCConnector;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.MagicConstantsInterface;
import edu.cursor.u21.util.Utility;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by vk on 2/16/17.
 */
@NoArgsConstructor
class AccountFactory {
    private Logger log = Logger.getLogger(AccountFactory.class);

    public static void main(String[] args) throws SQLException {
        new AccountFactory().getNewAccount(
                new BankClient(),
                AccountType.TRANSFER,
                Currency.UAH,
                new JDBCConnector()
                        .getConnection(
                                MagicConstantsInterface.URL,
                                MagicConstantsInterface.USERNAME,
                                MagicConstantsInterface.PASSWORD)
        );
    }

    Account getNewAccount(BankClient bankClient, AccountType accountType, Currency currency, Connection connection) {
        Account account = new Account();
        account.setCurrency(currency);
        account.setAccountNumber(Utility.getSalt());
        account.setAccountType(accountType);
        account.setStatus(StatusOfAccount.OPEN);
        account.setCreationDate(LocalDate.now());
        account.setExpDate(account.getCreationDate().plusYears(3));
        account.setBalance(BigDecimal.valueOf(0));
        PreparedStatement prepareInsert = null;
        String sqlQuery = "INSERT INTO  u21bankusers.accounts(" +
                "accountNumber, accountType, balance, status, currency, " +
                "creationDate, expDate, userID) VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ) {

            if (accountType.equals(AccountType.TRANSFER) && checkIfBankClientHasTransferAccount(bankClient)) {
                System.out.println("You already have Transfer Account");
                log.error(accountType + " Transfer Account was not created by " + bankClient.getId() + " because user has one already.");
            } else if (!accountType.equals(AccountType.TRANSFER) ||
                    (accountType.equals(AccountType.TRANSFER) && !checkIfBankClientHasTransferAccount(bankClient))) {
                try {
                    preparedStatement.setString(1, account.getAccountNumber());
                    preparedStatement.setString(2, account.getAccountType().getValue());
                    preparedStatement.setString(3, account.getBalance().toString());
                    preparedStatement.setString(4, account.getStatus().name());
                    preparedStatement.setString(5, account.getCurrency().name());
                    preparedStatement.setDate(6, Date.valueOf(account.getCreationDate()));
                    preparedStatement.setDate(7, Date.valueOf(account.getExpDate()));
                    preparedStatement.setString(8, String.valueOf(bankClient.getId()));
                    preparedStatement.execute();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                System.out.printf("Your %s Account # %s successfully created\n", accountType, account.getAccountNumber());
                log.info("New " + accountType + " Account created by " + bankClient.getId());
            } else {
                System.out.println("Can't create new account. Something went wrong.");
                log.info("User %s cannot create new account" + bankClient.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return account;
    }

    void closeAccount(String accountNumber) {
//        if () {
//            System.out.printf("Your Account %s successfully deleted\n", accountNumber);
//            log.info("Account " + accountNumber + " deleted by ");
//        } else {
//            System.out.printf("There is no Account #%s\n", accountNumber);
//        }
    }

    private boolean checkIfBankClientHasTransferAccount(BankClient bankClient) {
        return bankClient.getAccountList().stream().anyMatch(a ->
                (a.getAccountType()).equals(AccountType.TRANSFER));
    }
}