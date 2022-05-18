package com.victoria.app.core.service;

import com.victoria.app.core.model.CurrencyType;

public interface CurrencyService {

    int convertTo(CurrencyType from, CurrencyType to, int amount);
}
