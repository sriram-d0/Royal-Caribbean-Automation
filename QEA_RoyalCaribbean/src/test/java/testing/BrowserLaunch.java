package testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {
	
	public static WebDriver driverLaunch() throws IOException {
		WebDriver driver;
		FileInputStream fi = new FileInputStream("C:\\Users\\2393054\\eclipse-workspace\\QEA_RoyalCaribbean\\src\\test\\java\\testing\\config.properties");
		Properties props=new Properties();
		props.load(fi);
		String browserName=props.getProperty("browser");
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
		}
		return driver;
	}
}
