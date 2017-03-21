package edu.cursor.u21.dao;

import edu.cursor.u21.users.bankClient.Accounts.Account;
import edu.cursor.u21.users.bankClient.Accounts.AccountStatus;

import java.util.List;

interface AccountDao {
    void addAccount(Account account);

    List listAccount();

    void changeAccountStatus(Integer accountId, AccountStatus accountStatus);
}
