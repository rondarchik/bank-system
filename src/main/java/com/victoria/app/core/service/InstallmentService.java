package com.victoria.app.core.service;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Installment;

import java.util.List;

public interface InstallmentService {

    List<Installment> getAllByClientAccount(ClientAccount clientAccount);

    List<Installment> getAll();

    Installment save(Installment installment);

    Installment getById(long id);
}
