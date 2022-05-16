package com.victoria.app.core.service;

import com.victoria.app.core.model.Company;
import com.victoria.app.core.model.SalaryProject;

public interface SalaryProjectService {
    SalaryProject findByCompany(Company company);
}
