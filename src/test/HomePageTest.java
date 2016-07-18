package test;

import pages.HomePage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class HomePageTest {
	
	pages.HomePage hp = new pages.HomePage();
	
@Test
public void seepageOpened()
{
	String Actual =hp.goHomePage();
	System.out.println("ACTUAL" + Actual);
	String Expected = "Search Flights, Hotels & Rental Cars | KAYAK";
    hp.tearDown();
	assertEquals(Actual, Expected);
 }

}
