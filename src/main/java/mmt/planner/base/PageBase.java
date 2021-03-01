package mmt.planner.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import mmt.planner.utils.ExtentReportManager;
import mmt.planner.utils.WebEventListener;

public class PageBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	public static JavascriptExecutor js;
	public static ExtentReports report; 
	public static ExtentTest logger;
	
	
	
	/*
	 * Base class constructor for initializing the config.properties file
	 * 
	 */
	public PageBase(){
		report= ExtentReportManager.getReportInstance();
		prop= new Properties();
		FileInputStream propInput;
		try {
			propInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mmt\\planner\\config\\config.properties");
			prop.load(propInput);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Static initialize method to instantiate the webdriver with webdriver event listener.
	 */
	
	public static void initilization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			wait= new WebDriverWait(driver, 30);
		}
		else if(browserName.equalsIgnoreCase("other")) {
			
		} 		
		
		eventDriver= new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		eventDriver.register(eventListener);
		driver=eventDriver;
		js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	} 
	
	
	

}
