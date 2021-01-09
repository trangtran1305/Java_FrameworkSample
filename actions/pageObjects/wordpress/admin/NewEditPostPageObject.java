package pageObjects.wordpress.admin;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.NewEditPostPageUI;

public class NewEditPostPageObject extends AbstractPage {
	WebDriver driver;
	public NewEditPostPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public void inputToTitleTextbox(String value) {
		waitForElementVisible(driver, NewEditPostPageUI.TITLE_TEXTBOX);
		sendKeyToElement(driver,NewEditPostPageUI.TITLE_TEXTBOX, value);
		
	}
	public void inputToContentTextbox(String value) {
		switchToFrame(driver, NewEditPostPageUI.TINY_MCE_IFRAME);
		waitForElementVisible(driver, NewEditPostPageUI.TINY_MCE_TEXTBOX);
		sendKeyToElement(driver,NewEditPostPageUI.TINY_MCE_TEXTBOX, value);
		switchToDefaultContent(driver);
		
		
	}
	public void selectCategoryCheckbox() {
		waitForElementClickable(driver,NewEditPostPageUI.CATAGORY_CHECKBOX);
		scrollToElement(driver, NewEditPostPageUI.CATAGORY_CHECKBOX);
		clickToElementByJS(driver,  NewEditPostPageUI.CATAGORY_CHECKBOX);
		
	}
	public void inputToTagTextbox(String value) {
		waitForElementVisible(driver, NewEditPostPageUI.TAG_TEXTBOX);
		sendKeyToElement(driver,NewEditPostPageUI.TAG_TEXTBOX, value);
		
	}
	public void clickToAddTageButton() {
		waitForElementVisible(driver, NewEditPostPageUI.TAG_BUTTON);
		clickToElement(driver,NewEditPostPageUI.TAG_BUTTON);
		
	}
	public void clickToSetFeatureImageLink() {
		waitForElementVisible(driver, NewEditPostPageUI.SET_IMAGE_LINK);
		clickToElement(driver,NewEditPostPageUI.SET_IMAGE_LINK);
		
	}
	public void clickToUploadFilesButton() {
		waitForElementVisible(driver, NewEditPostPageUI.UPLOAD_IMAGE_BUTTON);
		clickToElement(driver,NewEditPostPageUI.UPLOAD_IMAGE_BUTTON);
		
	}
	public void clickToSetFeatureImageButton() {
		waitForElementClickable(driver, NewEditPostPageUI.SET_FEATURE_IMAGE_BUTTON);
		clickToElement(driver,NewEditPostPageUI.SET_FEATURE_IMAGE_BUTTON);
				
	}
	public boolean isImagedisplayed() {		
		waitForElementVisible(driver, NewEditPostPageUI.IMAGE_THUMNAIL);
		return  isElementDisplayed(driver,NewEditPostPageUI.IMAGE_THUMNAIL);		
	}

	public void clickToUpdateButton() {
		waitForElementVisible(driver, NewEditPostPageUI.UPDATE_BUTTON);
		clickToElement(driver, NewEditPostPageUI.UPDATE_BUTTON);
	}
	public boolean isNewPostUpdated() {
		waitForElementVisible(driver, NewEditPostPageUI.UPDATE_SUCCESS_TEXT);
		return isElementDisplayed(driver, NewEditPostPageUI.UPDATE_SUCCESS_TEXT);
	}
		
	public void clickMoveToTrashLink() {
		waitForElementVisible(driver, NewEditPostPageUI.MOVE_TO_TRASH_LINK);
		clickToElement(driver, NewEditPostPageUI.MOVE_TO_TRASH_LINK);
		
	}
	public boolean isPostMovedToTrash() {
		waitForElementVisible(driver, NewEditPostPageUI.MOVE_TO_TRASH_SUCCESS_TEXT);
		return isElementDisplayed(driver,NewEditPostPageUI.MOVE_TO_TRASH_SUCCESS_TEXT);
	}
	
	

}
