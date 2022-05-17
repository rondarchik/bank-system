package com.victoria.app.web.controller;

import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.service.ActionLogService;
import com.victoria.app.core.service.ClientService;
import com.victoria.app.core.service.SalaryProjectRequestService;
import com.victoria.app.core.service.SalaryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("operator/")
public class OperatorController {

    @Autowired
    private SalaryProjectRequestService salaryProjectRequestService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ActionLogService actionLogService;


    @RequestMapping(value = "/submitSalaryProjectRequest/{salaryProjectRequestId}", method = RequestMethod.GET)
    public String sendSalaryProjectRequest(@PathVariable Long salaryProjectRequestId, Model model) {
        SalaryProjectRequest salaryProjectRequest = salaryProjectRequestService.findById(salaryProjectRequestId);
        salaryProjectRequest.setOperatorApproved(true);
        salaryProjectRequestService.save(salaryProjectRequest);

        Client client = clientService.getClientById(salaryProjectRequest.getClientId());
        model.addAttribute("clientName", client.getUser().getLogin());
        return "salaryProjectRequestSuccessByOperator";
    }


}
