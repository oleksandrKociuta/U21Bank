package edu.cursor.u21.users.BankClient;

import edu.cursor.u21.users.BankClient.Accounts.Account;
import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
@Getter
@Setter
//@NoArgsConstructor
public class BankClient implements User, Serializable {
    private String id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int age;
    private String DateOfBirth;
    private String SeriesOfPassport;
    private int telephoneNumber;
    private HashMap<String, Account> accountHashMap;
    Roles role = Roles.USER;

    public BankClient(String id, String login, String password, String name, String surname, int age, String dateOfBirth, String seriesOfPassport, int telephoneNumber) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        DateOfBirth = dateOfBirth;
        SeriesOfPassport = seriesOfPassport;
        this.telephoneNumber = telephoneNumber;
        this.accountHashMap = new HashMap<>();
        this.role = Roles.USER;
    }

    @Override
    public void startSession(HashMap<String,BankClient> usersList) {
        BankClientMethods.bankClientMenu(usersList);
    }
}