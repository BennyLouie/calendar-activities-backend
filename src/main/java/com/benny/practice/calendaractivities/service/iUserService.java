package com.benny.practice.calendaractivities.service;

import com.benny.practice.calendaractivities.model.User;

import java.util.List;

public interface iUserService {
    User saveUser(User user);

    User findByUsername(String username) throws RuntimeException;

    User deleteUser(Long userid);

    List<User> findAllUsers();
}
