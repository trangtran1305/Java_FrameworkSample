package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MediaPageObject extends AbstractPage {
	WebDriver driver;
	public MediaPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	
}
