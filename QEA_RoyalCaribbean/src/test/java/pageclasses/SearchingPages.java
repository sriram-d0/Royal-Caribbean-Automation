package pageclasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testing.FileUtility;

public class SearchingPages {
		private WebDriver driver;
	    private WebDriverWait wait;
	    private JavascriptExecutor js;
	    private String[] arr;
	    // Constructor to initialize WebDriver, WebDriverWait, and PageFactory
	    public SearchingPages(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.js = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
	    }
	
	    @FindBy(className="notification-banner__section-close")
	    private By popUp;
	    
	    @FindBy(id="rciSearchHeaderIcon")
	    private WebElement searchIcon;
	    
	    @FindBy(id="rciSearchInput")
	    private WebElement searchInput;
	    
		@FindBy(partialLinkText="Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises")
		private WebElement firstResult;
		
		@FindBy(id="promoHeroCTAButton")
		private WebElement booking;
	    
	    @FindBy(tagName="body") 
	    private By bdy;	 
	    
	    
	    public void initateSearch() {
	    	
	        
	        //loacting search icon
	        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
	        search.click();
	        //locating search textbox and initiating search
	        WebElement searchIn = wait.until(ExpectedConditions.visibilityOf(searchInput));
	        searchIn.sendKeys("Rhapsody of the Seas");
	        searchIn.sendKeys(Keys.ENTER);
	        WebElement firstRes = wait.until(ExpectedConditions.elementToBeClickable(firstResult));
	        firstRes.click();
	        WebElement book = wait.until(ExpectedConditions.elementToBeClickable(booking));
	        book.click();
	        
	       // wait.until(ExpectedConditions.presenceOfElementLocated(bdy));
	    }
	    
}
