package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageFactory.bankGuru.AbstractPage;


public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver mapDriver) {
		this.driver = mapDriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	private WebElement emailTextbox;

	public void inputToEmailTextbox(String value) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, value);

	}

	@FindBy(how = How.XPATH, using = "//input[@ name='btnLogin']")
	private WebElement submitButton;

	public void clickToSubmitButton() {
		waitForElementVisible(driver, submitButton);
		clickToElement(driver, submitButton);

	}

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'User ID')]/following-sibling::td")
	private WebElement userIDText;

	public String getUserIDText() {
		waitForElementVisible(driver, userIDText);
		return getElementText(driver, userIDText);
	}

	public void openLoginPage(String url) {
		openUrl(driver, url);

	}

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Password')]/following-sibling::td")
	private WebElement passwordText;

	public String getPasswordText() {
		waitForElementVisible(driver, passwordText);
		return getElementText(driver, passwordText);
	}

	
}
