package com.victoria.app.core.repository;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
    List<ClientAccount> findAllByClientAndBank(Client client, Bank bank);

    ClientAccount getById(Long id);

    ClientAccount save(ClientAccount clientAccount);
}
