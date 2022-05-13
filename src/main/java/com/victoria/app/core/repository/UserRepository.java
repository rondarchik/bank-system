package com.victoria.app.core.repository;

import com.victoria.app.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);
}
