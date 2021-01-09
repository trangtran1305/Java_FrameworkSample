package com.bankguru.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.PageGeneratorManager;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_03_Dynamic_Page_Element extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	String userID;
	String password;
	String loginPageUrl;
	String customerName;
	String gender;
	String dateOfBirth;
	String address;
	String city;
	String state;
	String pin;
	String phone;
	String email;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String Value) {
		driver = getBrowserDriver(Value, "http://demo.guru99.com/v4");
		customerName = "johndeep";
		gender = "male";
		dateOfBirth = "1999-01-01";
		address = "USA";
		city = "New York";
		state = "California";
		pin = "123456";
		phone = "0978361559";
		email = "johndeep" + random() + "@gmail.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();

	}

	@Test
	public void TC_01_Register() {

		loginPage.clickDynamicLink(driver,"here");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.inputDynamicTextbox(driver, "emailid",email);
		registerPage.clickDynamicButton(driver,"btnLogin");
		userID = registerPage.getDynamicValueByColumnName(driver,"User ID");
		password = registerPage.getDynamicValueByColumnName(driver,"Password");
		loginPage = registerPage.openLoginPage(loginPageUrl);

	}

	@Test
	public void TC_02_Login() {
		loginPage.inputDynamicTextbox(driver,"uid", userID);;
		loginPage.inputDynamicTextbox(driver, "password", password);
		loginPage.clickDynamicButton(driver,"btnLogin");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}

	@Test
	public void TC_03_NewCustomer() {
		homePage.clickDynamicLink(driver,"New Customer");
		newCustomerPage=PageGeneratorManager.getNewCustomerPage(driver);
		newCustomerPage.inputDynamicTextbox(driver,"name", customerName);
		newCustomerPage.clickDynamicRadioButton(driver, "m");
		newCustomerPage.inputDynamicTextbox(driver, "dob",dateOfBirth);
		newCustomerPage.inputDynamicTextArea(driver,"addr",address);
		newCustomerPage.inputDynamicTextbox(driver,"city", city);
		newCustomerPage.inputDynamicTextbox(driver,"state",state);
		newCustomerPage.inputDynamicTextbox(driver,"pinno",pin);
		newCustomerPage.inputDynamicTextbox(driver,"telephoneno",phone);
		newCustomerPage.inputDynamicTextbox(driver,"emailid",email);
		newCustomerPage.inputDynamicTextbox(driver,"password",password);
		newCustomerPage.clickDynamicButton(driver,"sub");
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Customer Name"),customerName);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Gender"),gender);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Birthdate"),dateOfBirth);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Address"),address);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"City"),city);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"State"),state);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Pin"),pin);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Mobile"),phone);
		verifyEquals(newCustomerPage.getDynamicValueByColumnName(driver,"Email"),email);	
	}
	@Test
	public void TC_04_EditCustomer() {

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
