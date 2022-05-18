package com.victoria.app.core.service;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.ClientAccount;

import java.util.List;

public interface ClientAccountService {

    List<ClientAccount> findAllByClientAndBank(Client client, Bank bank);

    ClientAccount getById(Long id);

    ClientAccount save(ClientAccount clientAccount);

    ClientAccount getNewClientAccount(Bank bank, Client client);
}
