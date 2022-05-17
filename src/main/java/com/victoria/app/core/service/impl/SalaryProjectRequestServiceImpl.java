package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.repository.SalaryProjectRequestRepository;
import com.victoria.app.core.service.SalaryProjectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryProjectRequestServiceImpl implements SalaryProjectRequestService {

    @Autowired
    private SalaryProjectRequestRepository salaryProjectRequestRepository;

    @Override
    public SalaryProjectRequest findByClientId(long clientId) {
        return salaryProjectRequestRepository.findByClientId(clientId);
    }

    @Override
    public SalaryProjectRequest findById(long id) {
        return salaryProjectRequestRepository.findById(id);
    }

    @Override
    public List<SalaryProjectRequest> findAll() {
        return salaryProjectRequestRepository.findAll();
    }

    @Override
    public SalaryProjectRequest save(SalaryProjectRequest salaryProjectRequest) {
        return salaryProjectRequestRepository.save(salaryProjectRequest);
    }
}
