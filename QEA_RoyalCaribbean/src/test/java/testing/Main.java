package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	
	public static WebDriver driver;
	public static String url="";
	public WebDriver createDriver() {
		
		return driver;
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions act=new Actions(driver);		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalcaribbean.com/alaska-cruises");
		driver.manage().window().maximize();
		
		WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rciSearchHeaderIcon")));		
		search.click();		
		Thread.sleep(1000);
		WebElement searchInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rciSearchInput")));
		searchInput.sendKeys("Rhapsody of the Seas");	
		Thread.sleep(2000);
		WebElement startSearch=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rciSearchInputIcon")));
		startSearch.click();
		Thread.sleep(1000);
		
		WebElement firstResult=wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[3]/div[1]/a[contains(text(),'Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises')]")
			));
		firstResult.click();
		
		WebElement booking=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("promoHeroCTAButton")));
		act.scrollToElement(booking).click(booking).perform();
		WebElement dates=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Cruise dates')]")));
		dates.click();
		
		
		WebElement month1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='May']")));
		act.moveToElement(month1).click(month1).perform();
		Thread.sleep(1000);
		WebElement month2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'][normalize-space()='Jun'])[1]")));
		month2.click();
		Thread.sleep(1000);
		WebElement month3=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'][normalize-space()='Jul'])[1]")));
		month3.click();
		Thread.sleep(1000);
		WebElement month4=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'][normalize-space()='Aug'])[1]")));
		month4.click();
		Thread.sleep(1000);
		WebElement results=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'results')]")));
		results.click();
		Thread.sleep(1000);
		WebElement departure=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Departure Port']")));
		departure.click();
		Thread.sleep(2000);
		WebElement port= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.components__ButtonWrap-sc-6abd413c-1.gBFaFs")));
		System.out.print(port.getText());
		act.moveToElement(port).click(port).perform();
		
		WebElement portResults=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'results')]")));
		portResults.click();
	}

}
