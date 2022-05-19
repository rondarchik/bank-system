package com.victoria.app.core.repository;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Credit;
import com.victoria.app.core.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {
    List<Installment> getAllByClientAccount(ClientAccount clientAccount);

    Installment getById(long id);
}
