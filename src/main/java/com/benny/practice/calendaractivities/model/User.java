package com.benny.practice.calendaractivities.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //Getters and Setters handled by lombok
@Entity
@Table(name = "users") //Table name must be plural
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
}
