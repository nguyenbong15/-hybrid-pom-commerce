package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserCompareProductsPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserOrderPagePO;
import pageObjectsUsers.UserRegisterPO;
import pageObjectsUsers.UserWishlistPagePO;

public class User_07_Order_Edit_Remove_Update_Payment_Shopping_Cart extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserCustomerInfoPO customerInfor;
	UserWishlistPagePO wishlistPage;
	UserCompareProductsPO comparePage;
	UserOrderPagePO orderPage;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		// homePageObject = PageGenerator.getUserHomePage(driver);
//		 loginPageObject = homePageObject.clickToLoginLink();
//		 customerInfor = loginPageObject.loginToSystem(Common_01_Register.email,
//		 Common_01_Register.passWord);
		orderPage = PageGenerator.getOrderPage(driver);
	}

	// @Test
	public void TC_01_Add_Product_To_Cart() {

		orderPage.clickToComputer();
		orderPage.clickToDeskRop();
		orderPage.clickToProductBy("Build your own computer");
		orderPage.chooseItemInProcessorDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		orderPage.chooseItemInRamDropdown("8GB [+$60.00]");
		orderPage.clickTo400GBHHDRadio();
		orderPage.clickToOsVistaPremiumRadio();
		orderPage.clickToMicrosoftOfficeCheckBox();
		orderPage.clickToAcrobatReaderCheckBox();
		orderPage.clickToTotalCommanderCheckBox();
		orderPage.clickToAddToCart();
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		verifyEquals(orderPage.getNumberProductInCart(), "(1)");
		verifyEquals(orderPage.getNumberItemInCart(), "1 item(s)");
		verifyEquals(orderPage.nameProductsDisplayed(), "Build your own computer");
		verifyEquals(orderPage.attributeProductsDisplayed(),
				"Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\n" + "RAM: 8GB [+$60.00]\n"
						+ "HDD: 400 GB [+$100.00]\n" + "OS: Vista Premium [+$60.00]\n"
						+ "Software: Microsoft Office [+$50.00]\n" + "Software: Acrobat Reader [+$10.00]\n"
						+ "Software: Total Commander [+$5.00]");

		verifyEquals(orderPage.getUnitPrices(), "$1,500.00");
		verifyEquals(orderPage.getQuantity(), "1");
		verifyEquals(orderPage.getTotalPrice(), "$1,500.00");

	}

	// @Test(dependsOnMethods = "TC_01_Add_Product_To_Cart")
	public void TC_02_Edit_Product() {
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		orderPage.clickToEditLink();
		orderPage.chooseItemInProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");
		orderPage.chooseItemInRamDropdown("4GB [+$20.00]");
		orderPage.clickTo320GBHHDRadio();
		orderPage.clickToOsVistaHomeRadio();
		orderPage.clickToMicrosoftOfficeCheckBox();
		orderPage.unCheckAcrobatReaderCheckBox();
		orderPage.unCheckTotalCommanderCheckBox();
		orderPage.inputNumberProducts("2");
		verifyEquals(orderPage.getPriceProduct(), "$1,320.00");
		orderPage.clickToUpdateButton();
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		verifyEquals(orderPage.getNumberProductInCart(), "(2)");
		verifyEquals(orderPage.getNumberItemInCart(), "2 item(s)");
		verifyEquals(orderPage.nameProductsDisplayed(), "Build your own computer");
		verifyEquals(orderPage.attributeProductsDisplayed(),
				"Processor: 2.2 GHz Intel Pentium Dual-Core E2200\n" + "RAM: 4GB [+$20.00]\n" + "HDD: 320 GB\n"
						+ "OS: Vista Home [+$50.00]\n" + "Software: Microsoft Office [+$50.00]");
		verifyEquals(orderPage.getUnitPrices(), "$1,320.00");
		verifyEquals(orderPage.getQuantity(), "2");
		verifyEquals(orderPage.getTotalPrice(), "$2,640.00");

	}

	// @Test(dependsOnMethods = "TC_02_Edit_Product")
	public void TC_03_Remove_Product() {
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		orderPage.clickToRemoveIcon();
		verifyEquals(orderPage.getTextMessage(), "Your Shopping Cart is empty!");
	}

	@Test
	public void TC_04_Update_Shopping_cart() {
		orderPage.clickToComputer();
		orderPage.clickToDeskRop();
		orderPage.addToCartByName("Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		verifyEquals(orderPage.getTotalPriceInShoppingCartByName("Lenovo IdeaCentre 600 All-in-One PC"), "$500.00");
		orderPage.inputQuantityTextBox("5", "Lenovo IdeaCentre 600 All-in-One PC");
		orderPage.clickUpdateShoppingCartButton();
		verifyEquals(orderPage.getTotalPriceInShoppingCartByName("Lenovo IdeaCentre 600 All-in-One PC"), "$2,500.00");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
