package com.victoria.app.web.dto;

import com.victoria.app.core.model.DurationInMonths;

public class InstallmentDto {

    int amount;

    DurationInMonths durationInMonths;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DurationInMonths getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(DurationInMonths durationInMonths) {
        this.durationInMonths = durationInMonths;
    }
}
