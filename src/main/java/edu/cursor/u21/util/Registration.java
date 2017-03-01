package edu.cursor.u21.util;


import edu.cursor.u21.users.bankClient.BankClient;

import java.util.Map;
import java.util.UUID;

import static edu.cursor.u21.util.Utility.getStringForPassword;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration {
//    private static Logger log = Logger.getLogger(Registration.class);

    public void registration() {
        Map<String, BankClient> list = WriteAndRead.readBankFile();
        BankClient bankClient = new BankClient();
        bankClient.setId(UUID.randomUUID().toString());
        System.out.print("\nEnter your login - > ");
        bankClient.setLogin(Utility.loginCheck());
        System.out.print("Enter your password - > ");
        bankClient.setPassword(Utility.getPassword(getStringForPassword()));
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
        list.put(bankClient.getLogin(), bankClient);
        WriteAndRead.writeBankFile(list);
    }
}