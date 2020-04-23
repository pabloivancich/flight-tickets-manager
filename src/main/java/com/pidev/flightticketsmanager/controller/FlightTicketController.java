package com.pidev.flightticketsmanager.controller;

import com.pidev.flightticketsmanager.model.FlightTicket;
import com.pidev.flightticketsmanager.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/flighttickets")
public class FlightTicketController {

    private FlightTicketService flightTicketService;

    @Autowired
    public FlightTicketController(FlightTicketService flightTicketService) {
        this.flightTicketService = flightTicketService;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightTicket> findAllFlightTickets() {
        return flightTicketService.findAllFlightTickets();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightTicket> findFlightTicket(@PathVariable Long id) {
        return flightTicketService.findFlightTicketById(id).isPresent()
                ? ResponseEntity.ok(flightTicketService.findFlightTicketById(id).get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightTicket saveFlightTicket(@RequestBody FlightTicket ticket) {
        return flightTicketService.saveFlightTicket(ticket);
    }


}
