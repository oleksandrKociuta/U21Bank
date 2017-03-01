package edu.cursor.u21.users.bankClient.Accounts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by vk on 2/28/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class Account<T,C> implements AccountInterface {
    private String accountNumber;
    private AccountType accountType;
    @Setter(AccessLevel.PRIVATE) private BigDecimal balance = BigDecimal.valueOf(0);
    private StatusOfAccount status = StatusOfAccount.OPEN;
    private Currency currency;
    private LocalDateTime creationDate;
    private LocalDateTime expDate;

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
                "accountNumber='" + accountNumber + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", status=" + status +
                ", currency=" + currency +
                ", creationDate=" + creationDate +
                ", expDate=" + expDate +
                '}';
    }
}