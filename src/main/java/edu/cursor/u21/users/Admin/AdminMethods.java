package edu.cursor.u21.users.Admin;

import edu.cursor.u21.jdbcConnector.JDBCConnector;
import edu.cursor.u21.users.bankClient.Accounts.Currency;
import edu.cursor.u21.util.MagicConstantsInterface;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

@NoArgsConstructor
public class AdminMethods implements AdminInterface {

      public void displayListOfUsers() {
        String sqlQuery = "Select * from users";
        try (Connection connection = new JDBCConnector().getConnection(
                MagicConstantsInterface.URL,
                MagicConstantsInterface.USERNAME,
                MagicConstantsInterface.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery);) {
            System.out.println("ID\t\tName\t\t\tSurname\t\tPhone ");
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("telephone number");
                System.out.printf("%d\t\t%s\t\t\t%s\t\t%s \n", ID, name, surname, phone);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void displayAllUsersAccounts() {
        String sql = "SELECT * FROM u21bankusers.accounts";
        iterateAccounts(sql);
    }

    public void displayUserAccounts(int userId) {
        String sqlQuery = String.format("SELECT * FROM u21bankusers.accounts WHERE userID =%d", userId);
        iterateAccounts(sqlQuery);
    }

    private void iterateAccounts(String sqlQuery) {
        try (Connection connection = new JDBCConnector().getConnection(
                MagicConstantsInterface.URL,
                MagicConstantsInterface.USERNAME,
                MagicConstantsInterface.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            System.out.println("userID\t\tAccountNumber\t\taccountType\t\t\tBalance\t\tStatus\t\tCurrency\t\tCreationDate\t\tExpDate\n ");
            while (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                String accountNumber = resultSet.getString("accountNumber");
                String accountType = resultSet.getString("accountType");
                String balance = resultSet.getString("balance");
                String status = resultSet.getString("status");
                Currency currency = Currency.valueOf(resultSet.getString("currency"));
                LocalDate creationDate = LocalDate.parse(resultSet.getString("creationDate"));
                LocalDate expDate = LocalDate.parse(resultSet.getString("expDate"));
                System.out.printf("%d\t\t\t%s\t\t\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n ",
                        userID, accountNumber, accountType, balance, status, currency, creationDate, expDate);
            }
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}