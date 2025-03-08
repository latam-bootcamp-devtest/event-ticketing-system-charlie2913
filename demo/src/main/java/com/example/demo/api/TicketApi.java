package com.example.demo.api;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.TicketDto;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketApi {
    private final EventService eventService;
    @Autowired
    public TicketApi(EventService eventService){this.eventService=eventService;}

    @PostMapping("/book")
    public ResponseEntity<TicketDto> addEvent(
            @RequestParam(name="eventId") Long eventId,
            @RequestParam(name="userId") Long userId
    ) {
        try {
            TicketDto ticketDto = eventService.book(eventId, userId);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
