package com.victoria.app.core.repository;

import com.victoria.app.core.model.Manager;
import com.victoria.app.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional <Manager> findByUser(User user);
}
