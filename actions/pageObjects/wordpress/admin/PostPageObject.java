package pageObjects.wordpress.admin;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.NewEditPostPageUI;
import pageUI.wordpress.admin.PostPageUI;

public class PostPageObject extends AbstractPage {
	WebDriver driver;
	public PostPageObject(WebDriver mapDriver) {
		this.driver=mapDriver;
	}
	public NewEditPostPageObject clickAddNewButton() {
		waitForElementVisible(driver, PostPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, PostPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getNewEditPostAdminPage(driver);
		
	}
	public void clickToPublishButton() {
		
		waitForElementClickable(driver, PostPageUI.PUBLISH_BUTTON);
		clickToElementByJS(driver,PostPageUI.PUBLISH_BUTTON);
		sleepInSeconds(15);
		
	}
	
	public boolean isNewPostPublished() {
		waitForElementVisible(driver, PostPageUI.PUBLISHED_TEXT);
		return isElementDisplayed(driver,PostPageUI.PUBLISHED_TEXT);
	}
	public void inputSearchTextbox(String value) {
		waitForElementVisible(driver,PostPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver,PostPageUI.SEARCH_TEXTBOX, value);
		
	}
	public void clickToSearchPostButton() {
		waitForElementClickable(driver,PostPageUI.SEARCH_BUTTON);
		clickToElement(driver,PostPageUI.SEARCH_BUTTON);
	}

	public NewEditPostPageObject clickToPostDetail(String title) {
		waitForElementVisible(driver,PostPageUI.TITLE_LINK_AT_EDIT,title);
		clickToElement(driver,PostPageUI.TITLE_LINK_AT_EDIT,title);
		return PageGeneratorManager.getNewEditPostAdminPage(driver);
	}
	
	
}
