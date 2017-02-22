package edu.cursor.u21.users.bankClient.Accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by uiv on 2/15/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class Credit implements Account, Serializable {
    private Integer accountNumber;
    private BigDecimal balance;
    private StatusOfAccount status = StatusOfAccount.OPEN;
    private Currency currency;
    private LocalDateTime creationDate;
    private LocalDateTime expDate;

    @Override
    public void increaseAccount(BigDecimal bigDecimal) {
        if (!this.status.equals(StatusOfAccount.CLOSED)){
            this.setBalance(this.balance.add(bigDecimal));
        }
        else {
            System.out.println("this account is closed");
        }
    }

    @Override
    public void decreaseAccount(Account account, BigDecimal bigDecimal) {
        if (!this.status.equals(StatusOfAccount.CLOSED)){
            this.setBalance(this.balance.subtract(bigDecimal));
        }
        else {
            System.out.println("this account is closed");
        }
    }

    @Override
    public String toString() {
        return "Credit{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", status=" + status +
                ", currency=" + currency +
                ", creationDate=" + creationDate +
                ", expDate=" + expDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(getAccountNumber(), credit.getAccountNumber()) &&
                getCurrency() == credit.getCurrency();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getCurrency());
    }
}
