package com.pidev.flightticketsmanager.controller;


import com.pidev.flightticketsmanager.model.FlightTicket;
import com.pidev.flightticketsmanager.service.FlightTicketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FlightTicketController.class)
public class FlightTicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightTicketService flightTicketService;


    @Test
    public void testFindAllFlightTicketsOK() throws Exception {
        FlightTicket ticket = new FlightTicket();
        ticket.setId(1);
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

        FlightTicket otherTicket = new FlightTicket();
        otherTicket.setId(2);
        otherTicket.setPassengerName("Kari I");
        otherTicket.setPassengerAge(32);
        otherTicket.setPrice(100);
        otherTicket.setLuggage(true);
        otherTicket.setOriginCity("BUE");
        otherTicket.setDestinationCity("BAR");
        otherTicket.setDepartureDate(LocalDate.now());
        otherTicket.setArrivalDate(LocalDate.now());
        otherTicket.setDepartureTime(LocalTime.now());
        otherTicket.setArrivalTime(LocalTime.now().plusHours(3));

        List<FlightTicket> tickets = Arrays.asList(ticket, otherTicket);

        given(flightTicketService.findAllFlightTickets()).willReturn(tickets);

        mockMvc.perform(get("/flighttickets/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFlightTicketOK() throws Exception {
        FlightTicket ticket = new FlightTicket();
        ticket.setId(1);
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

        given(flightTicketService.findFlightTicketById(1L)).willReturn(Optional.of(ticket));

        mockMvc.perform(get("/flighttickets/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));;
    }

    @Test
    public void testFindFlightTicketNotFound() throws Exception {
        given(flightTicketService.findFlightTicketById(1L)).willReturn(Optional.empty());

        mockMvc.perform(get("/flighttickets/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testSaveFlightTicket() throws Exception {
        // TODO implement this test!!
    }


}
