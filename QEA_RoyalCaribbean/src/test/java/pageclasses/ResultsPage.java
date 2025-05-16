package pageclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions act;
    // Constructor to initialize WebDriver, WebDriverWait, and PageFactory
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        act=new Actions(driver);
    }
    
    @FindBy(xpath="//button[normalize-space()='Cruise dates']")
    private WebElement cruiseDates;
    
    @FindBy(xpath="//button[text()='Jun']")
    private WebElement month1;
    
    @FindBy(xpath="//button[normalize-space()='Jul']")
    private WebElement month2;
    
    @FindBy(xpath="//button[normalize-space()='Aug']")
    private WebElement month3;	    	 
    		
    @FindBy(xpath="//div[contains(@class,'date-carousel-item-class')]//button[normalize-space()='Sep']")
    private WebElement month4;
    
    @FindBy(xpath="//*[@id=\"filters-content\"]/button[3]")
    private WebElement destinationButton;
    
    @FindBy(xpath="//*[@id=\"destination-card-label-CARIB\"]")
    private WebElement destination;
    
    @FindBy(xpath="(//button[normalize-space()='Departure Port'])[2]")
    private WebElement departure;
    
    @FindBy(xpath="//*[@id=\"departure-port-label-SJU\"]")
    private WebElement port;
    
    @FindBy(xpath="//*[@id=\"filter-modal\"]/section/button")
    private WebElement portResults;
    
    @FindBy(xpath="//*[@id=\"results-dropdown-sort\"]/div[2]/div/button")
    private WebElement sortOption;
    
    @FindBy(xpath="//*[@id=\"results-dropdown-sort\"]/div[2]/div/div/div/ul/li[2]/p")
    private WebElement sortLowToHigh;
    
    @FindBy(className="RefinedCruiseCard-styles__RefinedCruiseCardName-sc-6d5ff48d-4")
    private By list;
    
    
    public void cruiseDatesSelection() {
    	//Selecting 4 months using filter option
    	WebElement dates = wait.until(ExpectedConditions.elementToBeClickable(cruiseDates));
        dates.click();
        WebElement m1 = wait.until(ExpectedConditions.elementToBeClickable(month1));
        act.moveToElement(m1).click().perform();
        WebElement m2 = wait.until(ExpectedConditions.elementToBeClickable(month2));
        m2.click();
        WebElement m3 = wait.until(ExpectedConditions.elementToBeClickable(month3));
        m3.click();
        WebElement m4 = wait.until(ExpectedConditions.elementToBeClickable(month4));
        act.moveToElement(m4).click().perform();
    }
    
//    public void destinationSelection() {
//    	//selecting destination port 
//        WebElement destButton = wait.until(ExpectedConditions.elementToBeClickable(destinationButton));
//        destButton.click();
//        WebElement dest = wait.until(ExpectedConditions.elementToBeClickable(destination));
//        dest.click();
//    }
    
    public void departureSelection() {
    	//selecting departure port
        WebElement dep= wait.until(ExpectedConditions.elementToBeClickable(departure));
       act.moveToElement(dep).click().perform();
        WebElement porT = wait.until(ExpectedConditions.elementToBeClickable(port));
        act.moveToElement(porT).click().perform();
    }
    public void filteringResults() throws InterruptedException {
    	//filtering results from prices lowest to highest
        WebElement portresults = wait.until(ExpectedConditions.elementToBeClickable(portResults));
        act.moveToElement(portresults).click().perform();
        WebElement sortOpt = wait.until(ExpectedConditions.elementToBeClickable(sortOption));
        sortOpt.click();
        WebElement sortLoToH = wait.until(ExpectedConditions.elementToBeClickable(sortLowToHigh));
        sortLoToH.click();
        //retrieving list of cruises available
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("RefinedCruiseCard-styles__RefinedCruiseCardName-sc-6d5ff48d-4")));
        
        System.out.println("Number of Cruises : " + list.size());
        
    }
}
