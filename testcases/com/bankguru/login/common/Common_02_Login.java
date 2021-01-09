package com.bankguru.login.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Common_02_Login extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String Value) {
		driver=getBrowserDriver(Value,"http://demo.guru99.com/v4");
		loginPage = new LoginPageObject(driver);		
		loginPage.inputToUserIdTextbox(Common_01_Register.userID);
		loginPage.inputToPasswordTextbox(Common_01_Register.password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	
	}

	@Test
	public void TC_01() {
		
	}
	@Test
	public void TC_02() {
		
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


	public int random() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

}
