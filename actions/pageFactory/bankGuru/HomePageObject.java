package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageFactory.bankGuru.AbstractPage;
public class HomePageObject extends AbstractPage {
	WebDriver driver;
	public HomePageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH, using="//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")
	private WebElement welcomeMessageText;
	public boolean isWelcomeMessageDisplayed() {
		waitForElementVisible(driver,welcomeMessageText);
		return isElementDisplayed(driver,welcomeMessageText);
	}
	
}
