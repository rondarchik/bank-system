package com.victoria.app.web.controller;

import com.victoria.app.core.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OperatorController {

    @Autowired
    private ActionLogService actionLogService;


}
