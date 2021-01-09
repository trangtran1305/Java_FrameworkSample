package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.wordpress.admin.DashboardPageObject;
import pageObjects.wordpress.admin.MediaPageObject;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageObjects.wordpress.admin.PagesPageObject;
import pageObjects.wordpress.admin.PostPageObject;
import pageObjects.wordpress.user.HomeUserPageObject;
import pageObjects.wordpress.user.PostDetailPageObject;
import pageObjects.wordpress.user.SearchResultPageObject;
import pageUI.bankGuru.AbstractBankPageUI;
import pageUI.wordpress.admin.AbstractPageUI;
import pageUI.wordpress.admin.NewEditPostPageUI;

public abstract class AbstractPage {

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());

	}

	// 2 tab
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			if (!id.equals(parentID))
				driver.switchTo().window(id);
			break;
		}
	}

	// nhieu hon 2 tab
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(title))
				break;
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			if (!id.equals(parentID))
				driver.switchTo().window(id);
			driver.close();
		}
		driver.switchTo().window(parentID);
	}

	public By byXpath(String locator) {
		return By.xpath(locator);

	}

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(byXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(byXpath(locator)).click();
	}

	// Overloading->đa hình
	public void clickToElement(WebDriver driver, String locator, String... parameters) {
		driver.findElement(byXpath(String.format(locator, (Object[]) parameters))).click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		driver.findElement(byXpath(locator)).clear();
		driver.findElement(byXpath(locator)).sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String value, String locator, String... parameters) {
		driver.findElement(byXpath(String.format(locator, (Object[]) parameters))).clear();
		driver.findElement(byXpath(String.format(locator, (Object[]) parameters))).sendKeys(value);
	}

	public String getElementText(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator)).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... parameters) {
		return driver.findElement(byXpath(String.format(locator, (Object[]) parameters))).getText();
	}

	public void selectValueInDropdown(WebDriver driver, String locator, String value) {
		select = new Select(findElementByXpath(driver, locator));
		select.selectByValue(value);
	}

	public String getSelectItemInDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		return select.getFirstSelectedOption().getText();

	}

	public void sleepInSeconds(long time) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
			;

		}
	}

	public void selectItemInDropDown(WebDriver driver, String parentLocator, String ItemsLocator, String expectedItem) {

		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(parentLocator)));
		findElementByXpath(driver, parentLocator).click();
		sleepInSeconds(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(ItemsLocator)));

		elements = findElementsByXpath(driver, ItemsLocator);

		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {

				js.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSeconds(2);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				sleepInSeconds(2);
				break;
			}
		}

	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = findElementsByXpath(driver, locator);
		return elements.size();
	}

	public int countElementNumber(WebDriver driver, String locator, String... parameters) {
		elements = findElementsByXpath(driver, String.format(locator, (Object[]) parameters));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (!element.isSelected())
			element.click();
	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (element.isSelected())
			element.click();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... parameters) {
		return findElementByXpath(driver, String.format(locator, (Object[]) parameters)).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			element = findElementByXpath(driver, locator);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void overrideTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

// đè lại timeout=shorttime khi không tìm thấy element trong DOM,sau đó lại đè lại timeout=longtime ban đầu
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrideTimeout(driver, shorttimeout);
		elements = driver.findElements(byXpath(locator));
		if (elements.size() == 0) {
			overrideTimeout(driver, longtimeout);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideTimeout(driver, longtimeout);
			return true;
		} else {
			overrideTimeout(driver, longtimeout);
			return false;
		}

	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	// Browser
	public Object executeForBrowser(WebDriver driver, String javaSript) {
		js = (JavascriptExecutor) driver;
		return js.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		js = (JavascriptExecutor) driver;
		String textActual = (String) js
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.location = '" + url + "'");
	}

	// Element
	public void highlightElement(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		String originalStyle = element.getAttribute("style");
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		element = findElementByXpath(driver, locator);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		element = findElementByXpath(driver, locator);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String attributeRemove, String locator, String... parameters) {
		element = findElementByXpath(driver, String.format(locator, (Object[]) parameters));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean isImageDisplayed(WebDriver driver, WebElement image) {
		js = (JavascriptExecutor) driver;
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth !="
						+ " \"undefined\" && arguments[0].naturalWidth > 0", image);
		if (!ImagePresent)
			return false;
		else
			return true;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));

	}

	public void waitForElementVisible(WebDriver driver, String locator, String... parameters) {
		explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(byXpath(String.format(locator, (Object[]) parameters))));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
	}

	public void waitForElementsInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(findElementsByXpath(driver, locator)));

	}

	public void waitForElementClickable(WebDriver driver, String locator, String... parameters) {
		explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait
				.until(ExpectedConditions.elementToBeClickable(byXpath(String.format(locator, (Object[]) parameters))));

	}

	// Sort ascending
	public boolean isDataSortedAscending(WebDriver driver, String locator) {
		ArrayList<String> arrayList1= new ArrayList<String>();
		
		List<WebElement>elementList = findElementsByXpath(driver, locator);
	    for(WebElement element: elementList) {
	    	arrayList1.add(element.getText());
	    }
	    ArrayList<String> arrayList2= new ArrayList<String>();
	    for(String item:arrayList1) {
	    	arrayList2.add(item);
	    }
	    Collections.sort(arrayList2);
	    return arrayList1.equals(arrayList2);
	}
	// Sort descending
	public boolean isDataSortedDescending(WebDriver driver, String locator) {
		ArrayList<String> arrayList1= new ArrayList<String>();
		
		List<WebElement>elementList = findElementsByXpath(driver, locator);
	    for(WebElement element: elementList) {
	    	arrayList1.add(element.getText());
	    }
	    ArrayList<String> arrayList2= new ArrayList<String>();
	    for(String item:arrayList1) {
	    	arrayList2.add(item);
	    }
	    Collections.sort(arrayList2);
	    Collections.reverse(arrayList2);
	    return arrayList1.equals(arrayList2);
	}

	// Đứng ở bất kì page nào để gọi page khác
	public PagesPageObject clickToPagesMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.PAGES_MENU);
		clickToElement(driver, AbstractPageUI.PAGES_MENU);
		return PageGeneratorManager.getPagesAdminPage(driver);
	}

	public MediaPageObject clickToMediaMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.MEDIA_MENU);
		clickToElement(driver, AbstractPageUI.MEDIA_MENU);
		return PageGeneratorManager.getMediaAdminPage(driver);
	}

	public PostPageObject clickToPostMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.POST_MENU);
		clickToElement(driver, AbstractPageUI.POST_MENU);
		return PageGeneratorManager.getPostAdminPage(driver);

	}

	// Dynamic Locator: ít page
	public AbstractPage openMenuPageByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MENU, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU, pageName);
		if (pageName.equals("Media"))
			return PageGeneratorManager.getMediaAdminPage(driver);
		else if (pageName.equals("Posts"))
			return PageGeneratorManager.getPostAdminPage(driver);
		else if (pageName.equals("Pages"))
			return PageGeneratorManager.getPagesAdminPage(driver);
		else
			return PageGeneratorManager.getDashboardAdminPage(driver);

	}

	// Dynamic Locator: nhiều page
	public void openMoreMenuPageByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MENU, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU, pageName);

	}

	// Upload_Multiple_File_Rest_Paramemeter
	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + System.getProperty("user.dir") + "\\upload_file\\" + file + "\n";
		}

		fullFileName = fullFileName.trim();
		driver.findElement(By.xpath(AbstractPageUI.UPLOAD_FILE_TYPE)).sendKeys(fullFileName);
	}

	// Bank Guru Dynamic Page Object Component
	public void inputDynamicTextbox(WebDriver driver, String textboxName, String value) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX, textboxName);
		if (textboxName == "dob")
			removeAttributeInDOM(driver, "type", AbstractBankPageUI.DYNAMIC_TEXTBOX, "dob");
		sendKeyToElement(driver, value, AbstractBankPageUI.DYNAMIC_TEXTBOX, textboxName);
	}

	public void inputDynamicTextArea(WebDriver driver, String textareaName, String value) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA, textareaName);
		sendKeyToElement(driver, value, AbstractBankPageUI.DYNAMIC_TEXTAREA, textareaName);
	}

	public void clickDynamicRadioButton(WebDriver driver, String radioButtonName) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName);
		clickToElement(driver, AbstractBankPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName);
	}

	public void clickDynamicLink(WebDriver driver, String linkName) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_LINK, linkName);
		clickToElement(driver, AbstractBankPageUI.DYNAMIC_LINK, linkName);
	}

	public void clickDynamicButton(WebDriver driver, String buttonName) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_BUTTON, buttonName);
		clickToElement(driver, AbstractBankPageUI.DYNAMIC_BUTTON, buttonName);
	}

	public boolean isDynamicMessageDisplayed(WebDriver driver, String messageName) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_MESSAGE, messageName);
		return isElementDisplayed(driver, AbstractBankPageUI.DYNAMIC_MESSAGE, messageName);
	}

	public boolean isDynamicHeadingDisplayed(WebDriver driver, String headingName) {
		waitForElementVisible(driver, AbstractBankPageUI.DYNAMIC_HEADING, headingName);
		return isElementDisplayed(driver, AbstractBankPageUI.DYNAMIC_MESSAGE, headingName);
	}

	public String getDynamicValueByColumnName(WebDriver driver, String columnName) {
		return getElementText(driver, AbstractBankPageUI.DYNAMIC_VALUE_BY_COLUMN_NAME, columnName);
	}

	// Wordpress Dynamic Page Object Component
	public HomeUserPageObject openEndUserPage(WebDriver driver) {
		openUrl(driver, "https://automationfc.wordpress.com/");
		return PageGeneratorManager.getHomeUserPage(driver);
	}

	public DashboardPageObject openAdminLoggedPage(WebDriver driver) {
		openUrl(driver, "https://automationfc.wordpress.com/wp-admin/");
		return PageGeneratorManager.getDashboardAdminPage(driver);
	}

	public boolean isRowValueDisplayedAtColumn(WebDriver driver, String columnName, String rowValue) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_ROW_VALUE_AT_COLUMN_NAME, columnName, rowValue);
		return isElementDisplayed(driver, AbstractPageUI.DYNAMIC_ROW_VALUE_AT_COLUMN_NAME, columnName, rowValue);
	}

	public boolean isNewPostDisplayed(WebDriver driver, String catagory, String title, String date) {
		waitForElementVisible(driver, pageUI.wordpress.user.AbstractPageUI.DYNAMIC_CATAGORY_TITLE_DATE, catagory, title,
				date);
		return isElementDisplayed(driver, pageUI.wordpress.user.AbstractPageUI.DYNAMIC_CATAGORY_TITLE_DATE, catagory,
				title, date);

	}

	public boolean isPostImageDisplayed(WebDriver driver, String title, String image) {
		waitForElementVisible(driver, pageUI.wordpress.user.AbstractPageUI.DYNAMIC_IMAGE_AT_HOMEPAGE_USER, title,image);
		return isElementDisplayed(driver, pageUI.wordpress.user.AbstractPageUI.DYNAMIC_IMAGE_AT_HOMEPAGE_USER, title,
				image);
	}

	public boolean isSuccessMessageDisplay(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void uploadMultipleFilesAtWordpress(WebDriver driver, String... fileNames) {
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + System.getProperty("user.dir") + "\\upload_file\\" + file + "\n";
		}

		fullFileName = fullFileName.trim();
		driver.findElement(By.xpath(NewEditPostPageUI.SELECT_FILES_BUTTON)).sendKeys(fullFileName);

	}

	public PostDetailPageObject clickToPostDetail(WebDriver driver, String title) {
		waitForElementVisible(driver, pageUI.wordpress.user.AbstractPageUI.DYNAMICL_POST_DETAIL_LINK, title);
		clickToElement(driver, pageUI.wordpress.user.AbstractPageUI.DYNAMICL_POST_DETAIL_LINK, title);
		return PageGeneratorManager.getPostDetailUserPage(driver);

	}

	public SearchResultPageObject inputToSearchTextboxAtEndUserPage(WebDriver driver, String value) {
		waitForElementVisible(driver, pageUI.wordpress.user.AbstractPageUI.SEARCH_ICON);
		clickToElement(driver, pageUI.wordpress.user.AbstractPageUI.SEARCH_ICON);
		sendKeyToElement(driver, pageUI.wordpress.user.AbstractPageUI.SEARCH_TEXTBOX, value);
		clickToElement(driver, pageUI.wordpress.user.AbstractPageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getSearchResultUserPage(driver);
	}

	private Select select;
	private JavascriptExecutor js;
	private WebElement element;
	List<WebElement> elements;
	private WebDriverWait explicitWait;
	private long longtimeout = 30;
	private long shorttimeout = 5;

}
