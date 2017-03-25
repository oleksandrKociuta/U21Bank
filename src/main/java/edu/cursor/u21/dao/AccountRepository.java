package edu.cursor.u21.dao;

import edu.cursor.u21.users.bankClient.Accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kocyta on 24.03.17.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
