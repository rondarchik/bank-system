package com.victoria.app.web.dto.mapper;

import com.victoria.app.core.model.ClientAccount;
import com.victoria.app.core.model.Credit;
import com.victoria.app.core.model.Installment;
import com.victoria.app.core.service.ClientAccountService;
import com.victoria.app.core.utils.DateTimeUtils;
import com.victoria.app.web.dto.CreditDto;
import com.victoria.app.web.dto.InstallmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreditDtoMapper {

    @Autowired
    private ClientAccountService clientAccountService;

    public Credit mapToNewCredit(CreditDto creditDto, Long clientAccountId) {
        Credit credit = new Credit();

        credit.setApproved(false);
        credit.setStartDate(new Date());
        credit.setAmount(creditDto.getAmount());
        credit.setPercent(creditDto.getPercent());
        credit.setClientAccount(clientAccountService.getById(clientAccountId));
        credit.setRemainingMonths(DateTimeUtils.getMonths(creditDto.getDurationInMonths()));

        return credit;
    }
}
