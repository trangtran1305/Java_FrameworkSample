package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;

	public DashboardPageObject(WebDriver mapDriver) {
		this.driver = mapDriver;
	}

	public boolean isHeaderTextDisplay() {
		return isElementDisplayed(driver, DashboardPageUI.HEADER_TEXT);
	}

	public void clickScreenOptionsButton() {
		waitForElementVisible(driver, DashboardPageUI.SELECT_OPTIONS_BUTTON);
		clickToElement(driver, DashboardPageUI.SELECT_OPTIONS_BUTTON);
		sleepInSeconds(3);
	}

	public boolean isActivityCheckboxDisplay() {
		
		
		return isElementDisplayed(driver,DashboardPageUI.ACTIVITY_CHECKBOX );
	}

	public boolean isAllPostsMenuDisplay() {
		
		return isElementDisplayed(driver,DashboardPageUI.ALL_POSTS_MENU);
	}

	public boolean isPlansMenuUndisplay() {
	return isElementUndisplayed(driver,DashboardPageUI.PLANS_MENU);
		
	}

}
