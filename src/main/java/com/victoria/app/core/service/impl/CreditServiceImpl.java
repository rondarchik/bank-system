package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Credit;
import com.victoria.app.core.repository.CreditRepository;
import com.victoria.app.core.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public List<Credit> getAllByClientAccount(ClientAccount clientAccount) {
        return creditRepository.getAllByClientAccount(clientAccount);
    }

    @Override
    public Credit save(Credit credit) {
        return creditRepository.save(credit);
    }
}
