package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjectAdmin.AdminDashboardPagePO;
import pageObjectAdmin.AdminLoginPagePO;
import pageObjectAdmin.AdminProductsPagePO;
import pageObjectsUsers.PageGenerator;

public class Admin_01_Search extends AbstractTest {

	WebDriver driver;
	AdminLoginPagePO loginPage;
	AdminDashboardPagePO dashboardPage;
	AdminProductsPagePO productsPagePO;
	String email,password,productName;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {
        email="admin@yourstore.com";
        password="admin";
        productName="Lenovo IdeaCentre 600 All-in-One PC";
		driver = getBrowserName(browser, urlValue);
		loginPage=PageGenerator.getAdminLoginPage(driver);
		dashboardPage=loginPage.loginToSystem(email, password);
		productsPagePO=dashboardPage.openProductPage();
	}
	@Test
	public void TC_01_Search_With_Product_Name() {
		productsPagePO.clickToShowSearchPage();
		productsPagePO.inputProductName(productName);
		productsPagePO.clickToSearchButton();
	    verifyTrue(productsPagePO.isProductInfoInRowTableDisplayed(productName, "LE_IC_600", "500", "10000"));
        verifyTrue(productsPagePO.isPublishedStatusDisplayed("Published", "1", "true"));
	}

	@Test
	public void TC_02_Search_With_Name_And_Parent_Category_And_UncheckSearch() {
		productsPagePO.inputProductName(productName);
		productsPagePO.chooseItemInCategoryDropdown("Computers");
		productsPagePO.uncheckToSearchSubcategoriesCheckbox();
		productsPagePO.clickToSearchButton();
		verifyTrue(productsPagePO.isMessageNoItemDisplayed());
       
	}
	@Test
	public void TC_03_Search_With_Name_And_Parent_Category_CheckSearchCategory() {
		productsPagePO.inputProductName(productName);
		productsPagePO.chooseItemInCategoryDropdown("Computers");
		productsPagePO.checkToSearchSubcategoriesCheckbox();
		productsPagePO.clickToSearchButton();
		verifyTrue(productsPagePO.isProductInfoInRowTableDisplayed(productName, "LE_IC_600", "500", "10000"));
	    verifyTrue(productsPagePO.isPublishedStatusDisplayed("Published", "1", "true"));
       
	}
	@Test
	public void TC_04_Search_With_Name_And_Child_Category_unCheckSearchCategory() {
		productsPagePO.inputProductName(productName);
		productsPagePO.chooseItemInCategoryDropdown("Computers >> Desktops");
		productsPagePO.uncheckToSearchSubcategoriesCheckbox();
		productsPagePO.clickToSearchButton();
		verifyTrue(productsPagePO.isProductInfoInRowTableDisplayed(productName, "LE_IC_600", "500", "10000"));
		verifyTrue(productsPagePO.isPublishedStatusDisplayed("Published", "1", "true"));
		
	}
	@Test
	public void TC_05_Search_With_Product_Name_And_Manufacturer() {
		productsPagePO.inputProductName(productName);
		productsPagePO.chooseItemInCategoryDropdown("All");
		productsPagePO.uncheckToSearchSubcategoriesCheckbox();
		productsPagePO.chooseItemInManufacturerDropdown("Apple");
		productsPagePO.clickToSearchButton();
		verifyTrue(productsPagePO.isMessageNoItemDisplayed());
       
	}
	@Test
	public void TC_06_Search_With_SKU() {
		productsPagePO=dashboardPage.openProductPage();
		productsPagePO.clickToShowSearchPage();
		productsPagePO.inputSkuTextBox("LE_IC_600");
		productsPagePO.clickToGoButton();
		productsPagePO.clickToHideButtonByIdPage(driver,"product-info");
		verifyTrue(productsPagePO.isProducInfoPageDisplayed());
		verifyEquals(productsPagePO.getNameProducts(), productName);
		verifyEquals(productsPagePO.getSkuProducts(), "LE_IC_600");
		verifyTrue(productsPagePO.statusPulisherProductIsTrue());
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
