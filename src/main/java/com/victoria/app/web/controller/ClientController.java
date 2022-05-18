package com.victoria.app.web.controller;

import com.victoria.app.core.model.*;
import com.victoria.app.core.service.*;
import com.victoria.app.web.dto.RemittanceDto;
import com.victoria.app.web.dto.SalaryProjectRequestDto;
import com.victoria.app.web.dto.mapper.SalaryProjectRequestDtoMapper;
import com.victoria.app.web.dto.СashWithdrawalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("client/")
public class ClientController {

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientAccountService clientAccountService;

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

        model.addAttribute("clientAccounts", clientAccountService.findAllByClientAndBank(client, bank)
                .stream().filter(clientAccount -> !clientAccount.isBlocked()).collect(Collectors.toList()));

        model.addAttribute("newClientAccount", clientAccountService.getNewClientAccount(bank, client));
        model.addAttribute("cashWithdrawalDto", new СashWithdrawalDto());
        model.addAttribute("remittanceDto", new RemittanceDto());

        return "client_bank_page";
    }

    @RequestMapping("/{clientAccountId}/freeze")
    private String freezeClientAccount(@PathVariable Long clientAccountId) {
        ClientAccount clientAccount = clientAccountService.getById(clientAccountId);
        clientAccount.setFrozen(true);
        clientAccountService.save(clientAccount);
        return "redirect:/client/" + clientAccount.getClient().getId() + "/banks/" + clientAccount.getBank().getId();
    }

    @RequestMapping("/{clientAccountId}/unfreeze")
    private String unfreezeClientAccount(@PathVariable Long clientAccountId) {
        ClientAccount clientAccount = clientAccountService.getById(clientAccountId);
        clientAccount.setFrozen(false);
        clientAccountService.save(clientAccount);
        return "redirect:/client/" + clientAccount.getClient().getId() + "/banks/" + clientAccount.getBank().getId();
    }

    @RequestMapping("/{clientAccountId}/block")
    private String blockClientAccount(@PathVariable Long clientAccountId) {
        ClientAccount clientAccount = clientAccountService.getById(clientAccountId);
        clientAccount.setBlocked(true);
        clientAccountService.save(clientAccount);
        return "redirect:/client/" + clientAccount.getClient().getId() + "/banks/" + clientAccount.getBank().getId();
    }

    private boolean isClientBankCorrectForSalaryProject(Client client, long bankId) {
        return client.getCompany().getBank().getId() == bankId;
    }
}
