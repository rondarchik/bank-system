package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.repository.ClientAccountRepository;
import com.victoria.app.core.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountRepository clientAccountRepository;

    @Override
    public List<ClientAccount> findAllByClientAndBank(Client client, Bank bank) {
        return clientAccountRepository.findAllByClientAndBank(client, bank);
    }
}
