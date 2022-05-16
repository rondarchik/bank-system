package com.victoria.app.core.model;

import javax.persistence.*;

@Entity
@Table(name = "salary_project_requests")
public class SalaryProjectRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private SalaryProject salaryProject;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "spec_approved")
    private boolean specApproved;

    @Column(name = "operator_approved")
    private boolean operatorApproved;

    @Column(name = "salary")
    private int salary;

    public SalaryProjectRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalaryProject getSalaryProject() {
        return salaryProject;
    }

    public void setSalaryProject(SalaryProject salaryProject) {
        this.salaryProject = salaryProject;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public boolean isSpecApproved() {
        return specApproved;
    }

    public void setSpecApproved(boolean specApproved) {
        this.specApproved = specApproved;
    }

    public boolean isOperatorApproved() {
        return operatorApproved;
    }

    public void setOperatorApproved(boolean operatorApproved) {
        this.operatorApproved = operatorApproved;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
