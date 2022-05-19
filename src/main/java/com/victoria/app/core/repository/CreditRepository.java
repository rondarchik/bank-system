package com.victoria.app.core.repository;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {

    List<Credit> getAllByClientAccount(ClientAccount clientAccount);

    Credit getById(long id);
}
