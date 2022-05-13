package com.victoria.app.core.service.impl;

import com.victoria.app.core.exceptions.UserNotFoundException;
import com.victoria.app.core.model.User;
import com.victoria.app.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        User user = userService.findByLogin(login).orElseThrow(UserNotFoundException::new);
        enabled = user.isActive();

        Set<GrantedAuthority> grantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }
}
