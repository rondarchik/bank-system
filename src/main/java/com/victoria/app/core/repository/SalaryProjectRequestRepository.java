package com.victoria.app.core.repository;

import com.victoria.app.core.model.SalaryProjectRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryProjectRequestRepository extends JpaRepository<SalaryProjectRequest, Long> {

    SalaryProjectRequest findByClientId(long clientId);

    SalaryProjectRequest findById(long id);
}
