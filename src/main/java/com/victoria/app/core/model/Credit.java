package com.victoria.app.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private ClientAccount clientAccount;

    @Column(name = "percent")
    private int percent;

    @Column(name = "amount")
    private int amount;

    @Column(name = "remaining_months")
    private int remainingMonths;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "start_date")
    private Date startDate;

    public Credit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

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

    public int getRemainingMonths() {
        return remainingMonths;
    }

    public void setRemainingMonths(int remainingMonths) {
        this.remainingMonths = remainingMonths;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
