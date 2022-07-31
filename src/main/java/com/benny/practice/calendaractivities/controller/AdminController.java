package com.benny.practice.calendaractivities.controller;

import com.benny.practice.calendaractivities.model.User;
import com.benny.practice.calendaractivities.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private iUserService userService;

    //Only reachable by ADMIN
    //GET http://localhost:8080/api/admin/all
    @GetMapping("all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    //DELETE http://localhost:8080/api/admin/{userId}
    @DeleteMapping("{userId}")
    public  ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        User user = userService.deleteUser(userId);
        return ResponseEntity.ok(user);
    }
}
