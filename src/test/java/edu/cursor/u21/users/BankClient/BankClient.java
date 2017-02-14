package edu.cursor.u21.users.BankClient;

import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
@Getter
@Setter
@NoArgsConstructor
public class BankClient implements User, Serializable, Comparable<BankClient> {
    private String id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int age;
    private String DateOfBirth;
    private String SeriesOfPassport;
    private int telephoneNumber;
    Roles role = Roles.USER;
    public void startSession(ArrayList arrayList) {
        BankClientMethods.bankClientMenu(arrayList);
    }

    @Override
    public int compareTo(BankClient o) {
        return surname.compareTo(o.surname);
    }

    @Override
    public void startSession(HashMap usersList) {

    }
}
