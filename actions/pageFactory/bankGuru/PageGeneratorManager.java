package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
