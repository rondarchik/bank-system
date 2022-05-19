package com.victoria.app.core.service;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Credit;

import java.util.List;

public interface CreditService {
    List<Credit> getAllByClientAccount(ClientAccount clientAccount);

    Credit save(Credit credit);

}
