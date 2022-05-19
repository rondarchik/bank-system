package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.UserNotFoundException;
import com.victoria.app.core.model.*;
import com.victoria.app.core.service.*;
import com.victoria.app.web.dto.CreditDto;
import com.victoria.app.web.dto.InstallmentDto;
import com.victoria.app.web.dto.mapper.CreditDtoMapper;
import com.victoria.app.web.dto.mapper.InstallmentDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("clientAccount/")
public class ClientAccountController {

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private InstallmentService installmentService;

    @Autowired
    private BankService bankService;

    @Autowired
    private ClientAccountService clientAccountService;

    @Autowired
    private CreditDtoMapper creditDtoMapper;

    @Autowired
    private InstallmentDtoMapper installmentDtoMapper;

    @RequestMapping("/create/{clientId}/{bankId}")
    public String createClientAccount(@ModelAttribute("newClientAccount") @Valid ClientAccount clientAccount,
                                      @PathVariable Long clientId, @PathVariable Long bankId) {
        Client client = clientService.getClientById(clientId);
        Bank bank = bankService.getBankById(bankId);

        clientAccount.setClient(client);
        clientAccount.setBank(bank);
        clientAccountService.save(clientAccount);
        return "redirect:/client/" + clientId + "/banks/" + bankId;
    }


    @RequestMapping("/{clientAccountId}")
    public String getCredits(@PathVariable Long clientAccountId, Model model) {
        ClientAccount clientAccount = clientAccountService.getById(clientAccountId);

        List<Credit> credits = creditService.getAllByClientAccount(clientAccount);
        List<Installment> installments = installmentService.getAllByClientAccount(clientAccount);

        model.addAttribute("credits", credits);
        model.addAttribute("installments", installments);

        model.addAttribute("newCredit", new CreditDto());
        model.addAttribute("newInstallment", new InstallmentDto());

        model.addAttribute("notApproved", areNotApprovedCreditsOrInstallments(credits, installments));
        model.addAttribute("clientAccountId", clientAccountId);
        return "clientAccountPage";
    }


    @RequestMapping("/{clientAccountId}/createCredit")
    public String createCredit(@ModelAttribute("newCredit") @Valid CreditDto newCredit, @PathVariable Long clientAccountId, Model model) {
        Credit credit = creditDtoMapper.mapToNewCredit(newCredit, clientAccountId);
        creditService.save(credit);
        return "redirect:/clientAccount/{clientAccountId}";
    }

    @RequestMapping("/{clientAccountId}/createInstallment")
    public String createInstallment(@ModelAttribute("newInstallment") @Valid InstallmentDto newInstallment, @PathVariable Long clientAccountId, Model model) {
        Installment installment = installmentDtoMapper.mapToNewInstallment(newInstallment, clientAccountId);
        installmentService.save(installment);
        return "redirect:/clientAccount/{clientAccountId}";
    }

    private boolean areNotApprovedCreditsOrInstallments(List<Credit> credits, List<Installment> installments) {
        for (Credit credit : credits) {
            if (!credit.isApproved()) {
                return true;
            }
        }

        for (Installment installment : installments) {
            if (!installment.isApproved()) {
                return true;
            }
        }

        return false;
    }
}
