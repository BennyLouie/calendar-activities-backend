package com.benny.practice.calendaractivities.controller;

import com.benny.practice.calendaractivities.dto.EventDto;
import com.benny.practice.calendaractivities.service.iEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/event")
public class EventController {

    @Autowired
    private iEventService eventService;

    //Example: POST http://localhost:8080/api/event - data {user form}
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EventDto event) {
        eventService.saveEvent(event.convertToEvent());
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }
}
