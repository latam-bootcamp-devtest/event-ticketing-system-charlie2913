package com.example.demo.entity.Repository;

import com.example.demo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
    boolean existsById(Long eventId);

}
