package MainClasses;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclasses.ResultsPage;
import pageclasses.SearchingPages;

public class TestClass extends BaseClass{
	SearchingPages searchPage;
	ResultsPage resultPage;
	@BeforeClass
	public void setUp() {
   	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       searchPage = new SearchingPages(driver);
       resultPage = new ResultsPage(driver);
   }
	
	@Test(priority=1)
	public void searchInitiation() {
		searchPage.initateSearch();
	}
	
	@Test(priority=2)
	public void datesSelection() {
		resultPage.cruiseDatesSelection();
	}
	
//	@Test(priority=3)
//	public void destSelection() {
//		resultPage.destinationSelection();
//	}
//	
	@Test(priority=3)
	public void depSelection() {
		resultPage.departureSelection();
	}
	
	@Test(priority=4)
	public void resultFiltering() throws InterruptedException {
		resultPage.filteringResults();
	}
	
	@AfterClass
	public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
