package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	public static MediaPageObject getMediaPage(WebDriver driver) {
		return new MediaPageObject(driver);
	}
	public static PostPageObject getPostPage(WebDriver driver) {
		return new PostPageObject(driver);
	}
	public static PagesPageObject getPagesPage(WebDriver driver) {
		return new PagesPageObject(driver);
	}
	
}
