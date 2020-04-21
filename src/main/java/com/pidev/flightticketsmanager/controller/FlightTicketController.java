package com.pidev.flightticketsmanager.controller;

import com.pidev.flightticketsmanager.model.FlightTicket;
import com.pidev.flightticketsmanager.repository.FlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/flighttickets")
public class FlightTicketController {

    @Autowired
    private FlightTicketRepository repository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public FlightTicket getFlightTicket(@PathVariable int id) {
        return repository.findFlightTicketById(id);
    }

    @PostMapping(value = "/")
    public FlightTicket saveFlightTicket(@RequestBody FlightTicket ticket) {
        return repository.saveFlightTicket(ticket);
    }




}
