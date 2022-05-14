package com.victoria.app.core.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "company")
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CompanyType type;

    @Column(name = "name")
    private String name;

    @Column(name = "unp")
    private String unp;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<CompanyAccount> companyAccounts;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnp() {
        return unp;
    }

    public void setUnp(String unp) {
        this.unp = unp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CompanyAccount> getCompanyAccounts() {
        return companyAccounts;
    }

    public void setCompanyAccounts(List<CompanyAccount> companyAccounts) {
        this.companyAccounts = companyAccounts;
    }

    @Override
    public String toString() {
        return name;
    }
}
