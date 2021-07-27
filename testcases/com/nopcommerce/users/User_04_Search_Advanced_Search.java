package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserRegisterPO;
import pageObjectsUsers.UserSearchPagePO;

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
	//@Test
	public void TC_03_Search_With_Name_Products_Relative() {
		searchPagePO.senkeyToSeachTexbox(keyRelative);
        searchPagePO.clickToSearchButton();
        verifyTrue(searchPagePO.isProductDisplayed(keyRelative)); 
     
	}
	@Test
	public void TC_04_Search_With_Name_Products_Absolute() {
		searchPagePO.senkeyToSeachTexbox(keyAbsolute);
        searchPagePO.clickToSearchButton();
        verifyTrue(searchPagePO.isProductDisplayed(keyAbsolute)); 
    
        
	}
	@Test
	public void TC_05_Search_Advance_With_Parent_Categories() {	
			searchPagePO.senkeyToSeachTexbox("Apple Macbook Pro");
			searchPagePO.clickToAdvanceSearchChechBox();
			searchPagePO.chosseItemInCategoryDropdown("Computers");
			verifyFalse(searchPagePO.isCheckBoxCheck());
	        searchPagePO.clickToSearchButton();
	        verifyTrue(searchPagePO.isMessageNoProducts()); 
	       
		}
	@Test
	public void TC_06_Search_Advance_With_Sub_Categories() {	
			searchPagePO.senkeyToSeachTexbox("Apple Macbook Pro");
			searchPagePO.clickToAdvanceSearchChechBox();
			searchPagePO.chosseItemInCategoryDropdown("Computers");			
			searchPagePO.clickToAutoSearchSubCategoriesChechBox();
			verifyTrue(searchPagePO.isCheckBoxCheck());
	        searchPagePO.clickToSearchButton();
	        verifyTrue(searchPagePO.isProductDisplayed("Apple MacBook Pro 13-inch")); 
	      
		}
	@Test
	public void TC_07_Search_Advance_With_Incorrect_Manufacturer() {	
			searchPagePO.senkeyToSeachTexbox("Apple Macbook Pro");
			searchPagePO.clickToAdvanceSearchChechBox();
			searchPagePO.chosseItemInCategoryDropdown("Computers");		
			searchPagePO.clickToAutoSearchSubCategoriesChechBox();
			verifyTrue(searchPagePO.isCheckBoxCheck());
			searchPagePO.chooseItemInManufactureDropdown("HP");
	        searchPagePO.clickToSearchButton();	      
	        verifyTrue(searchPagePO.isMessageNoProducts()); 
	        
		}
	
	@Test
	public void TC_08_Search_Advance_With_Correct_Manufacturer() {	
			searchPagePO.senkeyToSeachTexbox("Apple Macbook Pro");
			searchPagePO.clickToAdvanceSearchChechBox();
			searchPagePO.chosseItemInCategoryDropdown("Computers");		
			searchPagePO.clickToAutoSearchSubCategoriesChechBox();
			verifyTrue(searchPagePO.isCheckBoxCheck());
			searchPagePO.chooseItemInManufactureDropdown("Apple");
	        searchPagePO.clickToSearchButton();	      
	        verifyTrue(searchPagePO.isOneProductDisplayed("Apple MacBook Pro 13-inch")); 
	      
		}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
