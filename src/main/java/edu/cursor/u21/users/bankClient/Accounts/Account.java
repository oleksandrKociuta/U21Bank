package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by vk on 2/28/17.
 */
@EqualsAndHashCode(exclude = "client")
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account implements AccountInterface, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type", length = 10)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "status", length = 10)
    @Enumerated(EnumType.STRING)
    private AccountType status;
    @Column(name = "currency", length = 3)
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "creation_date", length = 10)
    private LocalDate creationDate;
    @Column(name = "expiration_date", length = 10)
    private LocalDate expDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private BankClient client;

    @Override
    public String toString() {
        return "Account{" +
                "\n accountType = " + accountType +
                ",\n accountNumber = '" + accountNumber + '\'' +
                ",\n balance = " + balance +
                ",\n status = " + status +
                ",\n currency = " + currency +
                ",\n creationDate = " + creationDate +
                ",\n expDate = " + expDate +
                '}';
    }
}