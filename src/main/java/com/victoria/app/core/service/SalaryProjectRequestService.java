package com.victoria.app.core.service;

import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.model.User;

import java.util.List;

public interface SalaryProjectRequestService {

    SalaryProjectRequest findByClientId(long clientId);

    SalaryProjectRequest findById(long id);

    List<SalaryProjectRequest> findAll();

    SalaryProjectRequest save(SalaryProjectRequest salaryProjectRequest);

}
