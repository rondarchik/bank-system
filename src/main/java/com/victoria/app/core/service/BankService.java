package com.victoria.app.core.service;

import com.victoria.app.core.model.Bank;

import java.util.List;

public interface BankService {
    List<Bank> findAll();

    Bank getBankByName(String name);
}
