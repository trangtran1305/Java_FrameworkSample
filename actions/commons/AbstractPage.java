package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.wordpress.AbstractPageUI;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.PagesPageObject;
import pageObjects.wordpress.PostPageObject;

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

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			if (!id.equals(parentID))
				driver.switchTo().window(id);
			break;
		}
	}

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

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		driver.findElement(byXpath(locator)).sendKeys(value);
	}

	public String getElementText(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator)).getText();
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

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
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
	public void waitForElementVisible(WebDriver driver,String locator ) {
		explicitWait= new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
		
	}
	public void waitForElementInvisible(WebDriver driver,String locator ) {
		explicitWait= new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
		
	}
	public void waitForElementClickable(WebDriver driver,String locator ) {
		explicitWait= new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
		
	}
	public PagesPageObject clickToPagesMenu(WebDriver driver) {
		waitForElementVisible(driver,AbstractPageUI.PAGES_MENU );
		clickToElement(driver, AbstractPageUI.PAGES_MENU);
		return PageGeneratorManager.getPagesPage(driver);
	}
	public MediaPageObject clickToMediaMenu(WebDriver driver) {
		waitForElementVisible(driver,AbstractPageUI.MEDIA_MENU );
		clickToElement(driver, AbstractPageUI.MEDIA_MENU);
		return PageGeneratorManager.getMediaPage(driver);
	}
	public PostPageObject clickToPostMenu(WebDriver driver) {
		waitForElementVisible(driver,AbstractPageUI.POST_MENU);
		clickToElement(driver, AbstractPageUI.POST_MENU);
		return PageGeneratorManager.getPostPage(driver);
		
	}
	

	private Select select;
	private JavascriptExecutor js;
	private WebElement element;
	List<WebElement> elements;
	private WebDriverWait explicitWait;
	private long timeout=30;

}
