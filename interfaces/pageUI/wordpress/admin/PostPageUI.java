package pageUI.wordpress.admin;

public class PostPageUI {

	public static final String POST_MENU = "//div[contains(text(),'Posts')]";
	public static final String ADD_NEW_BUTTON = "//a[@class='page-title-action']";
	public static final String PUBLISH_BUTTON = "//input[@id='publish']";
	public static final String PUBLISHED_TEXT = "//p[contains(text(),'Post published.')]";
	public static final String SEARCH_TEXTBOX = "//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "//input[@id='search-submit']";
	public static final String TITLE_LINK_AT_EDIT = "//a[@class='row-title' and text()='%s']";
}
