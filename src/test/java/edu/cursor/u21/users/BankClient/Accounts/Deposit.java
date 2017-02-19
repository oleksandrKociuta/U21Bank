package edu.cursor.u21.users.BankClient.Accounts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by uiv on 2/15/17.
 */
@Getter
@Setter
public class Deposit implements Account, Serializable{
    private BigDecimal balance;
    private StatusOfAccount status = StatusOfAccount.OPEN;
    private Integer accountNumber;
    private Currency currency;
    private Date creationDate;
    private Date expDate;

    private Deposit(){
        throw new IllegalStateException();
    }

    public Deposit(Currency currency) {
        this.setCurrency(currency);
        this.setAccountNumber(0000000000000000);
        this.setBalance(BigDecimal.valueOf(0));
    }

    public Deposit(BigDecimal balance, Currency currency) {
        this.setCurrency(currency);
        this.setAccountNumber(0000000000000000);
        this.setBalance(balance);
    }


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
        this.balance = this.balance.subtract(bigDecimal);
    }


    @Override
    public String toString() {
        return "Deposit{" +
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
//    public Deposit createAccount(Currency currency) {
//        return new Deposit(this.assignAccountNumber(), currency);
//    }
//
//    @Override
//    public void deleteAccount(Account account) {
//
//    }
}
