package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Savi on 7/17/2016.
 */
public class FlightPageTest {

    pages.FiightsPage fp = new pages.FiightsPage();

    @Test
    public void flightPageTitleTest()
    {
        String Actual =fp.flightPageTitle();
        System.out.println("ACTUAL" + Actual);
        String Expected = "Find Cheap Flights & Airline Tickets | KAYAK";
        fp.tearDown();
        assertEquals(Actual, Expected);

    }
    @Test
    public void searchRoundTripFlightTest()
    {
       Boolean Actual = fp.searchRoundTripFlight();
        //System.out.println("ACTUAL" + Actual);
        //String Expected = "07/18/2016";
        fp.tearDown();
        assertTrue(Actual);

    }
}
