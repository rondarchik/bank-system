package com.victoria.app.web.dto;

import com.victoria.app.core.model.DurationInMonths;

public class CreditDto {

    int percent;

    int amount;

    DurationInMonths durationInMonths;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

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
