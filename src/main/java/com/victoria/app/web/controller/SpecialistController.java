package com.victoria.app.web.controller;

import com.victoria.app.core.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpecialistController {

    @Autowired
    private ActionLogService actionLogService;


}
