package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.DashboardPageUI;

public class DashboardPageObject extends AbstractPage{
	WebDriver driver;
	public DashboardPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public boolean isHeaderTextDisplay() {
		return isElementDisplayed(driver, DashboardPageUI.HEADER_TEXT);
	}
}
