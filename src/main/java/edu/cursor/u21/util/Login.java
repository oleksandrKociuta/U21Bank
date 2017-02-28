package edu.cursor.u21.util;

import edu.cursor.u21.users.Admin.AdminMenu;
import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.bankClient.Accounts.AccountMenu;
import edu.cursor.u21.users.bankClient.BankClient;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static edu.cursor.u21.util.Utility.getStringForPassword;

/**
 * Created by alexandrmanikhin on 13.02.17.
 */
@NoArgsConstructor
public class Login {
    @Getter
    private  Map<String, BankClient> list;

    public BankClient logIn() {
        list = WriteAndRead.readBankFile();
        while (true) {
            System.out.print("\nEnter Login - > ");
            String login = UtilityScanner.sc.nextLine();
            System.out.print("Enter password -> ");
            String password = Utility.getPassword(getStringForPassword());
            if (list.values().stream().anyMatch(e -> e.getLogin().equals(login) && e.getPassword().equals(password))) {
                return list.get(login);
            }
            System.out.println("Repeat !! Wrong Input !");
        }
    }
}