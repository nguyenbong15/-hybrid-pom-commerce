package com.nopcommerce.learn;

import org.testng.annotations.Test;

import commons.AbstractTest;
import facebook.web.users.package_info;
import pageObjectAdmin.AdminDashboardPagePO;
import pageObjectAdmin.AdminLoginPagePO;
import pageObjectAdmin.AdminProductsPagePO;
import pageObjectsUsers.PageGenerator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Upload_File extends AbstractTest {

	WebDriver driver;
	AdminLoginPagePO loginPage;
	AdminDashboardPagePO dashboardPage;
	AdminProductsPagePO productsPage;
    String filename="image_01.png";
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		loginPage = PageGenerator.getAdminLoginPage(driver);
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productsPage = dashboardPage.openProductPage();
	}

	
	@Test
	public void TC_04_Upload_File_Product() {
		productsPage.inputProductName("Apple MacBook Pro 13-inch");
		productsPage.clickToSearchButton();
		//Assert.assertTrue(productsPage.isSearchProductInfoDisplayed());
		productsPage.clickToEditByProductName("Apple MacBook Pro 13-inch");
		productsPage.scrollToPicturePanel();
		
		productsPage.clickToHideButtonByIdPage(driver,"product-info");
		productsPage.upLoadFilePicture(driver,"product-pictures", filename); 
		productsPage.inputToAlt("altPicture");
		productsPage.inputToTitle("image");
		productsPage.inputToDisplayOrder("1");
		productsPage.clickToAddProductPicture();
		//productsPage.clictToSaveButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
