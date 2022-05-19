package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Installment;
import com.victoria.app.core.repository.InstallmentRepository;
import com.victoria.app.core.service.InstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallmentServiceImpl implements InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;

    @Override
    public List<Installment> getAllByClientAccount(ClientAccount clientAccount) {
        return installmentRepository.getAllByClientAccount(clientAccount);
    }

    @Override
    public Installment save(Installment installment) {
        return installmentRepository.save(installment);
    }
}
