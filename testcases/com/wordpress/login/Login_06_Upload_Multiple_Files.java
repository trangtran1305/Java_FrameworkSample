package com.wordpress.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Login_06_Upload_Multiple_Files extends AbstractTest {
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
		loginPage = PageGeneratorManager.getLoginAdminPage(driver);
		loginPage.inputToEmailTextBox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextBox("automationfc");
		dashboardPage = loginPage.clickToContinueOrLoginButton();

	}

	@Test
	public void TC_01_Upload_Media() {
	
		
		mediaPage = (MediaPageObject) dashboardPage.openMenuPageByPageName(driver, "Media");
		mediaPage.clickAddNewButton();
		mediaPage.uploadMultipleFiles(driver, "Image_02.jpg","Image_01.jpg");
		Assert.assertTrue(mediaPage.areFilesUploadSuccess());
	}



	@AfterClass
	public void afterClass() {
		
	}

	public int random() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

}
