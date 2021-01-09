package pageUI.bankGuru;

public class AbstractBankPageUI {
 
	public static String DYNAMIC_TEXTBOX="//input[@name='%s']";
	public static String DYNAMIC_TEXTAREA="//textarea[@name='%s']";
	public static String DYNAMIC_RADIO_BUTTON="//input[@type='radio' and @value='%s']";
	public static String DYNAMIC_LINK="//a[contains(text(),'%s')]";
	public static String DYNAMIC_BUTTON="//input[@name='%s']";
	public static String DYNAMIC_MESSAGE="//label[@id='%s']";
	public static String DYNAMIC_HEADING="//p[@class='heading3' and text()='%s']";
	public static String DYNAMIC_VALUE_BY_COLUMN_NAME="//td[contains(text(),'%s')]/following-sibling::td";
	
	
}
