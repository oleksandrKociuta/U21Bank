package edu.cursor.u21.util;

import edu.cursor.u21.jdbcConnector.JDBCConnector;
import edu.cursor.u21.users.bankClient.BankClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static edu.cursor.u21.util.MagicConstantsInterface.PASSWORD;
import static edu.cursor.u21.util.MagicConstantsInterface.URL;
import static edu.cursor.u21.util.MagicConstantsInterface.USERNAME;
import static edu.cursor.u21.util.Utility.*;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration {
//    private static Logger log = Logger.getLogger(Registration.class);

    public void registration() {
        JDBCConnector driver;
        Connection connection = null;
        PreparedStatement prepareInsert = null;
        BankClient bankClient = new BankClient();
        String insert = "INSERT INTO  u21bankusers" +
                ".users(Role, Login, Password, Name, Surname, " +
                "`Date of birth`, `Series of passport`,`Telephone number`)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        try {
            driver = new JDBCConnector();
            connection = driver.getConnection(URL, USERNAME, PASSWORD);
            prepareInsert = connection.prepareStatement(insert);
        } catch (SQLException e) {
            System.out.println("Can't create connection !!");
            e.printStackTrace();
        }

        while (true) {
            System.out.print("Enter User Login - > ");
            bankClient.setLogin(loginCheck());
            System.out.print("Enter User Password - > ");
            bankClient.setPassword(getStringForPassword());
            System.out.print("Enter User Name - > ");
            bankClient.setName(nameAndSurnameCheck());
            System.out.print("Enter Surname - > ");
            bankClient.setSurname(nameAndSurnameCheck());
            System.out.print("Enter Date - > ");
            bankClient.setDateOfBirth(dateCheck());
            System.out.print("Enter Series of  Passport - > ");
            bankClient.setSeriesOfPassport(passportCheck());
            System.out.print("Enter Telephone number - > ");
            bankClient.setTelephoneNumber(telephoneNumberCheck());

            try {
                assert prepareInsert != null;
                prepareInsert.setString(1, bankClient.getRole().name());
                prepareInsert.setString(2, bankClient.getLogin());
                prepareInsert.setString(3, bankClient.getPassword());
                prepareInsert.setString(4, bankClient.getName());
                prepareInsert.setString(5, bankClient.getSurname());
                prepareInsert.setString(6, bankClient.getDateOfBirth());
                prepareInsert.setString(7, bankClient.getSeriesOfPassport());
                prepareInsert.setString(8, bankClient.getTelephoneNumber());
                prepareInsert.execute();
                break;
            } catch (SQLException e) {
                System.out.println("Login, Series of Passport or Telephone number are already used ! Repeat!");
                exitProgram(connection, prepareInsert);
            }
        }
        try {
            prepareInsert.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}