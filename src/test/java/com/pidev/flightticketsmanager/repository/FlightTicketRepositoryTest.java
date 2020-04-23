package com.pidev.flightticketsmanager.repository;

import com.pidev.flightticketsmanager.model.FlightTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FlightTicketRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FlightTicketRepository flightTicketRepository;


    @Test
    public void testFindAll() {
        FlightTicket ticket = createFlightTicket();
        FlightTicket otherTicket = createFlightTicket();

        entityManager.persist(ticket);
        entityManager.persist(otherTicket);

        entityManager.flush();

        List<FlightTicket> tickets = flightTicketRepository.findAll();

        assertNotNull(tickets);
        assertThat(tickets.size()).isEqualTo(2);
    }

    @Test
    public void testFindByIdOK() {
        FlightTicket ticket = createFlightTicket();

        FlightTicket savedTicket = entityManager.persist(ticket);
        entityManager.flush();

        FlightTicket ticketFound = flightTicketRepository.findById(savedTicket.getId()).get();

        assertNotNull(ticketFound);
        assertThat(ticketFound.getPassengerName()).isEqualTo(ticket.getPassengerName());
    }

    @Test
    public void testFindByIdNotFound() {
        boolean ticketFound = flightTicketRepository.findById(500L).isPresent();
        assertFalse(ticketFound);
    }

    @Test
    public void testSave() {
        FlightTicket ticket = createFlightTicket();

        FlightTicket newTicket = flightTicketRepository.save(ticket);

        assertNotNull(newTicket);
    }


    private FlightTicket createFlightTicket() {
        FlightTicket ticket = new FlightTicket();
        ticket.setPassengerName("Pablo I");
        ticket.setPassengerAge(32);
        ticket.setPrice(100);
        ticket.setLuggage(true);
        ticket.setOriginCity("BUE");
        ticket.setDestinationCity("BAR");
        ticket.setDepartureDate(LocalDate.now());
        ticket.setArrivalDate(LocalDate.now());
        ticket.setDepartureTime(LocalTime.now());
        ticket.setArrivalTime(LocalTime.now().plusHours(3));

        return ticket;
    }



}
