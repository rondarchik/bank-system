package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.ManagerNotFoundException;
import com.victoria.app.core.exceptions.UserNotFoundException;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.Role;
import com.victoria.app.core.model.User;
import com.victoria.app.core.service.ActionLogService;
import com.victoria.app.core.service.ClientService;
import com.victoria.app.core.service.ManagerService;
import com.victoria.app.core.service.UserService;
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
}
