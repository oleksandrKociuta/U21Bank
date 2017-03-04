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
@EqualsAndHashCode(exclude = {"dateOfBirth", "id", "accountHashMap"})
public class BankClient implements User, Serializable {
    Roles role = Roles.USER;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int id;
    private String dateOfBirth;
    private String seriesOfPassport;
    private String telephoneNumber;
    private Map<String, AccountInterface> accountHashMap = new HashMap<>();

    @Override
    public void startSession(HashMap<String, BankClient> usersList) {
        BankClientMethods.bankClientMenu(usersList);
    }

    public String toString() {
        return getSurname() + " " + getName();
    }
}
