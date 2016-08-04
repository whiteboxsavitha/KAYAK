package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {
	
	pages.HomePage hp = new pages.HomePage();

	@BeforeTest
	public void setup()
	{
		hp.startup();

	}
	@AfterTest
	public void teardown()
	{
		hp.tearDown();
}

	@Test
public void testpageOpened()
{
	String Actual =hp.goHomePage();
	String Expected = "Pinterest • The world’s catalog of ideas";
 	assertEquals(Actual, Expected);
 }
	@Test
	public void testLogo()
	{
		Boolean Actual =hp.logo();
		assertTrue(Actual);
	}
	@Test
	public void testlinks()
	{
		int Actual =hp.links();
		assertEquals(7, Actual);
	}

	@Test
	public void testimage()
	{
		Boolean Actual =hp.image();
		assertTrue(Actual);
	}


	@Test
	public void testfooter()
	{
		int Actual =hp.footer();
		assertEquals(11, Actual);
	}

}
