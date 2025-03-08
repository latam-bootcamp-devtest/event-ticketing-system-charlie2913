package com.example.demo.dto;

import java.time.LocalDate;

public class EventDto {
    private Long EventId;
    private String name;
    private LocalDate date;
    private Long availableSeats;

    public EventDto(Long eventId, String name, LocalDate date, Long availableSeats) {
    }
}
