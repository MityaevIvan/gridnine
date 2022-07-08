package com.gridnine.testing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FilterTest {
    private static List<Flight> testFlightsList;
    private static Filter filter = new Filter();

    @BeforeClass
    public static void createTestFlights(){
        testFlightsList = FlightBuilder.createFlights();
    }

    @Test
    public void methodUntilNowShouldNotContainFlightsBeforeCurrentTime() {
        List<Flight> untilNowFlightsList = filter.untilNow(testFlightsList);
        Assert.assertEquals(5, untilNowFlightsList.size());
    }

    @Test(timeout = 1000)
    public void methodArriveBeforeDepartureShouldWorkFasterThanOneSecond()  {
        Set<Flight> arriveBeforeDeparture = filter.arriveBeforeDeparture(testFlightsList);
    }

    @Test
    public void methodGroundTimeShouldNotReturnNulls(){
        Set<Flight> groundTime = filter.groundTime(testFlightsList);
        for (Flight f : groundTime){
            Assert.assertNotNull(f);
        }
    }
}