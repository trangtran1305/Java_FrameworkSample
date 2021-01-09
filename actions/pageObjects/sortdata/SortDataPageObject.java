package pageObjects.sortdata;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.sortdata.SortDataPageUI;

public class SortDataPageObject extends AbstractPage {
   WebDriver driver;
   public SortDataPageObject(WebDriver driver) {
	   this.driver=driver;
   }
	public boolean areItemsSortedAscending() {
		waitForElementVisible(driver,SortDataPageUI.ALL_ITEM_NAME);
		return isDataSortedAscending(driver, SortDataPageUI.ALL_ITEM_NAME);
	}
		public void selectItemInDropdown(String value) {
		waitForElementVisible(driver,SortDataPageUI.SORT_DROPDOWN);
		selectValueInDropdown(driver,SortDataPageUI.SORT_DROPDOWN, value);
		
	}
		public boolean areItemsSortedDescending() {
			waitForElementVisible(driver,SortDataPageUI.ALL_ITEM_NAME);
			return isDataSortedDescending(driver, SortDataPageUI.ALL_ITEM_NAME);
		}


}
