package edu.cursor.u21.util;

import edu.cursor.u21.jdbcConnector.JDBCConnector;
import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.bankClient.BankClient;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.cursor.u21.util.MagicConstantsInterface.*;
import static edu.cursor.u21.util.Utility.exitProgram;

;


/**
 * Created by alexandrmanikhin on 13.02.17.
 */
@NoArgsConstructor
public class Login {

    public BankClient logIn() throws SQLException {
        String query = "SELECT * FROM u21bankusers.users";
        JDBCConnector driver = new JDBCConnector();
        Connection connection = driver.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        BankClient bankClient = null;
        List<BankClient> bankClientList = new ArrayList<>();
        while (resultSet.next()) {
            bankClient = new BankClient();
            bankClient.setId(resultSet.getInt("id"));
            if (resultSet.getString("Role").equals(Roles.USER.name())) {
                bankClient.setRole(Roles.USER);
            } else {
                bankClient.setRole(Roles.ADMIN);
            }
            bankClient.setLogin(resultSet.getString("Login"));
            bankClient.setPassword(resultSet.getString("Password"));
            bankClient.setName(resultSet.getString("Name"));
            bankClient.setSurname(resultSet.getString("Surname"));
            bankClient.setDateOfBirth(resultSet.getString("Date of birth"));
            bankClient.setSeriesOfPassport(resultSet.getString("Series of passport"));
            bankClient.setTelephoneNumber(resultSet.getString("Telephone number"));
            bankClientList.add(bankClient);
        }
        while (true) {
            System.out.print("Enter Your Login - > ");
            String login = Utility.loginCheck();
            System.out.print("Enter Your Password - > ");
            String password = Utility.getStringForPassword();
            BankClient currentBankClient = bankClientList.stream()
                    .filter(e -> e.getLogin().equals(login) && e.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);
            if (currentBankClient != null) {
                resultSet.close();
                statement.close();
                connection.close();
                return currentBankClient;
            }

            System.out.println("You entered wrong Login or Password ! ");
            exitProgram(connection, statement, resultSet);
        }

    }
}