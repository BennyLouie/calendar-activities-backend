package com.benny.practice.calendaractivities.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //Getters and Setters handled by Lombok
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "userid", nullable = false)
    private Long userid;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
