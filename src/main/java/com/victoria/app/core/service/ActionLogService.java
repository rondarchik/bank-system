package com.victoria.app.core.service;

import com.victoria.app.core.model.ActionLog;

import java.util.List;

public interface ActionLogService {

    ActionLog save(ActionLog actionLog);

    List<ActionLog> getAll();
}
