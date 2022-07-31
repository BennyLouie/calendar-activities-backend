package com.benny.practice.calendaractivities.service;

import com.benny.practice.calendaractivities.model.Role;
import com.benny.practice.calendaractivities.model.User;

import java.util.List;

public interface iUserService {
    User saveUser(User user);

    User findByUsername(String username) throws RuntimeException;

    User deleteUser(Long userid);

    User changeRole(Role newRole, String username) throws RuntimeException;

    List<User> findAll();
}
