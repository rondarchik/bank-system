package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.UserNotFoundException;
import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.User;
import com.victoria.app.core.service.ActionLogService;
import com.victoria.app.core.service.BankService;
import com.victoria.app.core.service.ClientAccountService;
import com.victoria.app.core.service.ClientService;
import com.victoria.app.web.dto.UserClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("clientAccount/")
public class ClientAccountController {

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BankService bankService;

    @Autowired
    private ClientAccountService clientAccountService;

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
    public String getCredits(@PathVariable Long clientAccountId) {
       ClientAccount clientAccount = clientAccountService.getById(clientAccountId);



        return "clientAccountPage";
    }
}
