package edu.cursor.u21.users.BankClient.Accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by uiv on 2/15/17.
 */
@Getter
@Setter
public class Credit implements Account, Serializable {
    private BigDecimal balance;
    private StatusOfAccount status = StatusOfAccount.OPEN;
    private Integer accountNumber;
    private Currency currency;

    public Credit(Currency currency) {
        this.balance  = BigDecimal.valueOf(0);
        this.currency = currency;
    }

    private Credit() {
        throw new IllegalStateException();
    }

    @Override
    public void increaseAccount(BigDecimal bigDecimal) {
        if (!this.status.equals(StatusOfAccount.CLOSED)) {
            this.setBalance(this.balance.add(bigDecimal));
        } else {
            System.out.println("this account is closed");
        }
    }

    @Override
    public void decreaseAccount(Account account, BigDecimal bigDecimal) {

    }

    @Override
    public String toString() {
        return "Credit{" +
                "balance=" + balance +
                ", status=" + status +
                ", accountNumber=" + accountNumber +
                ", currency=" + currency +
                '}';
    }

    @Override
    public Integer getAccountNumber() {
        return null;
    }

//    @Override
//    public Credit createAccount(Currency currency) {
//        return null;
//    }
//
//    @Override
//    public void deleteAccount(Account account) {
//
//    }
}
