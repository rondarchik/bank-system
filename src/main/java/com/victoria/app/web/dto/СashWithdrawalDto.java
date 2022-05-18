package com.victoria.app.web.dto;

import com.victoria.app.core.model.CurrencyType;
import org.hibernate.validator.constraints.NotBlank;

public class СashWithdrawalDto {

    long accountId;

    int amount;

    CurrencyType currencyType;

    public СashWithdrawalDto() {
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
