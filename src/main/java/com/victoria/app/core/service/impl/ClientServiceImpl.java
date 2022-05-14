package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.Client;
import com.victoria.app.core.repository.ClientRepository;
import com.victoria.app.core.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
