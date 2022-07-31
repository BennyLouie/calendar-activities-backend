package com.benny.practice.calendaractivities.dto;

import com.benny.practice.calendaractivities.model.Event;
import com.benny.practice.calendaractivities.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter //No need for Setters
@NoArgsConstructor
public class EventDto {

    private LocalDateTime date;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private Long userid;

    public Event convertToEvent() {
        Event event = new Event();
        event.setDate(date);
        event.setTitle(title);
        event.setDescription(description);
        event.setStatus(Status.Incomplete);
        event.setUserid(userid);
        return event;
    }
}
