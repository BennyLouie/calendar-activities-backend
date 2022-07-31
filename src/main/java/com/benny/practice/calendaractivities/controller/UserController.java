package com.benny.practice.calendaractivities.controller;

import com.benny.practice.calendaractivities.dto.UserDto;
import com.benny.practice.calendaractivities.model.Role;
import com.benny.practice.calendaractivities.model.User;
import com.benny.practice.calendaractivities.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private iUserService userService;

    //Example: POST http://localhost:8080/api/user - data {user form}
    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserDto user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            //Username should be unique
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //convert dto to model object
        userService.saveUser(user.convertToUser());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //GET http:localhost:8080/api/user/login -> should be same as security login path described before
    //Also used for logout path. After logout -> Spring will redirect to login path
    @GetMapping("login")
    public ResponseEntity<?> login(HttpServletRequest request) {
        //Authentication info will be stored on request by Spring Security
        Principal principal = request.getUserPrincipal();
        if (principal == null || principal.getName() == null) {
            //This is the logout redirection -> No Error
            return new ResponseEntity<>(HttpStatus.OK);
        }
        User user = userService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //PUT http:localhost:8080/api/user/{username}/change/{role}
    @PutMapping("{username}/change/{role}") //can also be POST/PATCH
    public ResponseEntity<?> changeRole(@PathVariable String username, @PathVariable Role role) {
        User user = userService.changeRole(role, username);
        return ResponseEntity.ok(user);
    }
}
