package edu.cursor.u21.users.bankClient.Accounts;

import edu.cursor.u21.users.bankClient.BankClient;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by vk on 3/2/17.
 */
public class AccountFactoryTest {
    BankClient bankClient = new BankClient();
    HashMap<String, BankClient> usersMap = new HashMap<>();
    HashMap<String, AccountInterface> usersAccounts = new HashMap<>();

    @BeforeClass
    public static void  setUp() {
           }
    @Test(expected = NullPointerException.class)
    public void test_Account_Number() throws Exception {
        Account account = new Account();
        Assert.assertFalse(account.getAccountNumber()==null);
    }

    @Test
    public void deleteAccount() throws Exception {
     }
}