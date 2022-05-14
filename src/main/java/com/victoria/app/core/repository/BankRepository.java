package com.victoria.app.core.repository;

import com.victoria.app.core.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank getBankByName(String name);
}
