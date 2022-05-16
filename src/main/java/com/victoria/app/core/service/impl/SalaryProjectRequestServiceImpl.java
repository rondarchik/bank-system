package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.repository.SalaryProjectRequestRepository;
import com.victoria.app.core.service.SalaryProjectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryProjectRequestServiceImpl implements SalaryProjectRequestService {

    @Autowired
    private SalaryProjectRequestRepository salaryProjectRequestRepository;

    @Override
    public SalaryProjectRequest findByClientId(long clientId) {
        return salaryProjectRequestRepository.findByClientId(clientId);
    }
}
