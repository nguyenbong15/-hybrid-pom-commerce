package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserCompareProductsPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserRegisterPO;
import pageObjectsUsers.UserWishlistPagePO;

public class User_06_Wishlist_Compare_RecentView extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserCustomerInfoPO customerInfor;
	UserWishlistPagePO wishlistPage;
	UserCompareProductsPO comparePage;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		homePageObject = PageGenerator.getUserHomePage(driver);
		 loginPageObject = homePageObject.clickToLoginLink();
		 customerInfor = loginPageObject.loginToSystem(Common_01_Register.email,
		 Common_01_Register.passWord);

	}

	 @Test
	public void TC_01_Remove_Product() {
		wishlistPage = customerInfor.openWishlistPage(driver);

		wishlistPage.clickToProductByName("Lenovo IdeaCentre 600 All-in-One PC");
		wishlistPage.clickToAddToWishlistButton();
		verifyTrue(wishlistPage.isMessageDisplay());
		wishlistPage.closeMessage();
		wishlistPage.clickToWishlistLink();
		verifyTrue(wishlistPage.isInfoProductsDisplayed("LE_IC_600", "Lenovo IdeaCentre 600 All-in-One PC", "$500.00"));
		verifyTrue(wishlistPage.isTitlePage("Wishlist"));
		wishlistPage.clickToCheckBoxByName("Lenovo IdeaCentre 600 All-in-One PC");
		wishlistPage.clickToRemoveButtonByName("Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(wishlistPage.isMessageNoData(), "The wishlist is empty!");
	}

	@Test
	public void TC_02_Add_To_Wishlist() {

		wishlistPage.hoverToComputerLink();
		wishlistPage.clickToDesktopLink();

		wishlistPage.clickToProductByName("Digital Storm VANQUISH 3 Custom Performance PC");
		wishlistPage.clickToAddToWishlistButton();
		verifyTrue(wishlistPage.isMessageDisplay());
		wishlistPage.closeMessage();
		wishlistPage.clickToWishlistLink();

		verifyTrue(wishlistPage.isInfoProductsDisplayed("DS_VA3_PC", "Digital Storm VANQUISH 3 Custom Performance PC",
				"$1,259.00"));

	}

	@Test
	public void TC_03_Add_To_Shopping_Cart() {
		verifyTrue(wishlistPage.isTitlePage("Wishlist"));
		wishlistPage.clickToCheckBoxByName("Digital Storm VANQUISH 3 Custom Performance PC");
		wishlistPage.clickToAddToCartButton();
		verifyTrue(wishlistPage.isTitlePage("Shopping cart"));
		verifyTrue(wishlistPage.isInfoProductsDisplayed("DS_VA3_PC", "Digital Storm VANQUISH 3 Custom Performance PC",
				"$1,259.00"));
		wishlistPage.clickToWishlistLink();
		verifyEquals(wishlistPage.isMessageNoData(), "The wishlist is empty!");
	}

	@Test
	public void TC_04_Add_To_CompareList() {
		comparePage = PageGenerator.getComparePage(driver);
		comparePage.hoverToComputerLink();
		comparePage.clickToNotebookLink();
		comparePage.clickAddToComparePageByName("Asus N551JK-XO076H Laptop");
		comparePage.clickAddToComparePageByName("Apple MacBook Pro 13-inch");
		comparePage.clickComparePageLink();
		verifyTrue(comparePage.isInfoProductsDisplayedByName("Name", "Asus N551JK-XO076H Laptop",
				"Asus N551JK-XO076H Laptop"));
		verifyTrue(comparePage.isInfoProductsDisplayed("Price", "$1,500.00", "$1,500.00"));
		verifyTrue(comparePage.isInfoProductsDisplayed("CPU Type", "Intel Core i7", "Intel Core i7"));
		verifyTrue(comparePage.isInfoProductsDisplayed("Memory", "16 GB", "16 GB"));
		verifyTrue(comparePage.isInfoProductsDisplayed("Hard drive", "11 TB", "11 TB"));

		verifyTrue(comparePage.isInfoProductsDisplayedByName("Name", "Apple MacBook Pro 13-inch",
				"Apple MacBook Pro 13-inch"));
		verifyTrue(comparePage.isInfoProductsDisplayed("Price", "$1,800.00", "$1,800.00"));
		verifyTrue(comparePage.isInfoProductsDisplayed("CPU Type", "Intel Core i5", "Intel Core i5"));
		verifyTrue(comparePage.isInfoProductsDisplayed("Memory", "4 GB", "4 GB"));
		verifyTrue(comparePage.isInfoProductsDisplayed("Hard drive", "", ""));

		comparePage.clickToClearListButton();
		verifyEquals(comparePage.getTextMessage(), "You have no items to compare.");
	}

	@Test
	public void TC_05_Verify_Detial_Product() {
		comparePage = PageGenerator.getComparePage(driver);
		comparePage.hoverToComputerLink();
		comparePage.clickToNotebookLink();
		verifyTrue(comparePage.infoDetialProduct("Apple MacBook Pro 13-inch", "$1,800.00"));
		verifyTrue(comparePage.infoDetialProduct("Asus N551JK-XO076H Laptop", "$1,500.00"));
		verifyTrue(comparePage.infoDetialProduct("Samsung Series 9 NP900X4C Premium Ultrabook", "$1,590.00"));
		verifyTrue(comparePage.infoDetialProduct("HP Spectre XT Pro UltraBook", "$1,350.00"));
		verifyTrue(comparePage.infoDetialProduct("HP Envy 6-1180ca 15.6-Inch Sleekbook", "$1,460.00"));
		comparePage.clickToRecentlyViewProducts();
		verifyEquals(comparePage.countProducts(), "3");
		verifyTrue(comparePage.infoDetialProduct("Build your own computer", "$1,200.00"));
		verifyTrue(comparePage.infoDetialProduct("Lenovo IdeaCentre 600 All-in-One PC", "$500.00"));
		verifyTrue(comparePage.infoDetialProduct("Digital Storm VANQUISH 3 Custom Performance PC", "$1,259.00"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
