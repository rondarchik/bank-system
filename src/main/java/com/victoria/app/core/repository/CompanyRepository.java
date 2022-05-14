package com.victoria.app.core.repository;

import com.victoria.app.core.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company, Long> {

    Company getCompanyByName(String name);
}
