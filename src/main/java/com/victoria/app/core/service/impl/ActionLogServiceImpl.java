package com.victoria.app.core.service.impl;

import com.victoria.app.core.model.ActionLog;
import com.victoria.app.core.repository.ActionLogRepository;
import com.victoria.app.core.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionLogServiceImpl implements ActionLogService {

    @Autowired
    private ActionLogRepository actionLogRepository;

    @Override
    public ActionLog save(ActionLog actionLog) {
        return actionLogRepository.save(actionLog);
    }

    @Override
    public List<ActionLog> getAll() {
        return actionLogRepository.findAll();
    }
}
