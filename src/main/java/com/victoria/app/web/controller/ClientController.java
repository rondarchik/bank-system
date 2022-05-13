package com.victoria.app.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

    @RequestMapping(value = {"/welcome_client"}, method = RequestMethod.GET)
    public String welcomeClient(Authentication authentication, Model model) {
        return "welcome_client";
    }
}