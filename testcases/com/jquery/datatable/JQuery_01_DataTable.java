package com.jquery.datatable;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.jquery.DataTablePageObject;

public class JQuery_01_DataTable extends AbstractTest {
	WebDriver driver;
	DataTablePageObject dataTablePage;
	

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String Value,String Url) {
		//lấy thông tin browser trong abstract test 
		driver=getBrowserDriver(Value,Url);
		dataTablePage= new DataTablePageObject(driver)	;
	}
	
	@Test
	public void TC_01_InputToColumnByName() {
	dataTablePage= new DataTablePageObject(driver)	;
	dataTablePage.inputToColumnByName("Country","Abruba");
	
	dataTablePage.inputToColumnByName("Total","1504");
	
	}
	@Test
	public void TC_02_PaginationByPageNumber() {
		
		dataTablePage.paginationByPageNumber("15");
	}
	@Test
	public void TC_03_ClickDeleteOrEditByCountryName() {
		dataTablePage.refresh(driver);
		dataTablePage.clickDeleteOrEditByCountryName("Angola","1");
		dataTablePage.clickDeleteOrEditByCountryName("AFRICA","2");
	}

	@Test
	public void TC_04_GetTotalByCountryName() {
		dataTablePage.refresh(driver);
		dataTablePage.getTotalByCountryName("AFRICA");
	}
	@Test
	public void TC_05_SendkeyToDynamicTextboxByRowNumber() {
		dataTablePage.openUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		int columnNumber=dataTablePage.getColumnIndex("Contact Person");
		dataTablePage.sendKeyToDynamicTextbox("trang",Integer.toString(columnNumber),"2");
	}
	@AfterClass
	public void afterClass() {
		
	}

	public int random() {
		Random ran = new Random();
		return ran.nextInt(999999);
	}

}
