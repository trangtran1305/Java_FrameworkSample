package pageObjects.wordpress;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PagesPageObject extends AbstractPage {
	WebDriver driver;
	public PagesPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}

}
