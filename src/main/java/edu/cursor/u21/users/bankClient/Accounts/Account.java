package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by vk on 2/28/17.
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"expDate", "status", "balance", "accountType"})
public class Account implements AccountInterface, Serializable {
    @Id
    @Column(unique = true, nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private AccountType accountType;
    @Column(nullable = false)
    private BigDecimal balance;
    @Column(nullable = false)
    private AccountStatus status;
    @Column(nullable = false)
    private Currency currency;
    @Column(nullable = false)
    private LocalDate creationDate;
    private LocalDate expDate;
    @ManyToOne
    private BankClient userId;

    public Account() {
    }

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