package com.benny.practice.calendaractivities.service;

import com.benny.practice.calendaractivities.model.Event;
import com.benny.practice.calendaractivities.repository.iEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService implements iEventService {

    @Autowired
    private iEventRepository eventRepository;

    @Autowired
    private iUserService userService;

    @Override
    public Event saveEvent(Event event) {
        event.setCreateDate(LocalDateTime.now());
        return eventRepository.save(event);
    };

    @Override
    public List<Event> findByUserid(Long id) {
        return eventRepository.findByUserid(id);
    }

    @Override
    public Event deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException());
        eventRepository.delete(event);
        return event;
    }


}
