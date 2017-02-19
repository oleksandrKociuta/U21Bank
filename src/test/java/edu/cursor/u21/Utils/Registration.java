package edu.cursor.u21.Utils;

import edu.cursor.u21.users.BankClient.BankClient;
import org.apache.log4j.Logger;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration implements MagicConstantsInterface{
    public static Logger log = Logger.getLogger(Registration.class);
    public static void registration() {
        BankClient account = new BankClient();
        while (true) {
            System.out.print("Enter your login - > ");
            account.setLogin(Utility.sc.nextLine());
            if (Utility.checkForUniqueness(account.getLogin())) {
                System.out.println("login in already use!!!");
                continue;
            }
            System.out.print("Enter your password - > ");
            account.setPassword(Utility.getPassword());
            System.out.print("Enter your name - > ");
            account.setName(Utility.sc.nextLine());
            System.out.print("Enter your surname - > ");
            account.setSurname(Utility.sc.nextLine());
            System.out.print("Enter your age - > ");
            account.setAge(Utility.getInt());
            if (account.getAge() < 18) {
                System.out.println("User must be adulthood. Upper 17 years old !!!");
                continue;
            }
            System.out.print("Enter your Date Of Birth - > ");
            account.setDateOfBirth(Utility.sc.nextLine());
            System.out.print("Enter your SeriesOfPassport - > ");
            account.setSeriesOfPassport(Utility.sc.nextLine());
            System.out.print("Enter your Telephone Number - > ");
            account.setTelephoneNumber(Utility.getInt());
            break;
        }

//        ArrayList<User> usersList = (ArrayList<User>) Read.readFile(usersFilePath);
//        usersList.add(bankClient);
//        Write.writeFile(usersList);
//        System.out.println("Your personal info is added to BankSystem");

//        try (FileOutputStream fileOutput = new FileOutputStream(bankClient.getLogin() + Utility.fileFormat)) {
//            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
//            objectOutput.writeObject(bankClient);
//            objectOutput.close();
//            log.info("register user: "+bankClient.getLogin());
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//        }
    }
}