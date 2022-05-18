package com.victoria.app.web.controller;

import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.service.ActionLogService;
import com.victoria.app.core.service.SalaryProjectRequestService;
import com.victoria.app.core.service.SalaryProjectService;
import com.victoria.app.web.dto.mapper.SalaryProjectRequestDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("salaryProject/")
public class SalaryProjectController {

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    private SalaryProjectService salaryProjectService;

    @Autowired
    private SalaryProjectRequestService salaryProjectRequestService;

    @Autowired
    private SalaryProjectRequestDtoMapper salaryProjectRequestDtoMapper;

    @RequestMapping(value = "/{salaryProjectId}/client/{clientId}", method = RequestMethod.GET)
    public String sendSalaryProjectRequest(Model model, @PathVariable Long clientId, @PathVariable Long salaryProjectId) {
        SalaryProjectRequest salaryProjectRequest = new SalaryProjectRequest();
        salaryProjectRequest.setSalaryProject(salaryProjectService.findById(salaryProjectId));
        salaryProjectRequest.setClientId(clientId);

        salaryProjectRequestService.save(salaryProjectRequest);
        return "salaryProjectRequestRegistrationSuccess";
    }
}
