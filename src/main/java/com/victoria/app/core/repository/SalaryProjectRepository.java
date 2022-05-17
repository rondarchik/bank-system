package com.victoria.app.core.repository;

import com.victoria.app.core.model.Company;
import com.victoria.app.core.model.SalaryProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryProjectRepository extends JpaRepository<SalaryProject, Long> {

    SalaryProject findByCompany(Company company);

    SalaryProject findById(Long id);

}
