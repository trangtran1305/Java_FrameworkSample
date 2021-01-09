package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	public LoginPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public void inputToEmailTextBox(String value) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX );
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);
	}

	public void inputToPasswordTextBox(String value) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX );
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
	}

	public DashboardPageObject clickToContinueOrLoginButton() {
		waitForElementVisible(driver,LoginPageUI.CONTINUE_BUTTON );
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getDashboardAdminPage(driver);
	}

	public String getErrorMessage() {
		waitForElementVisible(driver,LoginPageUI.ERROR_MESSAGE );
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE);
	}
	public void openLoginPage(String url) {
		openUrl(driver, url);
	}
	public String getLoginPageUrl() {
	return getCurrentUrl(driver);
	}
	
}
