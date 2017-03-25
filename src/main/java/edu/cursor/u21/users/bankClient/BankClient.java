package edu.cursor.u21.users.bankClient;

import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.User;
import edu.cursor.u21.users.bankClient.Accounts.Account;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kermit The Frog on 12.02.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"accounts"})
@Entity
@Table(name = "bank_client")
public class BankClient implements User, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "role", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    Roles role = Roles.USER;
    @Column(name = "login", length = 15, nullable = false, unique = true)
    private String login;
    @Column(name = "password", length = 32, nullable = false)
    private String password;
    @Column(name = "name", length = 15, nullable = false)
    private String name;
    @Column(name = "surname", length = 15, nullable = false)
    private String surname;
    @Column(name = "date_of_birth", length = 10, nullable = false)
    private String dateOfBirth;
    @Column(name = "series_of_passport", length = 8, nullable = false, unique = true)
    private String seriesOfPassport;
    @Column(name = "telephone_number", length = 13, nullable = false, unique = true)
    private String telephoneNumber;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();

    @Override
    public void startSession(HashMap<String, BankClient> usersList) {
        BankClientMethods.bankClientMenu(usersList);
    }

    public String toString() {
        return getId() + "\t" + getSurname() + " " + getName();
    }
}
