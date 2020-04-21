package com.pidev.flightticketsmanager.model;

import jdk.jfr.DataAmount;

import java.util.Date;

//@Entity
public class FlightTicket {

    /*
            i. Departure Date
            ii. Arrival Date
            iii. City Of Origin
            iv. Destination City
            v. Passenger Name
            vi. Passenger Age
            vii. It has a luggage storage
            viii. Price
            ix. Departure Time
            x. Arrival Time
     */
    //@Id
    //@GeneratedValue
    private Long id;
    private String passengerName;
    private Integer passengerAge;
    private Integer price;
    private Boolean luggage;
    private Date departure;
    private Date arrival;

    public FlightTicket() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getPassengerAge() {
        return this.passengerAge;
    }

    public void setPassengerAge(Integer passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getLuggage() {
        return this.luggage;
    }

    public void setLuggage(Boolean luggage) {
        this.luggage = luggage;
    }

    public Date getDeparture() {
        return this.departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return this.arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

}
