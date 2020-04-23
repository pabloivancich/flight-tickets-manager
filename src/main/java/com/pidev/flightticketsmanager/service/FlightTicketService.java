package com.pidev.flightticketsmanager.service;

import com.pidev.flightticketsmanager.model.FlightTicket;
import com.pidev.flightticketsmanager.repository.FlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightTicketService {

    private FlightTicketRepository flightTicketRepository;

    @Autowired
    public FlightTicketService(FlightTicketRepository flightTicketRepository) {
        this.flightTicketRepository = flightTicketRepository;
    }


    public List<FlightTicket> findAllFlightTickets() {
        return flightTicketRepository.findAll();
    }

    public Optional<FlightTicket> findFlightTicketById(Long id) {
        return flightTicketRepository.findById(id);
    }

    public FlightTicket saveFlightTicket(FlightTicket ticket) {
        return flightTicketRepository.save(ticket);
    }


}
