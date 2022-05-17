package com.victoria.app.web.dto;


public class SalaryProjectRequestDto {

    private Long salaryProjectId;

    private Long clientId;

    private boolean specApproved;

    private boolean operatorApproved;

    private int salary;

    public Long getSalaryProjectId() {
        return salaryProjectId;
    }

    public void setSalaryProjectId(Long salaryProjectId) {
        this.salaryProjectId = salaryProjectId;
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
