package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.TicketDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Repository.EventRepository;
import com.example.demo.entity.Repository.TicketRepository;
import com.example.demo.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public EventDto addEvent( String name, LocalDate date, Long availableSeats) {
        Event event= new Event();
        event.setName(name);
        event.setDate(date);
        if(date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The event date cannot be before today");
        }
        event.setAvailableSeats(availableSeats);
        if(availableSeats<=0){
            throw  new IllegalArgumentException("Available Seats must be greater than 0");
        }
        Event eventAdded= eventRepository.save(event);

        return new EventDto(
                eventAdded.getEventId(),
                eventAdded.getName(),
                eventAdded.getDate(),
                eventAdded.getAvailableSeats());
    }
    public Object list (int page, int size){
        return eventRepository.findAll(PageRequest.of(page, size));
    }
    public TicketDto book(Long userId, Long eventId){
        Ticket ticket= new Ticket();
        Event event = new Event();
        if(eventRepository.existsById(eventId)){
            ticket.setEventId(eventId);
            ticket.setUserId(userId);

        }else{
            throw  new IllegalArgumentException("Event not founded");
        }
        Ticket ticketAdded = ticketRepository.save(ticket);
        return new TicketDto(ticketAdded.getId(),ticketAdded.getEventId(),ticketAdded.getUserId());
    }


}
