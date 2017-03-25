package edu.cursor.u21.dao;

import edu.cursor.u21.users.bankClient.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Kocyta on 24.03.17.
 */
@Repository
public interface BankClientRepository extends JpaRepository<BankClient, Long> {
    @Query("select b from BankClient b where b.name = :name")
    BankClient findByName(@Param("name") String name);

}
