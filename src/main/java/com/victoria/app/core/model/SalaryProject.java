package com.victoria.app.core.model;

import javax.persistence.*;

@Entity
@Table(name = "salary_projects")
public class SalaryProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public SalaryProject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
