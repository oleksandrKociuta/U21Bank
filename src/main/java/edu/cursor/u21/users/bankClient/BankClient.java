package edu.cursor.u21.users.bankClient;

import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.User;
import edu.cursor.u21.users.bankClient.Accounts.AccountInterface;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"dateOfBirth", "account", "depositAccount", "creditAccount", "transferAccount", "role", "accountHashMap"})
public class BankClient implements User, Serializable {
    Roles role = Roles.USER;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int age;
    private String id;
    private String dateOfBirth;
    private String seriesOfPassport;
    private String telephoneNumber;
    private int account;
    private int depositAccount;
    private int creditAccount;
    private int transferAccount;
    private Map<String, AccountInterface> accountHashMap;

    @Override
    public void startSession(HashMap<String, BankClient> usersList) {
        BankClientMethods.bankClientMenu(usersList);
    }

    public String toString() {
        return getSurname() + " " + getName();
    }
}
