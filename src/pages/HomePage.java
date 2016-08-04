package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {
	WebDriver driver;

	public void startup()
	{
		System.setProperty("webdriver.chrome.driver", "resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.pinterest.com/");
		driver.manage().window().maximize();
	}
	public String goHomePage()
	{
		return driver.getTitle();
	}

	public Boolean logo()
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".InspiredWallSignup__logo")));

		return myDynamicElement.isDisplayed();
	}

	public int links()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List linkcount = driver.findElements(By.xpath("//a[text()='About Pinterest']/../*"));
		return linkcount.size();
	}

	public Boolean faceBookbutton()
	{
		WebElement fbbutton = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-reactid='11']")));
		return fbbutton.isEnabled();
	}


	public Boolean loginfeilds()
	{
		WebElement loginfeilds = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form")));
		return loginfeilds.isDisplayed();
	}

	public Boolean loginbutton()
	{
		WebElement loginbutton = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form")));
		return loginbutton.isEnabled();
	}
	public Boolean signupfeilds()
	{
		WebElement signupfeilds = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form")));
		return signupfeilds.isDisplayed();
	}

	public boolean termsandcondtions()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-reactid='32']")));

		return myDynamicElement.isDisplayed();
	}

	public boolean image()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-reactid='11']")));

		return myDynamicElement.isDisplayed();
	}

	public int footer()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List footercount = driver.findElements(By.xpath("//span[text()='Discover Pinterest:']/following-sibling::a"));
		return footercount.size();
	}


	public void tearDown()
	{
		driver.close();
	}
	
}

