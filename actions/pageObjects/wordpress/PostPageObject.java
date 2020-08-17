package pageObjects.wordpress;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PostPageObject extends AbstractPage {
	WebDriver driver;
	public PostPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	
}
