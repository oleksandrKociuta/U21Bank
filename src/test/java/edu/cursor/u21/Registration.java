package edu.cursor.u21;

import edu.cursor.u21.users.BankClient;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration {
    public static Logger log = Logger.getLogger(Registration.class);
    public static void registration() {
        BankClient bankClient = new BankClient();
        while (true) {
            System.out.print("Enter your login - > ");
            bankClient.setLogin(Utility.sc.nextLine());
            if (Utility.checkForUniqueness(bankClient.getLogin())) {
                System.out.println("login in already use!!!");
                continue;
            }
            System.out.print("Enter your password - > ");
            bankClient.setPassword(Utility.getPassword());
            System.out.print("Enter your name - > ");
            bankClient.setName(Utility.sc.nextLine());
            System.out.print("Enter your surname - > ");
            bankClient.setSurname(Utility.sc.nextLine());
            System.out.print("Enter your age - > ");
            bankClient.setAge(Utility.getInt());
            if (bankClient.getAge() < 18) {
                System.out.println("User must be adulthood. Upper 17 years old !!!");
                continue;
            }
            System.out.print("Enter your Date Of Birth - > ");
            bankClient.setDateOfBirth(Utility.sc.nextLine());
            System.out.print("Enter your SeriesOfPassport - > ");
            bankClient.setSeriesOfPassport(Utility.sc.nextLine());
            System.out.print("Enter your Telephone Number - > ");
            bankClient.setTelephoneNumber(Utility.getInt());
            break;
        }
        try (FileOutputStream fileOutput = new FileOutputStream(bankClient.getLogin() + Utility.fileFormat)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(bankClient);
            objectOutput.close();
            log.info("register user: "+bankClient.getLogin());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }
}

