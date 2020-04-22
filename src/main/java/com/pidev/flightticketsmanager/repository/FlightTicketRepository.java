package com.pidev.flightticketsmanager.repository;

import com.pidev.flightticketsmanager.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightTicketRepository extends JpaRepository<FlightTicket, Long> {

}
