package com.pidev.flightticketsmanager.controller;

import com.pidev.flightticketsmanager.model.FlightTicket;
import com.pidev.flightticketsmanager.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/flighttickets")
public class FlightTicketController {

    private FlightTicketService flightTicketService;

    @Autowired
    public FlightTicketController(FlightTicketService flightTicketService) {
        this.flightTicketService = flightTicketService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public FlightTicket getFlightTicket(@PathVariable Long id) {
        return flightTicketService.findFlightTicketById(id).get();
    }

    @PostMapping(value = "/")
    public FlightTicket saveFlightTicket(@RequestBody FlightTicket ticket) {
        return flightTicketService.saveFlightTicket(ticket);
    }


}
