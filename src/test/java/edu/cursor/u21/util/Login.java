package edu.cursor.u21.util;

import edu.cursor.u21.users.bankClient.BankClient;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by alexandrmanikhin on 13.02.17.
 */
@NoArgsConstructor
public class Login {
    public BankClient logIn() {
        Map<String, BankClient> list = WriteAndRead.readBankFile();
        while (true) {
            System.out.print("\nEnter Login - > ");
            String login = UtilityScanner.sc.nextLine();
            System.out.print("Enter password -> ");
            String password = Utility.getPassword();
            if (list.values().stream().anyMatch(e -> e.getLogin().equals(login)&& e.getPassword().equals(password))) {
                return list.get(login);
            }
            System.out.println("Repeat !! Wrong Input !");
        }
    }
}