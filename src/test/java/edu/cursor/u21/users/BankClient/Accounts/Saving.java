package edu.cursor.u21.users.BankClient.Accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by uiv on 2/15/17.
 */
@Getter
@Setter
public class Saving implements Account, Serializable{
    private BigDecimal balance;
    private StatusOfAccount status = StatusOfAccount.OPEN;
    private Integer accountNumber;
    private Currency currency;
    private LocalDateTime creationDate;
    private LocalDateTime expDate;

    public Saving(BigDecimal bigDecimal, Currency currency) {
        this.balance = bigDecimal;
        this.currency = currency;
        this.creationDate =  LocalDateTime.now(
        );
    }

    @Override
    public void increaseAccount(BigDecimal bigDecimal) {

    }

    @Override
    public void decreaseAccount(Account account, BigDecimal bigDecimal) {

    }

    @Override
    public void setBalance(BigDecimal balance) {

    }

    @Override
    public Integer getAccountNumber() {
        return null;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "balance=" + balance +
                ", status=" + status +
                ", accountNumber=" + accountNumber +
                ", currency=" + currency +
                ", creationDate=" + creationDate +
                ", expDate=" + expDate +
                '}';
    }
//
//    @Override
//    public Saving createAccount(Currency currency) {
//        return null;
//    }
//
//    @Override
//    public void deleteAccount(Account account) {
//
//    }
}
