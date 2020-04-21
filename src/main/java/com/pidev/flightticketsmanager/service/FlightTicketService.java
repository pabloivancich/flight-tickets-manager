package com.pidev.flightticketsmanager.service;

import com.pidev.flightticketsmanager.model.FlightTicket;
import com.pidev.flightticketsmanager.repository.FlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightTicketService {

    private FlightTicketRepository flightTicketRepository;


    @Autowired
    public FlightTicketService(FlightTicketRepository flightTicketRepository) {
        this.flightTicketRepository = flightTicketRepository;
    }

    public FlightTicket findFlightTicketById(int id) {
        return flightTicketRepository.findFlightTicketById(id);
    }

    public FlightTicket saveFlightTicket(FlightTicket ticket) {
        return flightTicketRepository.saveFlightTicket(ticket);
    }


}
