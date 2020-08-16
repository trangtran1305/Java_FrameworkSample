package browserFactory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager
{

	@Override
	protected void createDriver() {
		driver = new FirefoxDriver();
		
	}

}
