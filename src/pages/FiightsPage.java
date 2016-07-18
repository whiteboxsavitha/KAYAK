package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by Savi on 7/17/2016.
 */
public class FiightsPage {
    WebDriver driver;
    //  String autosuggestionList = "";
    private By autosuggestion = By.xpath(".//div[@id='smartbox']/ul/li");
    private By origin = By.name("origin");
    private By destination = By.name("destination");
    private By startDate = By.xpath(".//*[@id='travel_dates-start']");
    private By returnDate = By.xpath(".//*[@id='datepicker']/div[4]/span[2]/span[2]/span[3]/span[5]/span");
    private By travelers = By.xpath((".//*[@id='travelers']/a"));

    public String flightPageTitle() {
        System.setProperty("webdriver.chrome.driver", "resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kayak.com/flights");
        driver.manage().window().maximize();

        String title = driver.getTitle();


        return title;
    }

    public Boolean searchRoundTripFlight() {
        System.setProperty("webdriver.chrome.driver", "resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kayak.com/flights");
        //  driver.manage().window().maximize();
        WebElement myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(origin));

        Actions action = new Actions(driver);
    //TO Field
        myDynamicElement.click();
    myDynamicElement.clear();
    myDynamicElement.sendKeys("SF");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



        WebElement e = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ap-SFA/48573']")));
// To click on the element
        action.moveToElement(e).click().perform();

        //Destination Feild
        myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(destination));
        myDynamicElement.sendKeys("ny");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        e = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ap-NYC/15830']")));
// To click on the element
        action.moveToElement(e).click().perform();

        //Start date
        myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(startDate));
            myDynamicElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        e = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='datepicker']/div[3]/span[2]/span[2]/span[5]/span[6]/span")));
// To click on the element
        action.moveToElement(e).click().perform();

        //Return date
        myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(returnDate));
        myDynamicElement.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        e = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='datepicker']/div[4]/span[2]/span[2]/span[3]/span[5]/span")));
// To click on the element
        action.moveToElement(e).click().perform();

//Travelers

        myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(travelers));
        myDynamicElement.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        e = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='travelers-Adults']/button[2]")));
// To click on the element
        action.moveToElement(e).click().click().perform();

        myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='fdimgbutton']")));
        String previous = driver.getWindowHandle();

        myDynamicElement.click();
      //  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        Iterator<String> handles = driver.getWindowHandles().iterator();
        while(handles.hasNext()){
            String child = handles.next();
            driver.switchTo().window(child);
        }
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        WebElement er =  (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inlinesearchblock']")));
        if(er.isDisplayed())
        return true;
        else
            return true;
    }

/*
    public void selectOptionWithIndex(int indexToSelect) {

        try {
            WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
            wait.until(ExpectedConditions.visibilityOf(autoOptions));

            List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
            if(indexToSelect<=optionsToSelect.size()) {
                System.out.println("Trying to select based on index: "+indexToSelect);
                optionsToSelect.get(indexToSelect).click();
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
*/

    public void tearDown()
    {
        driver.close();
    }

}
