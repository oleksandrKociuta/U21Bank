package edu.cursor.u21.util;

import edu.cursor.u21.users.BankClient.BankClient;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration {
    private static Logger log = Logger.getLogger(Registration.class);

    public static void registration() {
        BankClient bankClient = new BankClient();
        System.out.print("Enter your login - > ");
        bankClient.setLogin(Utility.loginCheck());
        System.out.print("Enter your password - > ");
        bankClient.setPassword(Utility.getPassword());
        System.out.print("Enter your name - > ");
        bankClient.setName(Utility.sc.nextLine());
        System.out.print("Enter your surname - > ");
        bankClient.setSurname(Utility.sc.nextLine());
        System.out.print("Enter your age - > ");
        bankClient.setAge(Utility.ageCheck());
        System.out.print("Enter your Date Of Birth  Example : [ 13-02-2017] - > ");
        bankClient.setDateOfBirth(Utility.dateCheck());
        System.out.print("Enter your SeriesOfPassport - > ");
        bankClient.setSeriesOfPassport(Utility.passportCheck());
        System.out.print("Enter your Telephone Number +38.. - > ");
        bankClient.setTelephoneNumber(Utility.telephoneNumberCheck());
        try (FileOutputStream fileOutput = new FileOutputStream(bankClient.getLogin() + Utility.fileFormat)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(bankClient);
            objectOutput.close();
            log.info("register user: " + bankClient.getLogin());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }
}

