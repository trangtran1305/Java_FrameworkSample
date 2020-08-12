package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.PageGeneratorManager;
import pageFactory.bankGuru.AbstractPage;
public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver mapDriver) {
		this.driver = mapDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='here']")
	private WebElement hereLink;

	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver, hereLink);
		clickToElement(driver, hereLink);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='uid']")
	private WebElement userIDTextbox;

	public void inputToUserIdTextbox(String value) {
		waitForElementVisible(driver, userIDTextbox);
		sendKeyToElement(driver, userIDTextbox, value);
	}
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	private WebElement passwordTextbox;
	public void inputToPasswordTextbox(String value) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver,  passwordTextbox, value);

	}
	@FindBy(how=How.XPATH, using="//input[@name='btnLogin']")
	private WebElement loginButton;
	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, loginButton);
		clickToElement(driver, loginButton);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getLoginPageUrl() {

		return getCurrentUrl(driver);
	}


}
