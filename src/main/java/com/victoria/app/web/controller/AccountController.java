package com.victoria.app.web.controller;

import com.victoria.app.core.model.Bank;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.CurrencyType;
import com.victoria.app.core.service.ClientAccountService;
import com.victoria.app.core.service.CurrencyService;
import com.victoria.app.web.dto.RemittanceDto;
import com.victoria.app.web.dto.СashWithdrawalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("account/")
public class AccountController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private ClientAccountService clientAccountService;

    @RequestMapping(value = "/client/{clientId}/bank/{bankId}", method = RequestMethod.POST)
    public String doCashWithdrawal(@ModelAttribute("cashWithdrawalDto") @Valid СashWithdrawalDto cashWithdrawalDto,
                                   @PathVariable Long clientId, @PathVariable Long bankId, Model model) {

        ClientAccount clientAccount = clientAccountService.getById(cashWithdrawalDto.getAccountId());
        if (clientAccount.isBlocked() || clientAccount.isFrozen()) {
            return "accountIsFrozen";
        }

        int amount = currencyService.convertTo(cashWithdrawalDto.getCurrencyType(), cashWithdrawalDto.getCurrencyType(), cashWithdrawalDto.getAmount());

        if (clientAccount.getBalance() > amount) {
            clientAccount.setBalance(clientAccount.getBalance() - amount);
            clientAccountService.save(clientAccount);
        } else {
            return "notEnoughMoney";
        }
        return "redirect:/client/" + clientId + "/banks/" + bankId;
    }


    @RequestMapping(value = "/remittance/client/{clientId}/bank/{bankId}", method = RequestMethod.POST)
    public String doRemittance(@ModelAttribute("remittanceDto") RemittanceDto remittanceDto,
                               @PathVariable Long clientId, @PathVariable Long bankId) {

        ClientAccount clientAccountFrom = clientAccountService.getById(remittanceDto.getAccountIdFrom());
        ClientAccount clientAccountTo = clientAccountService.getById(remittanceDto.getAccountIdTo());

        if (clientAccountFrom == null || clientAccountTo == null) {
            return "error";
        }

        if (clientAccountFrom.isBlocked() || clientAccountFrom.isFrozen() ||
                clientAccountTo.isBlocked() || clientAccountTo.isFrozen()) {
            return "accountIsFrozen";
        }

        float balanceFromInBYN = currencyService.toBYN(clientAccountFrom.getCurrencyType(), clientAccountFrom.getBalance());
        float balanceToInBYN = currencyService.toBYN(clientAccountTo.getCurrencyType(), clientAccountTo.getBalance());
        float amountInBYN = currencyService.toBYN(remittanceDto.getCurrencyType(), remittanceDto.getAmount());

        if (balanceFromInBYN > amountInBYN) {
            float newBalanceFromInBYN = balanceFromInBYN - amountInBYN;
            float newBalanceToInBYN = balanceToInBYN + amountInBYN;

            clientAccountFrom.setBalance(currencyService.convertTo(CurrencyType.BYN, clientAccountFrom.getCurrencyType(), (int) newBalanceFromInBYN));
            clientAccountTo.setBalance(currencyService.convertTo(CurrencyType.BYN, clientAccountTo.getCurrencyType(), (int) newBalanceToInBYN));

            clientAccountService.save(clientAccountFrom);
            clientAccountService.save(clientAccountTo);
        } else {
            return "notEnoughMoney";
        }
        return "redirect:/client/" + clientId + "/banks/" + bankId;
    }
}
