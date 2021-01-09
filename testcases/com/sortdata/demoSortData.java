package com.sortdata;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.sortdata.SortDataPageObject;

public class demoSortData extends AbstractTest {
	WebDriver driver;
	SortDataPageObject sortPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String Value) {
		driver = getBrowserDriver(Value, "https://www.saucedemo.com/inventory.html");
		sortPageObject = new SortDataPageObject(driver);

	}

	@Test
	public void Test_01_Sort_Ascending_String() {
		verifyTrue(sortPageObject.areItemsSortedAscending());
		sortPageObject.selectItemInDropdown("za");
		verifyTrue(sortPageObject.areItemsSortedDescending());
		
	}


	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
