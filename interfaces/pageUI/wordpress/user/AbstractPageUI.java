package pageUI.wordpress.user;

public class AbstractPageUI {
	public static final String MEDIA_MENU = "//div[contains(text(),'Media')]";
	public static final String PAGES_MENU = "//div[contains(text(),'Pages')]";
	public static final String POST_MENU = "//div[contains(text(),'Posts')]";
	
	
	public static final String DYNAMIC_MENU="//div[contains(text(),'%s')]";
	public static final String UPLOAD_FILE_TYPE="//input[@type='file']";
	public static final String MEDIA_INPROGRESS_BAR_ICON="//div[@class='thumbnail']/div[@class='media-progress-bar']";
	public static final String DYNAMIC_IMAGE_AT_HOMEPAGE_USER="//a[@title='%s']/img[contains(@src,'%s')]";
	public static final String DYNAMICL_POST_DETAIL_LINK="//a[text()='%s']";
	public static final String DYNAMIC_CATAGORY_TITLE_DATE="//p[@class='post-categories']/a[text()='%s']/parent::p/following-sibling::h2/"
			+ "a[text()='%s']/parent::h2/following-sibling::p[@class='post-meta']/a[text()='%s']";
	
	public static final String SEARCH_ICON="//a[@class='search-toggle']";
	public static final String SEARCH_TEXTBOX="//input[@placeholder='Search']";
	public static final String SEARCH_BUTTON="//span[@class='fa fw fa-search']";
}
