package com.victoria.app.web.controller;

import com.victoria.app.core.exceptions.RoleNotFoundException;
import com.victoria.app.core.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
            return "redirect:/welcome_third_party_specialist";
        } else {
            throw new RoleNotFoundException();
        }
    }

}
