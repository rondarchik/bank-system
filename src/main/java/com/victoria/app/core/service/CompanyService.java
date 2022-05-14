package com.victoria.app.core.service;

import com.victoria.app.core.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company getCompanyByName(String name);
}
