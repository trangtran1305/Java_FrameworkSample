package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

import pageUI.bankGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver mapDriver) {
		this.driver = mapDriver;
	}

	public void inputToEmailTextbox(String value) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, value);

	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);

	}

	public String getUserIDText() {
		waitForElementVisible(driver, RegisterPageUI.USERID_TEXT);
		return getElementText(driver, RegisterPageUI.USERID_TEXT);
	}

	public void openLoginPage(String url) {
		openUrl(driver, url);

	}

	public String getPasswordText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_TEXT);
	}
}
