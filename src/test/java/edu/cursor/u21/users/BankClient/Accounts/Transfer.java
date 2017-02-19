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
public class Transfer implements Account, Serializable {
    private BigDecimal balance;
    private StatusOfAccount status = StatusOfAccount.OPEN;
    private Integer accountNumber;
    private Currency currency;
    private Date creationDate;
    private Date expDate;

    public Transfer(Currency currency) {
        this.currency = currency;
    }

    Transfer(BigDecimal bigDecimal, Currency currency) {

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
}
