package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.ManagerNotFoundException;
import com.victoria.app.core.exceptions.UserNotFoundException;
import com.victoria.app.core.model.*;
import com.victoria.app.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("manager_v1/")
public class ManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private InstallmentService installmentService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ActionLogService actionLogService;

    @RequestMapping("/{userId}/activate")
    public String activateUser(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setActive(true);
        userService.save(user);
        return "redirect:/welcome_manager";
    }

    @RequestMapping(value = "/installment/{installmentId}/approve", method = RequestMethod.GET)
    public String approveInstallment(@PathVariable Long installmentId) {
        Installment installment = installmentService.getById(installmentId);
        installment.setApproved(true);

        installmentService.save(installment);
        return "redirect:/welcome_manager";
    }

    @RequestMapping(value = "/credit/{creditId}/approve", method = RequestMethod.GET)
    public String approveCredit(@PathVariable Long creditId) {
        Credit credit = creditService.getById(creditId);
        credit.setApproved(true);

        creditService.save(credit);
        return "redirect:/welcome_manager";
    }


}
