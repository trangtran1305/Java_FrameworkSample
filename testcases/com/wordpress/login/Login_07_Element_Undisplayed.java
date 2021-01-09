package com.wordpress.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.wordpress.admin.DashboardPageObject;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.MediaPageObject;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageObjects.wordpress.admin.PagesPageObject;
import pageObjects.wordpress.admin.PostPageObject;

public class Login_07_Element_Undisplayed extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	String loginPageUrl;
	DashboardPageObject dashboardPage;
	PostPageObject postPage;
	MediaPageObject mediaPage;
	PagesPageObject pagesPage;
	AbstractPage abstracPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String Value) {
		// lấy thông tin browser trong abstract test
		driver = getBrowserDriver(Value, "https://automationfc.wordpress.com/wp-admin/");
		
		log.info("Pre-condition-STEP 01: Open Login Page");
		loginPage = PageGeneratorManager.getLoginAdminPage(driver);
		log.info("Pre-condition-STEP 02: Input to 'Email' textbox");
		loginPage.inputToEmailTextBox("automationeditor");
		log.info("Pre-condition-STEP 03: Click to 'Continue' button");
		loginPage.clickToContinueOrLoginButton();
		log.info("Pre-condition-STEP 04: Input to 'Password' textbox");
		loginPage.inputToPasswordTextBox("automationfc");
		log.info("Pre-condition-STEP 05: Click to 'Login' button");
		dashboardPage = loginPage.clickToContinueOrLoginButton();

	}

	@Test
	public void TC_01_Element_Undisplayed_But_In_DOM() {
	log.info("New_Customer");
	dashboardPage.clickScreenOptionsButton();
	verifyTrue(dashboardPage.isActivityCheckboxDisplay());
	dashboardPage.clickScreenOptionsButton();
	verifyFalse(dashboardPage.isActivityCheckboxDisplay());
	verifyFalse(dashboardPage.isAllPostsMenuDisplay());

		
	}
	@Test
	public void TC_02_Element_Undisplayed_Without_In_DOM() {
		verifyTrue(dashboardPage.isPlansMenuUndisplay());
	}


	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	public int random() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

}
