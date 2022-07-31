package com.benny.practice.calendaractivities.service;

import com.benny.practice.calendaractivities.model.Event;

import java.util.List;

public interface iEventService {
    Event saveEvent(Event event);

    List<Event> findByUserid(Long id);

    Event deleteEvent(Long eventId);
}
