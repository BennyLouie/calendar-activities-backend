package com.benny.practice.calendaractivities.service;

import com.benny.practice.calendaractivities.repository.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService{

    @Autowired
    private iUserRepository userRepository;
}
