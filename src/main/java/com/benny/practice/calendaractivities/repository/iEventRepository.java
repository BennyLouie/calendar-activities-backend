package com.benny.practice.calendaractivities.repository;

import com.benny.practice.calendaractivities.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iEventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where e.userid = (:pId)")
    List<Event> findByUserid(@Param("pId") Long id);
}
