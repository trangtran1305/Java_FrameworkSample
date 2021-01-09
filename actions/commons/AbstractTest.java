package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	WebDriver driver;
	protected final Log log;
	
	protected AbstractTest() {
		log= LogFactory.getLog(getClass());
	}
	
	public WebDriver getBrowserDriver(String Value, String Url) {
		if (Value.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
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
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {			
			Assert.assertTrue(condition);// kiểm tra nếu condition sai sẽ đánh fail testcase
		} catch (Throwable e) {
			pass = false;
		
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}


	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	
	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);			
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
	
}
