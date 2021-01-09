package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver,LoginPageUI.HERE_LINK);
		clickToElement(driver,LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}
	public void inputToUserIdTextbox(String value) {
		waitForElementVisible(driver,LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, value);
	}
	public void inputToPasswordTextbox(String value) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
		
	}
	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	public String getLoginPageUrl() {
		
		return getCurrentUrl(driver);
	}
}
