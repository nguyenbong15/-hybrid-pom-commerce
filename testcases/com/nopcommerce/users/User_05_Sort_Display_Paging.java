package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.PageGenerator;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;
import pageObjects.UserSortDisplayPagingPO;

public class User_05_Sort_Display_Paging extends AbstractTest {
	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserSortDisplayPagingPO sortPagePO;
     String numberPaging="3";
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		homePageObject = PageGenerator.getUserHomePage(driver);

		sortPagePO = homePageObject.openSortDiplayPagingPage(driver);
	}

	//@Test
	public void TC_01_Sort_Name_A_Z() {
		sortPagePO.selectItemInSortByDropdown("Name: A to Z");
		verifyTrue(sortPagePO.isCorrectSortNameAToZ());
		sortPagePO.sleepSecond(5);

	}
//	@Test
	public void TC_02_Sort_Name_Z_A() {
		sortPagePO.selectItemInSortByDropdown("Name: Z to A");
		verifyTrue(sortPagePO.isCorrectSortNameZToA());

	}
//	@Test
	public void TC_03_Sort_Price_Low_To_High() {
		sortPagePO.selectItemInSortByDropdown("Price: Low to High");
		verifyTrue(sortPagePO.isCorrectSortPriceLowToHigh());

	}
	//@Test
	public void TC_04_Sort_Price_High_To_Low() {
		sortPagePO.selectItemInSortByDropdown("Price: High to Low");
		verifyTrue(sortPagePO.isCorrectSortPriceHighToLow());

	}
	@Test
	public void TC_05_Display_Products_By_Number_Paging() {
		sortPagePO.selectItemInSortByDropdown("Position");
		sortPagePO.selectItemInPagingDropDown(numberPaging);
		verifyTrue(sortPagePO.areProductsDisplayByNumberPaging(numberPaging));
        
        	verifyTrue(sortPagePO.iconNextPageDiplayed());
        	sortPagePO.clickToTwoPage();
        	verifyTrue(sortPagePO.iconPreviousPageDiplayed());     	
        	sortPagePO.selectItemInPagingDropDown("6");
        	verifyTrue(sortPagePO.iconNextPageAndPreviousUnDiplayed());
        
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
