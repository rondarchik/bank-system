package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.ManagerNotFoundException;
import com.victoria.app.core.exceptions.RoleNotFoundException;
import com.victoria.app.core.exceptions.UserAlreadyExistsException;
import com.victoria.app.core.exceptions.UserNotFoundException;
import com.victoria.app.core.model.Client;
import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.Role;
import com.victoria.app.core.model.User;
import com.victoria.app.core.service.*;
import com.victoria.app.web.dto.UserClientDto;
import com.victoria.app.web.dto.mapper.UserClientDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BankService bankService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserClientDtoMapper userClientDtoMapper;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains(Role.CLIENT.name())) {
            return "redirect:/welcome_client";
        } else if (roles.contains(Role.ADMIN.name())) {
            return "redirect:/welcome_admin";
        } else if (roles.contains(Role.MANAGER.name())) {
            return "redirect:/welcome_manager";
        } else if (roles.contains(Role.OPERATOR.name())) {
            return "redirect:/welcome_operator";
        } else if (roles.contains(Role.THIRD_PARTY_SPECIALIST.name())) {
            return "redirect:/welcome_specialist";
        } else {
            throw new RoleNotFoundException();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("banks", bankService.findAll());
        model.addAttribute("companies", companyService.findAll());

        model.addAttribute("user", new UserClientDto());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") @Valid UserClientDto userClientDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            User newUser = userClientDtoMapper.mapToUser(userClientDto);
            newUser.setActive(false);

            Client newClient = userClientDtoMapper.mapToClient(userClientDto);
            newClient.setUser(newUser);

            newUser = userService.save(newUser);
            newClient = clientService.save(newClient);

            model.addAttribute("successRegistration", "Successful Registration !!! Wait for manager approve.");
            return "registration";
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            model.addAttribute("userExists", "User already exists !!! Please,try again.");
            return "registration";
        }
    }


    @RequestMapping(value = {"/welcome_manager"}, method = RequestMethod.GET)
    public String welcomeManagerUser(Authentication authentication, Model model) {
        User user = userService.findByLogin(authentication.getName()).orElseThrow(UserNotFoundException::new);
        Manager manager = managerService.findByUser(user).orElseThrow(ManagerNotFoundException::new);;

        model.addAttribute("user", user);
        model.addAttribute("nonActiveClients", userService.getAllNonActiveUserClientsForManager(manager));
        return "welcome_manager";
    }
}
