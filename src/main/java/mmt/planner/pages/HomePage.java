package mmt.planner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mmt.planner.base.PageBase;

public class HomePage extends PageBase{

	@FindBy(xpath="//*[@id=\"root\"]//a[text()='Search']")
	WebElement search_Btn;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div/div/nav/ul/li[10]/a")
	WebElement more_txt;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[2]/ul/li[2]")
	WebElement student_txt;
	
	@FindBy(xpath="//*[@id=\"fromCity\"]")
	WebElement fromCity_Input;
	
	@FindBy(xpath="//*[@id=\"toCity\"]")
	WebElement toCity_Input;
	
	@FindBy(xpath="(//*[@role=\"listbox\"]//p[contains(text(),'Pune, India')])[1]")
	WebElement puneCity_Input;
	
	@FindBy(xpath="(//*[@role=\"listbox\"]//p[contains(text(),'Mumbai, India')])[1]")
	WebElement mumbaiCity_Input;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public ItinaryPage clickSearchButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(search_Btn));
		Thread.sleep(5000);
		search_Btn.isEnabled();
		 js.executeScript("arguments[0].click();", search_Btn);
		//search_Btn.click();
		return new ItinaryPage();
	}
	
	public void enterTheCityDetails(String from,String to) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(fromCity_Input));
		fromCity_Input.isDisplayed();		
		fromCity_Input.sendKeys(from);
		Thread.sleep(5000);
		puneCity_Input.isDisplayed();
		puneCity_Input.click();
		wait.until(ExpectedConditions.visibilityOf(toCity_Input));
		toCity_Input.isDisplayed();
		toCity_Input.sendKeys(to);
		Thread.sleep(5000);
		mumbaiCity_Input.isDisplayed();
		mumbaiCity_Input.click();
	}
	
}
