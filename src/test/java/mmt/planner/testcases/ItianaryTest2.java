package mmt.planner.testcases;

import org.testng.annotations.Test;

import mmt.planner.pages.HomePage;
import mmt.planner.pages.ItinaryPage;

public class ItianaryTest2 extends TestBase{

	public ItianaryTest2() {
		super();
	}
	
	@Test
	public void searchWithCities() throws Exception {
		logger=report.createTest("searchWithCities");
		HomePage homePage = new HomePage();
		ItinaryPage itinaryPage=homePage.clickSearchButton();
		itinaryPage.clickViewPrices();
		
		
	}
}
