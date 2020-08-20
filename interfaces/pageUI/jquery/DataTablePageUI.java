package pageUI.jquery;

public class DataTablePageUI {
public static final String DYNAMIC_COLUMN_TEXT="//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
public static final String DYNAMIC_PAGE_NUMBER="//li[@class='qgrd-pagination-page']/a[text()='%s']";
public static final String DYNAMIC_DELETE_OR_EDIT_BUTTON="//td[@data-key='country' and text()='%s']/preceding-sibling::td[2]//button[%s]";
public static final String DYNAMIC_TOTAL_TEXT="//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total']";
public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN="//th[text()='%s']/preceding-sibling::th";
public static final String DYNAMIC_INPUT="(//td[%s]/input)[%s]";
}
