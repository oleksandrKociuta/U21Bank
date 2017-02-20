package edu.cursor.u21.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
@Getter
@Setter
@NoArgsConstructor
public class BankClient implements User, Serializable {
    private String login;
    private String password;
    private String name;
    private String surname;
    private int age;
    private String id;
    private String DateOfBirth;
    private String SeriesOfPassport;
    private int telephoneNumber;
    private int account;
    private int depositAccount;
    private int creditAccount;
    private int transferAccount;

    public void startSession() {
        BankClientMethods.bankClientMenu();
    }
}
