package com.bankguru.login.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Common_01_Register extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	public static String userID;
	public static String password;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String Value) {
		driver=getBrowserDriver(Value,"http://demo.guru99.com/v4");
		loginPage = new LoginPageObject(driver);		
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToEmailTextbox("johndeep" + random() + "@gmail.com");
		registerPage.clickToSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
		driver.quit();
	
	}	
	
	@AfterTest(alwaysRun=true) //luôn chạy qua AfterTest nếu ở trên có bị fail
	public void afterClass() {
		//driver.quit(); chỉ tắt browser, không tắt driver
		closeBrowserAndDriver(driver);
	}
	public int random() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

}
