package com.victoria.app.core.repository;

import com.victoria.app.core.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
