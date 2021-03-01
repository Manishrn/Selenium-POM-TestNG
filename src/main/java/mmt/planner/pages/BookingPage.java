package mmt.planner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mmt.planner.base.PageBase;

public class BookingPage extends PageBase{

	@FindBy(xpath="//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div[1]/p")
	WebElement itinary_Text;
	
	public BookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getItinaryText() {
		String itinaryText=null;
		wait.until(ExpectedConditions.visibilityOf(itinary_Text));
		itinary_Text.isDisplayed();
		itinaryText=itinary_Text.getText();
		return itinaryText;
	}
	
}
