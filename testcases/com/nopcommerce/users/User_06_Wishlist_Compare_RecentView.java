package com.nopcommerce.users;

import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserAddressesPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserMyProductReviewPO;
import pageObjectsUsers.UserOrderPO;
import pageObjectsUsers.UserRegisterPO;
import pageObjectsUsers.UserSearchPagePO;
import pageObjectsUsers.UserWishlistPagePO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;

import javax.sql.rowset.serial.SerialArray;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_06_Wishlist_Compare_RecentView extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserCustomerInfoPO customerInfor;
	UserWishlistPagePO wishlistPage;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		homePageObject = PageGenerator.getUserHomePage(driver);
		loginPageObject = homePageObject.clickToLoginLink();
		customerInfor = loginPageObject.loginToSystem(Common_01_Register.email, Common_01_Register.passWord);

	}
	//@Test
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
	//	  wishlistPage = customerInfor.openWishlistPage(driver);
		
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

	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
