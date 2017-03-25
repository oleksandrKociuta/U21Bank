package edu.cursor.u21.service.Impl;

import edu.cursor.u21.dao.BankClientRepository;
import edu.cursor.u21.service.BankClientService;
import edu.cursor.u21.users.bankClient.BankClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kocyta on 24.03.17.
 */
@Service
public class BankClientServiceImp implements BankClientService {
    @Autowired
    private BankClientRepository bankClientRepository;

    @Override
    public void addBankClient(BankClient bankClient) {
        bankClientRepository.saveAndFlush(bankClient);
    }

    @Override
    public void updateBankClient(BankClient bankClient) {
        bankClientRepository.saveAndFlush(bankClient);
    }

    @Override
    public void removeBankClient(long id) {
        bankClientRepository.delete(id);
    }

    @Override
    public BankClient getBankClientByID(long id) {
        return bankClientRepository.findOne(id);
    }

    @Override
    public List<BankClient> listAccounts() {
        return bankClientRepository.findAll();
    }

    @Override
    public BankClient getByName(String name) {
        return bankClientRepository.findByName(name);
    }
}
