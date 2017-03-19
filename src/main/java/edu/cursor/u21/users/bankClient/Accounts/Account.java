package edu.cursor.u21.users.bankClient.Accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by vk on 2/28/17.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account implements AccountInterface {

    private String accountNumber;
    private AccountType accountType;
    private BigDecimal balance;
    private StatusOfAccount status;
    private Currency currency;
    private LocalDate creationDate;
    private LocalDate expDate;

    @Override
    public void increaseBalance(BigDecimal bigDecimal) {
        if (!this.status.equals(StatusOfAccount.CLOSED)) {
            this.setBalance(this.balance.add(bigDecimal));
        } else {
            System.out.println("You cannot increase, this account is closed");
        }
    }

    @Override
    public void decreaseBalance(BigDecimal bigDecimal) {
        if (!this.status.equals(StatusOfAccount.CLOSED)) {
            this.setBalance(this.balance.subtract(bigDecimal));
        } else {
            System.out.println("You cannot withdraw, because this account is closed");
        }
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