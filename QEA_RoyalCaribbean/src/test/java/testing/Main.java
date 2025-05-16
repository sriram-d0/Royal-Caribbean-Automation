package testing;
//importing necessary packages
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
	
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions act;
    public static String[] arr;
    
    public WebDriver createDriver() throws IOException {  
    	//Selecting Driver
		driver=BrowserLaunch.driverLaunch();
		//Creating wait and actions class
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        act = new Actions(driver);
		return driver;
    }
    
    public void openUrl(String url) {
    	//Navigating to url and maximizing the window
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public void excelData() throws IOException {
    	//reading input data from excel
    	arr=FileUtility.readExcel("C:\\Users\\2393054\\eclipse-workspace\\QEA_RoyalCaribbean\\data\\testdata.xlsx");
    	//System.out.print(Arrays.toString(arr));
    }
    
    public void initateSearch() {
    	//handling pop-up while entering into home page
        try {
            WebElement banner = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("notification-banner__section-close")));
            banner.click();
        } catch (Exception e) {
            System.out.println("Banner not found or already closed.");
        }
        //loacting search icon
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("rciSearchHeaderIcon")));
        search.click();
        //locating search textbox and initiating search
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rciSearchInput")));
        //System.out.print(arr[0].trim());
        searchInput.sendKeys(arr[0].trim());
        searchInput.sendKeys(Keys.ENTER);
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(
                By.partialLinkText(arr[1].trim())));
        firstResult.click();
        WebElement booking = wait.until(ExpectedConditions.elementToBeClickable(By.id("promoHeroCTAButton")));
        booking.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }
    
    public void cruiseDatesSelection() {
    	//Selecting 4 months using filter option
    	WebElement dates = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='" + arr[2].trim() + "']")));
        dates.click();
        WebElement month1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='" + arr[3].trim() + "']")));
        act.moveToElement(month1).click().perform();
        WebElement month2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='"+arr[4].trim()+"']")));
        month2.click();
        WebElement month3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='"+arr[5].trim()+"']")));
        month3.click();
        WebElement month4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'date-carousel-item-class')]//button[normalize-space()='"+arr[6].trim()+"']")));
        act.moveToElement(month4).click().perform();
    }
    
    public void destinationSelection() {
    	//selecting destination port 
        WebElement destinationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='"+arr[7].trim()+"'])[2]")));
        act.moveToElement(destinationButton).click().perform();
        WebElement destination = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'"+arr[8].trim()+"')]")));
        act.moveToElement(destination).click().perform();
    }
    
    public void departureSelection() {
    	//selecting departure port
        WebElement departure = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='"+arr[9].trim()+"'])[2]")));
        act.moveToElement(departure).click().perform();
        WebElement port = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'"+arr[10].trim()+"')]")));
        act.moveToElement(port).click().perform();
    }
    
    public void filteringResults() throws InterruptedException {
    	//filtering results from prices lowest to highest
        WebElement portresults = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='"+arr[11].trim()+"']")));
        act.moveToElement(portresults).click().perform();
        WebElement sortOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"results-dropdown-sort\"]/div[2]/div/button")));
        sortOption.click();
        WebElement sortLowToHigh = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"results-dropdown-sort\"]/div[2]/div/div/div/ul/li[2]/p")));
        sortLowToHigh.click();
        //retrieving list of cruises available
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("RefinedCruiseCard-styles__RefinedCruiseCardName-sc-6d5ff48d-4")));
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("RefinedCruiseCard-styles__RefinedCruiseCardName-sc-6d5ff48d-4")));
        act.scrollToElement(ele).perform();
        
        System.out.println("Number of Cruises : " + list.size());
        Thread.sleep(1000);
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        Main m = new Main();
        WebDriver driver = m.createDriver();        
        m.openUrl("https://www.royalcaribbean.com/alaska-cruises");
        m.excelData();
        m.initateSearch();
        m.cruiseDatesSelection();
        m.destinationSelection();
        m.departureSelection();
        m.filteringResults();
        driver.quit();
    }
}
