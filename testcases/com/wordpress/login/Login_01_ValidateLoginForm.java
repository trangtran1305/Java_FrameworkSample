package com.wordpress.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_ValidateLoginForm {
	WebDriver driver;
	By emailTextbox= By.xpath("//input[@id='usernameOrEmail']");
	By passTextbox= By.xpath("//input[@id='password']");
	By loginButton= By.xpath("//button[@class='button form-button is-primary']");
	By errorMessage= By.xpath("//div[@role='alert']/span");
	
	
	
	@BeforeClass
	public void beforeClass() {
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	
}
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin/");
	}
	

	@Test
	public void Validate_01_EmptyEmail() {
		driver.findElement(emailTextbox).sendKeys("");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(errorMessage).getText().trim(),"Please enter a username or email address.");
		
		
		
	}
	@Test
	public void Validate_02_InvalidEmail() {
		driver.findElement(emailTextbox).sendKeys("123@123.123");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(errorMessage).getText().trim(),"Please log in using your WordPress.com username instead of your email address.");
}
	@Test
	public void Validate_03_EmailNotExist() {
		driver.findElement(emailTextbox).sendKeys("automation"+random()+"@gmail.com");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(errorMessage).getText().trim(),"User does not exist. Would you like to create a new account?");
		
	}
	@Test
	public void Validate_04_EmptyPassWord() {
		driver.findElement(emailTextbox).sendKeys("automationeditor");
		driver.findElement(loginButton).click();
		driver.findElement(passTextbox).sendKeys("");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(errorMessage).getText().trim(),"Don't forget to enter your password.");
	}
	@Test
	public void Validate_05_PasswordLessThan6Chars() {
		driver.findElement(emailTextbox).sendKeys("automationeditor");
		driver.findElement(loginButton).click();
		driver.findElement(passTextbox).sendKeys("1234");
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(errorMessage).getText().trim(),"Oops, that's not the right password. Please try again!");
	}
	@Test
	public void Validate_06_ValidPassword() {
		driver.findElement(emailTextbox).sendKeys("automationeditor");
		driver.findElement(loginButton).click();
		driver.findElement(passTextbox).sendKeys("automationfc");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wrap']/h1")).isDisplayed());
	}
	@AfterClass
	public void afterClass() {
	}
	public int random(){
		Random ran= new Random();
		return ran.nextInt(999999);
	}
	
}
