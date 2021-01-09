package com.nopcommerce.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Json_Data_Test {
	WebDriver driver;
	JsonDataHelper data;
	String password;
	String Jsonfile=System.getProperty("user.dir")+"\\testcases\\com\\nopcommerce\\register\\register.json";

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		data = JsonDataHelper.getData(Jsonfile);
		password = data.getPassword();

	}

	@Test
	public void TC_01_Register() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(data.getFirstName());
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(data.getLastName());
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(data.getEmail());
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(data.getCompanyName());
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='register-button']")).click();

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
