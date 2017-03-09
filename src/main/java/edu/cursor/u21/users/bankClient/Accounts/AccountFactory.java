package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.jdbcConnector.JDBCConnector;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.MagicConstantsInterface;
import edu.cursor.u21.util.Utility;
import edu.cursor.u21.util.UtilityScanner;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
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
        account.setExpDate(account.getCreationDate().plusYears(3));
        account.setBalance(BigDecimal.valueOf(0));
        String sqlQuery = "INSERT INTO  u21bankusers.accounts(" +
                "accountNumber, accountType, balance, status, currency, " +
                "creationDate, expDate, userID) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = new JDBCConnector()
                .getConnection(
                        MagicConstantsInterface.URL,
                        MagicConstantsInterface.USERNAME,
                        MagicConstantsInterface.PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            if (accountType.equals(AccountType.TRANSFER) && checkIfBankClientHasTransferAccount(bankClient.getId())) {
                System.out.println("You already have Transfer Account");
                log.error(accountType + " Transfer Account was not created by " +
                        bankClient.getId() + " because user has one already.");
            } else if (!accountType.equals(AccountType.TRANSFER) ||
                    (accountType.equals(AccountType.TRANSFER) && !checkIfBankClientHasTransferAccount(bankClient.getId()))) {
                try {
                    preparedStatement.setString(1, account.getAccountNumber());
                    preparedStatement.setString(2, account.getAccountType().name());
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
                System.out.printf("Your %s Account  %s successfully created\n", accountType, account.getAccountNumber());
                log.info("New " + accountType + " Account №: " + account.getAccountNumber() + " created by " + bankClient.getId());
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

    void changeAccountStatus(String accountNumber) {
        String sqlForStatus = "UPDATE u21bankusers.accounts " +
                "SET status =? " +
                "WHERE accountNumber= ?";
        System.out.println("Press 0 - to OPEN account, 1 - to CLOSE, 2 - to SUSPEND, 3 - to EXIT");
        int i = UtilityScanner.scanNumberFromZeroToThree();
        if (i == 3) {
            System.out.println("You pressed 0 - to Exit. Have a nice day!");
        } else {
            StatusOfAccount[] accountStatusArray = StatusOfAccount.values();
            String accountStatusName = accountStatusArray[i].toString();

            try (Connection connection = new JDBCConnector().getConnection(
                    MagicConstantsInterface.URL,
                    MagicConstantsInterface.USERNAME,
                    MagicConstantsInterface.PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(sqlForStatus);
            ) {
                statement.setString(1, accountStatusName);
                statement.setString(2, accountNumber);
                int userID = statement.getResultSet().getInt("userID");
                statement.execute();
                System.out.printf("Account %s STATUS is set to %s\n", accountNumber, accountStatusName);
                log.info("User "+userID+" changed Account "+accountNumber+" Status to"+ accountNumber);
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    private boolean checkIfBankClientHasTransferAccount(int userID) {
        String sqlQuery = "Select * from u21bankusers.accounts " +
                        "WHERE userID="+userID+" and accountType="+AccountType.TRANSFER.name();
        boolean typeIs = false;
        try (Connection connection = new JDBCConnector().getConnection(
                MagicConstantsInterface.URL,
                MagicConstantsInterface.USERNAME,
                MagicConstantsInterface.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            typeIs = resultSet.getString("accountType").equals(AccountType.TRANSFER.name());
        } catch (SQLException e) {
            e.getMessage();
        }
        return typeIs;
    }
}