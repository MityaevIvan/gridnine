package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filter {
    public List<Flight> untilNow(List <Flight> list){
        List<Flight> filteredFlightList = new ArrayList<Flight>();
        for (int i = 0; i < list.size(); i++){
                if (!(list.get(i).getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now()))){
                    filteredFlightList.add(list.get(i));
            }
        }
        return filteredFlightList;
   }

   public Set<Flight> arriveBeforeDeparture(List<Flight> list){
        Set<Flight> filteredFlightSet = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSegments().size() < 2) {
                if (!(list.get(i).getSegments().get(0).getDepartureDate().isAfter(list.get(i).getSegments().get(0).getArrivalDate()))) {
                    filteredFlightSet.add(list.get(i));
                }
            }
        }
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getSegments().size() > 1){
                for (int j = 0; j < list.get(i).getSegments().size(); j++){
                    if (!(list.get(i).getSegments().get(j).getDepartureDate().isAfter(list.get(i).getSegments().get(j).getArrivalDate()))){
                        filteredFlightSet.add(list.get(i));
                    }
                }
            }

        }
        return filteredFlightSet;
   }

   public Set<Flight> groundTime (List<Flight> list) {
       Set<Flight> filteredFlightSet = new HashSet<>();
       for (int i = 0; i < list.size(); i++) {
           if (list.get(i).getSegments().size() > 1) {
               for (int j = 0; j < list.get(i).getSegments().size() - 1; j++) {
                   if (!(Math.abs(list.get(i).getSegments().get(j).getArrivalDate().getHour() - list.get(i).getSegments().get(j + 1).getDepartureDate().getHour()) > 2)) {
                       filteredFlightSet.add(list.get(i));
                   }
               }
           }
       }
       return filteredFlightSet;
   }}




