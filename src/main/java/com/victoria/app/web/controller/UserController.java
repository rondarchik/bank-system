package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.RoleNotFoundException;
import com.victoria.app.core.model.Role;
import com.victoria.app.core.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Controller
public class UserController {

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
        model.addAttribute("user", new User());
        return "registration";
    }

}
