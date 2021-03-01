package mmt.planner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mmt.planner.base.PageBase;

public class ItinaryPage extends PageBase{
	
	@FindBy(xpath="(//*[contains(@id,\"bookbutton\")])[1]")
	WebElement viewPrice_Txt;
	
	@FindBy(xpath="(//button[contains(text(),'Book Now')])[1]")
	WebElement bookNow_Btn;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div/div/nav/ul/li[10]/a")
	WebElement more_txt;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div/div/nav/ul/li[10]/div/a[3]")
	WebElement listElement;

	public ItinaryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickViewPrices() {
		wait.until(ExpectedConditions.visibilityOf(viewPrice_Txt));
		viewPrice_Txt.isEnabled();
		viewPrice_Txt.click();
		
	}
	
	public BookingPage clickBookNow() {
		wait.until(ExpectedConditions.visibilityOf(bookNow_Btn));
//		bookNow_Btn.isEnabled();
//		bookNow_Btn.click();
		js.executeScript("arguments[0].click();", bookNow_Btn);
		return new BookingPage();
	}
	
	
	public void clickMore() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(more_txt));
		Thread.sleep(5000);
		more_txt.isEnabled();
		Actions moveToMore= new Actions(driver);
		moveToMore.moveToElement(more_txt).build().perform();
		wait.until(ExpectedConditions.visibilityOf(listElement));
		Thread.sleep(2000);
		listElement.isEnabled();
		listElement.click();
		Thread.sleep(15000);
		
	}
}
