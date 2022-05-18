package com.victoria.app.core.service;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.User;

import java.util.List;


public interface ClientService {

    Client save(Client client);

    Client getClientByUser(User user);

    Client getClientById(Long id);
}
