package mmt.planner.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import mmt.planner.base.PageBase;

public class ScreenShotUtil extends PageBase {

	public static String takeScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir")+"./Screenshots/"+ScreenShotUtil.getCurrentDateTime()+".png";
		try {
			FileHandler.copy(source,new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenShotPath;
	}
	
	
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy_hh_mm_ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}

}
