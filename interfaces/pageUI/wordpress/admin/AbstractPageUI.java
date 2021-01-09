package pageUI.wordpress.admin;

public class AbstractPageUI {
	public static final String MEDIA_MENU = "//div[contains(text(),'Media')]";
	public static final String PAGES_MENU = "//div[contains(text(),'Pages')]";
	public static final String POST_MENU = "//div[contains(text(),'Posts')]";
	
	
	public static final String DYNAMIC_MENU="//div[contains(text(),'%s')]";
	public static final String UPLOAD_FILE_TYPE="//input[@type='file']";
	public static final String MEDIA_INPROGRESS_BAR_ICON="//div[@class='thumbnail']/div[@class='media-progress-bar']";
	public static final String DYNAMIC_ROW_VALUE_AT_COLUMN_NAME="//td[@data-colname='%s']//a[text()='%s']";
	
}
