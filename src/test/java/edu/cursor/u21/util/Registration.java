package edu.cursor.u21.util;

<<<<<<< HEAD
import edu.cursor.u21.users.BankClient.BankClient;
import org.apache.log4j.Logger;
=======
import edu.cursor.u21.users.BankClient;
>>>>>>> Development

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration {
//    private static Logger log = Logger.getLogger(Registration.class);

    public static void registration() {
        BankClient bankClient = new BankClient();
        bankClient.setId(UUID.randomUUID().toString());

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
    }


    public void CreateFile() throws IOException {
        File file = new File("Users.md");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public Map<String, BankClient> writeToMap(BankClient bankClient) {
        Map<String, BankClient> hashMap = new HashMap <String, BankClient>();
        hashMap.put(bankClient.getId(),bankClient);
        return hashMap;
    }
    public void LoadFile(Map<String,Object> hashMap) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Users.md"))) {
            objectOutputStream.writeObject(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}