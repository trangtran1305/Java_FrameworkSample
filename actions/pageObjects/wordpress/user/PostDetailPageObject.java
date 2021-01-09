package pageObjects.wordpress.user;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.user.PostDetailPageUI;

public class PostDetailPageObject extends AbstractPage {
	WebDriver driver;
	public PostDetailPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public boolean isCategoryNameDisplayed(String category) {
		waitForElementVisible(driver,PostDetailPageUI.DYNAMIC_CATEGORIES,category);
		return isElementDisplayed(driver,PostDetailPageUI.DYNAMIC_CATEGORIES,category);
	}
	public boolean isTitleNameDisplayed(String title) {
		waitForElementVisible(driver,PostDetailPageUI.DYNAMIC_TITLE,title);
		return isElementDisplayed(driver,PostDetailPageUI.DYNAMIC_TITLE,title);
	}
	public boolean isImageNameDisplayed(String image) {
		waitForElementVisible(driver,PostDetailPageUI.DYNAMIC_IMAGE,image);
		return isElementDisplayed(driver,PostDetailPageUI.DYNAMIC_IMAGE,image);
	}
	public boolean isContentNameDisplayed(String content) {
		waitForElementVisible(driver,PostDetailPageUI.DYNAMIC_CONTENT,content);
		return isElementDisplayed(driver,PostDetailPageUI.DYNAMIC_CONTENT,content);
	}
	public boolean isDateCreatedDisplayed(String date) {
		waitForElementVisible(driver,PostDetailPageUI.DYNAMIC_DATE,date);
		return isElementDisplayed(driver,PostDetailPageUI.DYNAMIC_DATE,date);
	}
	public boolean isAuthorNameDisplayed(String author) {
		waitForElementVisible(driver,PostDetailPageUI.DYNAMIC_AUTHOR,author);
		return isElementDisplayed(driver,PostDetailPageUI.DYNAMIC_AUTHOR,author);
	}
	
}
