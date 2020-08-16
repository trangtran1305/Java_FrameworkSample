package com.wordpress.login;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Login_02_Multiple_Browser_Parallel extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	String loginPageUrl;
	DashboardPageObject dashboardPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String Value) {
		//lấy thông tin browser trong abstract test 
		driver=getBrowserDriver(Value);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage.openLoginPage(loginPageUrl);
	}

	@Test
	public void Validate_01_EmptyEmail() {
		loginPage.inputToEmailTextBox("");
		loginPage.clickToContinueOrLoginButton();

		Assert.assertEquals(loginPage.getErrorMessage(), "Please enter a username or email address.");

	}

	@Test
	public void Validate_02_InvalidEmail() {

		loginPage.inputToEmailTextBox("123@123.123");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(),
				"Please log in using your WordPress.com username instead of your email address.");
	}

	@Test
	public void Validate_03_EmailNotExist() {

		loginPage.inputToEmailTextBox("automation" + random() + "@gmail.com");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(),
				"User does not exist. Would you like to create a new account?");

	}

	@Test
	public void Validate_04_EmptyPassWord() {

		loginPage.inputToEmailTextBox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextBox("");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(), "Don't forget to enter your password.");
	}

	@Test
	public void Validate_05_PasswordLessThan6Chars() {
		loginPage.inputToEmailTextBox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextBox("1234");
		loginPage.clickToContinueOrLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void Validate_06_ValidPassword() {
		loginPage.inputToEmailTextBox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextBox("automationfc");
		loginPage.clickToContinueOrLoginButton();
		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isHeaderTextDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int random() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

}
