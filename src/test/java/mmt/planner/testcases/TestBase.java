package mmt.planner.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.MediaEntityBuilder;

import mmt.planner.base.PageBase;
import mmt.planner.utils.ScreenShotUtil;

public class TestBase extends PageBase {

	public TestBase() {
		super();
	}
	
	@BeforeMethod	
	public void setup() {
		initilization();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotUtil.takeScreenShot()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test case passed.");
		}
		driver.quit();		
		report.flush();
	}
	
}
