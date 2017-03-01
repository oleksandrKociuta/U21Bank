package edu.cursor.u21.users.bankClient.Accounts;

import java.math.BigDecimal;

/**
 * Created by uiv on 2/15/17.
 */
public interface AccountInterface {
    void increaseBalance(BigDecimal bigDecimal);

    void decreaseBalance(BigDecimal bigDecimal);

    AccountType getAccountType();
}