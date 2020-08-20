package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	WebDriver driver;

	public WebDriver getBrowserDriver(String Value, String Url) {
		if (Value.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Value.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		driver.get(Url);
		return driver;
	}
	
}
