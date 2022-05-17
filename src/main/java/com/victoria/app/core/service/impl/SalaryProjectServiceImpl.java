package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.Company;
import com.victoria.app.core.model.SalaryProject;
import com.victoria.app.core.repository.SalaryProjectRepository;
import com.victoria.app.core.service.SalaryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryProjectServiceImpl implements SalaryProjectService {

    @Autowired
    private  SalaryProjectRepository salaryProjectRepository;

    @Override
    public SalaryProject findByCompany(Company company) {
        return salaryProjectRepository.findByCompany(company);
    }

    @Override
    public SalaryProject findById(Long id) {
        return salaryProjectRepository.findById(id);
    }
}
