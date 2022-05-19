package com.victoria.app.web.dto.mapper;

import com.victoria.app.core.model.Installment;
import com.victoria.app.core.service.ClientAccountService;
import com.victoria.app.core.utils.DateTimeUtils;
import com.victoria.app.web.dto.InstallmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InstallmentDtoMapper {

    @Autowired
    private ClientAccountService clientAccountService;

    public Installment mapToNewInstallment(InstallmentDto installmentDto, Long clientAccountId) {
        Installment installment = new Installment();

        installment.setApproved(false);
        installment.setStartDate(new Date());
        installment.setAmount(installmentDto.getAmount());
        installment.setClientAccount(clientAccountService.getById(clientAccountId));
        installment.setRemainingMonths(DateTimeUtils.getMonths(installmentDto.getDurationInMonths()));

        return installment;
    }
}
