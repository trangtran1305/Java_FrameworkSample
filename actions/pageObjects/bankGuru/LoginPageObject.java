package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public void clickToHereLink() {
		waitForElementVisible(driver,LoginPageUI.HERE_LINK);
		clickToElement(driver,LoginPageUI.HERE_LINK);
		
	}
	public void inputToUserIdTextbox(String value) {
		waitForElementVisible(driver,LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, value);
	}
	public void inputToPasswordTextbox(String value) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
		
	}
	public void clickToLoginButton() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
	}
	public String getLoginPageUrl() {
		
		return getCurrentUrl(driver);
	}
}
