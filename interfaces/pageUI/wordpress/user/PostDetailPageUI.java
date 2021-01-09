package pageUI.wordpress.user;

public class PostDetailPageUI {

	public static final String DYNAMIC_CATEGORIES="//p[@class='post-categories']/a[text()='%s']";
	public static final String DYNAMIC_TITLE="//h1[@class='post-title' and text()='%s']";
	public static final String DYNAMIC_IMAGE="//img[@data-image-title='%s']";
	public static final String DYNAMIC_CONTENT="//div[@class='post-content']/p[contains(text(),'%s')]";
	public static final String DYNAMIC_DATE="//span[@class='post-meta-date']/a[contains(text(),'%s')]";
	public static final String DYNAMIC_AUTHOR="//span[@class='post-meta-author']/a[text()='%s']";

}
