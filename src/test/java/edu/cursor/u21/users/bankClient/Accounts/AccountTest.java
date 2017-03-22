package edu.cursor.u21.users.bankClient.Accounts;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by vk on 3/2/17.
 */
public class AccountTest {
    @Test
    public void increaseBalance() throws Exception {

    }

    @Test
    public void decreaseBalance() throws Exception {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(23));
        Assert.assertEquals(account.getBalance().subtract(BigDecimal.valueOf(23)),BigDecimal.valueOf(0));
    }

}