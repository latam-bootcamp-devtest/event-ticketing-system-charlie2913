package com.example.demo.api;
import com.example.demo.dto.EventDto;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.text.ParseException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/events")
public class EventApi {
    private final EventService eventService;
    @Autowired
    public EventApi(EventService eventService){this.eventService=eventService;}

    @PostMapping("/add")
    public ResponseEntity<EventDto> addEvent(
            @RequestParam(name="name") String name,
            @RequestParam(name="date")LocalDate date,
            @RequestParam(name="availableSeats") Long availableSeats
            ) {
        try {
            EventDto eventDto = eventService.addEvent(name, date, availableSeats);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/list")
    public Object list(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return eventService.list(page, size);
    }


}
