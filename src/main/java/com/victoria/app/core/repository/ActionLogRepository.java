package com.victoria.app.core.repository;

import com.victoria.app.core.model.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionLogRepository  extends JpaRepository<ActionLog, Long> {
}
