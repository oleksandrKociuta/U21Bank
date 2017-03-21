package edu.cursor.u21.dao;

import edu.cursor.u21.users.bankClient.Accounts.Account;
import edu.cursor.u21.users.bankClient.Accounts.AccountStatus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vk on 3/20/17.
 */
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addAccount(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    public List listAccount() {
        return sessionFactory.getCurrentSession().createQuery("from Account").list();
    }

    public void changeAccountStatus(Integer accountId, AccountStatus accountStatus) {
        Account account = (Account) sessionFactory.getCurrentSession().load(Account.class, accountId);
        if (account != null) {
            account.setStatus(accountStatus);
            sessionFactory.getCurrentSession().update(account);
        }
    }


}
