package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import pageObjects.wordpress.user.HomeUserPageObject;
import pageObjects.wordpress.user.PostDetailPageObject;
import pageObjects.wordpress.user.SearchResultPageObject;

public class PageGeneratorManager {
	public static LoginPageObject getLoginAdminPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static DashboardPageObject getDashboardAdminPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	public static MediaPageObject getMediaAdminPage(WebDriver driver) {
		return new MediaPageObject(driver);
	}
	public static PostPageObject getPostAdminPage(WebDriver driver) {
		return new PostPageObject(driver);
	}
	public static PagesPageObject getPagesAdminPage(WebDriver driver) {
		return new PagesPageObject(driver);
	}
	public static NewEditPostPageObject getNewEditPostAdminPage(WebDriver driver) {
		return new NewEditPostPageObject(driver);
	}
	public static HomeUserPageObject getHomeUserPage(WebDriver driver) {
		return new HomeUserPageObject(driver);
	}
	public static PostDetailPageObject getPostDetailUserPage(WebDriver driver) {
		return new PostDetailPageObject(driver);
	}
	public static SearchResultPageObject getSearchResultUserPage(WebDriver driver) {
		return new SearchResultPageObject(driver);
	}
	
}
