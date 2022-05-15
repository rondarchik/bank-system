package com.victoria.app.core.repository;

import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getClientByUser(User user);

    Client getClientById(Long id);
}
