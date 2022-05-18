package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.CurrencyType;
import com.victoria.app.core.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    public final float conversionUSD = 2.5F;
    public final float conversionEUR = 3F;
    public final float conversionRUB = 0.3F;

    @Override
    public int convertTo(CurrencyType from, CurrencyType to, int amount) {
        float amountInBYN = toBYN(from, amount);
        if (to == CurrencyType.EUR) {
            return (int) (amountInBYN / conversionEUR);
        }
        if (to == CurrencyType.USD) {
            return (int) (amountInBYN / conversionUSD);
        }
        if (to == CurrencyType.RUB) {
            return (int) (amountInBYN / conversionRUB);
        }

        return (int) amountInBYN;
    }

    @Override
    public float toBYN(CurrencyType from, int amount) {
        if (from == CurrencyType.EUR) {
            return amount * conversionEUR;
        }
        if (from == CurrencyType.USD) {
            return amount * conversionUSD;
        }
        if (from == CurrencyType.RUB) {
            return amount * conversionRUB;
        }
        return amount;
    }
}
