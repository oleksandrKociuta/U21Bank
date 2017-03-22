package edu.cursor.u21.users.bankClient;

import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.User;
import edu.cursor.u21.users.bankClient.Accounts.Account;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
@Getter
@Setter
@Entity
@RequestMapping("/registration")
@EqualsAndHashCode(exclude = {"dateOfBirth", "name", "surname"})
public class BankClient implements User, Serializable {
    Roles role = Roles.USER;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String dateOfBirth;
    @Column(unique = true, nullable = false)
    private String seriesOfPassport;
    @Column(unique = true, nullable = false)
    private String telephoneNumber;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<Account> accountList;

    public BankClient() {
    }

    @Override
    public void startSession(HashMap<String, BankClient> usersList) {
        BankClientMethods.bankClientMenu(usersList);
    }

    public String toString() {
        return getId() + "\t" + getSurname() + " " + getName();
    }
}
