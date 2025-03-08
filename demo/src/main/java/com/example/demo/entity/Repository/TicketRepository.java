package com.example.demo.entity.Repository;
import com.example.demo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
