package browserFactory;

public class DriverFactory {
	public static DriverManager getDriverManager(String browserName) {
		DriverManager driverManager;
		switch (browserName) {
		case "chrome":
			driverManager = new ChromeDriverManager();
			break;
		default:
			driverManager = new FirefoxDriverManager();
			break;
		}
		return driverManager;
	}
}
