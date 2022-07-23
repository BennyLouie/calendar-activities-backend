package com.benny.practice.calendaractivities.repository;

import com.benny.practice.calendaractivities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
