package com.victoria.app.core.service;

import com.victoria.app.core.model.SalaryProjectRequest;

public interface SalaryProjectRequestService {

    SalaryProjectRequest findByClientId(long clientId);

}
