package com.victoria.app.web.controller;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.SalaryProject;
import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.service.*;
import com.victoria.app.web.dto.SalaryProjectRequestDto;
import com.victoria.app.web.dto.mapper.SalaryProjectRequestDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("client/")
public class ClientController {

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BankService bankService;

    @Autowired
    private SalaryProjectService salaryProjectService;

    @Autowired
    private SalaryProjectRequestService salaryProjectRequestService;

    @Autowired
    private SalaryProjectRequestDtoMapper salaryProjectRequestDtoMapper;


    @RequestMapping("/{clientId}/banks/{bankId}")
    public String getBankPageForClient(@PathVariable Long clientId, @PathVariable Long bankId, Model model) {
        Client client = clientService.getClientById(clientId);
        Bank bank = bankService.getBankById(bankId);

        SalaryProject salaryProject = salaryProjectService.findByCompany(client.getCompany());
        SalaryProjectRequest salaryProjectRequest = salaryProjectRequestService.findByClientId(clientId);

        if (salaryProjectRequest == null) {
            SalaryProjectRequestDto newSalaryProjectRequestDto = new SalaryProjectRequestDto();
            newSalaryProjectRequestDto.setClientId(clientId);
            newSalaryProjectRequestDto.setSalaryProjectId(salaryProject.getId());
            model.addAttribute("salaryProjectRequestDto", newSalaryProjectRequestDto);
        } else {
            model.addAttribute("salaryProjectRequestDto", salaryProjectRequestDtoMapper.mapToSalaryProjectRequestDto(salaryProjectRequest));
        }

        model.addAttribute("isSalaryProjectRequestExist", salaryProjectRequest != null);
        model.addAttribute("isSpecApproved", salaryProjectRequest != null && salaryProjectRequest.isSpecApproved());
        model.addAttribute("isOperatorApproved", salaryProjectRequest != null && salaryProjectRequest.isOperatorApproved());

        model.addAttribute("client", client);
        model.addAttribute("bank", bank);
        model.addAttribute("salaryProject", salaryProject);
        model.addAttribute("isClientBankCorrectForSalaryProject", isClientBankCorrectForSalaryProject(client, bankId));
        return "client_bank_page";
    }


    boolean isClientBankCorrectForSalaryProject(Client client, long bankId) {
        return client.getCompany().getBank().getId() == bankId;
    }
}
