package edu.cursor.u21.service;

import edu.cursor.u21.users.bankClient.BankClient;

import java.util.List;

/**
 * Created by Kocyta on 24.03.17.
 */
public interface BankClientService {
    void addBankClient(BankClient bankClient);

    void updateBankClient(BankClient bankClient);

    void removeBankClient(long id);

    BankClient getBankClientByID(long id);

    List<BankClient> listAccounts();

    BankClient getByName(String name);
}
