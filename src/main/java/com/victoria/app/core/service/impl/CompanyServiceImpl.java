package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.Company;
import com.victoria.app.core.repository.CompanyRepository;
import com.victoria.app.core.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyByName(String name) {
        return companyRepository.getCompanyByName(name);
    }
}
