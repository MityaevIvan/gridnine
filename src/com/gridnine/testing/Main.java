package com.gridnine.testing;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights(); //creating list of Flights

        Filter filter = new Filter();

        List<Flight> untilNowFlightlist = filter.untilNow(flights); // Task #1
        for (Flight f : untilNowFlightlist){
            System.out.println(f);
        }

        System.out.println();


        Set<Flight> arriveBeforeDepartureFlightList = filter.arriveBeforeDeparture(flights); // Task #2
        for (Flight f : arriveBeforeDepartureFlightList){
            System.out.println(f);
        }

        System.out.println();

        Set<Flight> moreThanTwoGroundHours = filter.groundTime(flights); // Task #3
        for (Flight f : moreThanTwoGroundHours){
            System.out.println(f);
        }
    }
}
