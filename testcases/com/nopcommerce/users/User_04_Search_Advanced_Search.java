package com.nopcommerce.users;

import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;

import pageObjects.PageGenerator;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrderPO;
import pageObjects.UserRegisterPO;
import pageObjects.UserSearchPagePO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_04_Search_Advanced_Search extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserSearchPagePO searchPagePO;
	UserCustomerInfoPO customerInfor;
	
	String keySearch="Macbook Pro 2050",keyRelative="Lenovo",keyAbsolute="Thinkpad X1 Carbon ";
     
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);
         
        
		homePageObject = PageGenerator.getUserHomePage(driver);
//		loginPageObject = homePageObject.clickToLoginLink();
//		customerInfor=loginPageObject.loginToSystem(Common_01_Register.email, Common_01_Register.passWord);
         searchPagePO=homePageObject.openSearchPage(driver);
	}

	//@Test
	public void TC_01_Search_With_Empty_Data() {
      searchPagePO.clickToSearchButton();
      verifyTrue(searchPagePO.isMessageError());
      
	}
	//@Test
	public void TC_02_Search_With_Data_Not_Exits() {
		searchPagePO.senkeyToSeachTexbox(keySearch);
      searchPagePO.clickToSearchButton();
      verifyTrue(searchPagePO.isMessageNoProducts());
      
	}
	@Test
	public void TC_03_Search_With_Name_Products_Relative() {
		searchPagePO.senkeyToSeachTexbox(keyRelative);
        searchPagePO.clickToSearchButton();
        verifyTrue(searchPagePO.isProductDisplayed(keyRelative)); 
        searchPagePO.sleepSecond(3);
	}
	@Test
	public void TC_04_Search_With_Name_Products_Absolute() {
		searchPagePO.senkeyToSeachTexbox(keyAbsolute);
        searchPagePO.clickToSearchButton();
        verifyTrue(searchPagePO.isProductDisplayed(keyAbsolute)); 
        searchPagePO.sleepSecond(3);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
