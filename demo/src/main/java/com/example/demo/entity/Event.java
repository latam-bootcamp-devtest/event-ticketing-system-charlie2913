package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "eventId")
    private Long eventId;

    @Column(name= "name")
    private String name;

    @Column(name= "date")
    private LocalDate date;

    @Column(name="availableSeats")
    private Long availableSeats;

    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId){this.eventId=eventId;}

}


