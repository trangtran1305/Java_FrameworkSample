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

public class Login_05_Dynamic_Locator extends AbstractTest {
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
		//lấy thông tin browser trong abstract test 
		driver=getBrowserDriver(Value,"https://automationfc.wordpress.com/wp-admin/");
		loginPage = PageGeneratorManager.getLoginAdminPage(driver);
		
	}

	@Test
	public void TC_01_Login() {
		loginPage.inputToEmailTextBox("automationeditor");
		loginPage.clickToContinueOrLoginButton();
		loginPage.inputToPasswordTextBox("automationfc");
		dashboardPage=loginPage.clickToContinueOrLoginButton();
		Assert.assertTrue(dashboardPage.isHeaderTextDisplay());
	}
	@Test
	public void TC_02_NavigateToPage() {
		//DashBoard->Post
		postPage=(PostPageObject) dashboardPage.openMenuPageByPageName(driver,"Posts");		
		//Post->Pages		
		pagesPage=(PagesPageObject) postPage.openMenuPageByPageName(driver,"Pages");
		//Pages->Media
		mediaPage=(MediaPageObject) pagesPage.openMenuPageByPageName(driver,"Media");
		//Media->Post
		postPage= (PostPageObject) mediaPage.openMenuPageByPageName(driver,"Posts");
		//Post->Media
		mediaPage=(MediaPageObject) postPage.openMenuPageByPageName(driver,"Media");
		
		//nhiều page: không có kiểu trả về của hàm click
		mediaPage.openMenuPageByPageName(driver,"Posts");
		postPage= PageGeneratorManager.getPostAdminPage(driver);
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
