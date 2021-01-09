package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.AbstractPageUI;
import pageUI.wordpress.admin.MediaPageUI;

public class MediaPageObject extends AbstractPage {
	WebDriver driver;
	public MediaPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public void clickAddNewButton() {
		waitForElementVisible(driver,MediaPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MediaPageUI.ADD_NEW_BUTTON);
	}
	public boolean areFilesUploadSuccess() {
		waitForElementsInvisible(driver,AbstractPageUI.MEDIA_INPROGRESS_BAR_ICON );
		return true;
	}
	
}
