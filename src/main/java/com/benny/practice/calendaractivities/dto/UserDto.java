package com.benny.practice.calendaractivities.dto;

import com.benny.practice.calendaractivities.model.Role;
import com.benny.practice.calendaractivities.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter //No need for Setters
@NoArgsConstructor //new UserDto()
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public User convertToUser() {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.ROLE_USER);
        return user;
    }
}
