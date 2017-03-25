package edu.cursor.u21.service.Impl;

import edu.cursor.u21.dao.AccountRepository;
import edu.cursor.u21.service.AccountService;
import edu.cursor.u21.users.bankClient.Accounts.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kocyta on 24.03.17.
 */
@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void addAccount(Account account) {
        accountRepository.saveAndFlush(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.saveAndFlush(account);
    }

    @Override
    public void removeAccount(long id) {
        accountRepository.delete(id);
    }

    @Override
    public Account getAccountByID(long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }
}
