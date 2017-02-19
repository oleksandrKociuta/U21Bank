package edu.cursor.u21.users.BankClient.Accounts;

import java.math.BigDecimal;

/**
 * Created by uiv on 2/15/17.
 */
public interface Account {
    void increaseAccount(BigDecimal bigDecimal);
    void decreaseAccount(Account account, BigDecimal bigDecimal);
    BigDecimal getBalance() ;
    void setBalance(BigDecimal balance);
    Integer getAccountNumber();
//    Account createAccount(Currency currency);
//    void deleteAccount(Account account);

}