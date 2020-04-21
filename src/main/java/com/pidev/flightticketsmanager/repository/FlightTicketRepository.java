package com.pidev.flightticketsmanager.repository;

import com.pidev.flightticketsmanager.model.FlightTicket;
import org.springframework.stereotype.Repository;

@Repository
public class FlightTicketRepository {


    public FlightTicket findFlightTicketById(int id) {
        FlightTicket ticket = new FlightTicket();
        ticket.setId(Long.valueOf(id));

        return ticket;
    }

    public FlightTicket saveFlightTicket(FlightTicket ticket) {
        ticket.setId(ticket.getId());
        return ticket;
    }

}
