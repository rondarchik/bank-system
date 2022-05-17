package com.victoria.app.web.controller;

import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.service.ActionLogService;
import com.victoria.app.core.service.SalaryProjectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("specialist/")
public class SpecialistController {

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    private SalaryProjectRequestService salaryProjectRequestService;

    @RequestMapping(value = "/submitSalaryProjectRequest/{salaryProjectRequestId}", method = RequestMethod.POST)
    public String sendSalaryProjectRequest(@ModelAttribute("salaryProjectRequest") SalaryProjectRequest request, @PathVariable Long salaryProjectRequestId) {
        SalaryProjectRequest salaryProjectRequest = salaryProjectRequestService.findById(salaryProjectRequestId);
        salaryProjectRequest.setSpecApproved(true);
        salaryProjectRequest.setSalary(request.getSalary());

        salaryProjectRequestService.save(salaryProjectRequest);
        return "salaryProjectRequestSuccessBySpecialist";
    }
}
