package pageObjects.jquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.jquery.DataTablePageUI;

public class DataTablePageObject extends AbstractPage {
	WebDriver driver;

	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnByName(String columnName, String value) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_COLUMN_TEXT, columnName);
		sendKeyToElement(driver, value, DataTablePageUI.DYNAMIC_COLUMN_TEXT, columnName);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}

	public void paginationByPageNumber(String numberPage) {
	
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE_NUMBER,numberPage);
		clickToElement(driver, DataTablePageUI.DYNAMIC_PAGE_NUMBER, numberPage);
		Assert.assertTrue(isElementDisplayed(driver, DataTablePageUI.DYNAMIC_PAGE_NUMBER, numberPage));
	}

	public void clickDeleteOrEditByCountryName(String countryName,String buttonNumber) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_DELETE_OR_EDIT_BUTTON,countryName, buttonNumber);
		clickToElement(driver, DataTablePageUI.DYNAMIC_DELETE_OR_EDIT_BUTTON,countryName,buttonNumber);
		
	}
	

	public void getTotalByCountryName(String countryName) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_TOTAL_TEXT,countryName);
		getElementText(driver, DataTablePageUI.DYNAMIC_TOTAL_TEXT,countryName);
		
	}

	public int getColumnIndex(String columnName) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN,columnName);
		return countElementNumber(driver, DataTablePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN,columnName)+1;
	}
	public void sendKeyToDynamicTextbox(String value,String columnIndex, String rowIndex) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_INPUT,columnIndex, rowIndex);
		sendKeyToElement(driver, value,  DataTablePageUI.DYNAMIC_INPUT,columnIndex, rowIndex);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}

	
}
