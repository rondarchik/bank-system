package com.victoria.app.core.repository;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank getBankByName(String name);

    Bank getBankById(long id);

    List<Bank> getAllByClients(List<Client> clients);
}
