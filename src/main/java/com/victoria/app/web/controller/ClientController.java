package com.victoria.app.web.controller;

import com.victoria.app.core.model.Client;
import com.victoria.app.core.service.ActionLogService;
import com.victoria.app.core.service.BankService;
import com.victoria.app.core.service.ClientService;
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

    @RequestMapping("/{clientId}/banks/{bankId}")
    public String getBankPageForClient(@PathVariable Long clientId, @PathVariable Long bankId, Model model) {
        Client client = clientService.getClientById(clientId);
        model.addAttribute("client", client);
        return "client_bank_page";
    }
}
