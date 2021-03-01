package mmt.planner.testcases;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import mmt.planner.pages.HomePage;
import mmt.planner.pages.ItinaryPage;
import mmt.planner.utils.ScreenShotUtil;


public class ItinaryPageTest extends TestBase{

	HomePage homePage;
	
	public ItinaryPageTest() {
		super();
	}
	
	
	
	@Test
	public void searchWithCities() throws Exception {
		logger=report.createTest("searchWithCities");
		homePage=new HomePage();
		ItinaryPage itinaryPage=homePage.clickSearchButton();
		itinaryPage.clickViewPrices();
		
		
	}
	
	
	
	
	
}
