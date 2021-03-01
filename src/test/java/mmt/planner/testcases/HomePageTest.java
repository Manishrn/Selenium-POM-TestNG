package mmt.planner.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import mmt.planner.pages.BookingPage;
import mmt.planner.pages.HomePage;
import mmt.planner.pages.ItinaryPage;
import mmt.planner.utils.ScreenShotUtil;
import mmt.planner.utils.TestDataReader;

public class HomePageTest extends TestBase{

	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@DataProvider
	public Object[][] getCityData(){
		
		Object [][] testdata=TestDataReader.readTestData("Credentials");
		return testdata;
	}

	public void FirstTest() throws InterruptedException {
		
		homePage=new HomePage();
		ItinaryPage itinaryPage=homePage.clickSearchButton();
		itinaryPage.clickViewPrices();
		BookingPage bkPage=itinaryPage.clickBookNow();
		driver.getWindowHandles();
		//driver.switchTo().window("");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		String textToCheck=bkPage.getItinaryText();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		Thread.sleep(5000);
		Assert.assertEquals(textToCheck, "Itinerary");
		bkPage=itinaryPage.clickBookNow();
		
	}
	
@Test(dataProvider="getCityData")
	public void TicketCheckWithData(String fromCity,String toCity) throws Exception {
	logger=report.createTest("TicketCheckWithData test");
		homePage=new HomePage();
		homePage.enterTheCityDetails(fromCity, toCity);
		ItinaryPage itinaryPage=homePage.clickSearchButton();
		itinaryPage.clickViewPrices();
		
	}
	
	
	@Test
	public void searchWithCities() throws Exception {
		logger=report.createTest("searchWithCities");
		homePage=new HomePage();
		ItinaryPage itinaryPage=homePage.clickSearchButton();
		itinaryPage.clickViewPrices();
		itinaryPage.clickMore();
	
		
	}
	
	
}
