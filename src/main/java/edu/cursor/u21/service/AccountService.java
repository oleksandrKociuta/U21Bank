package edu.cursor.u21.service;

import edu.cursor.u21.users.bankClient.Accounts.Account;

import java.util.List;

/**
 * Created by Kocyta on 24.03.17.
 */
public interface AccountService {
    void addAccount(Account account);

    void updateAccount(Account account);

    void removeAccount(long id);

    Account getAccountByID(long id);

    List<Account> listAccounts();
}
