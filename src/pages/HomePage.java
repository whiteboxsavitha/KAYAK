package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {
	WebDriver driver;
	public String goHomePage()
	{
		  System.setProperty("webdriver.chrome.driver", "resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.kayak.com/");
		driver.manage().window().maximize();
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("FLIGHT")));

		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String title = driver.getTitle();
	
		System.out.println(title);
	//	WebElement flight = driver.findElement(By.xpath(".//*[@id='cCiv']"));
		myDynamicElement.click();
		System.out.println(title);
		return title;
	}

	public void tearDown()
	{
		driver.close();
	}
	
}
