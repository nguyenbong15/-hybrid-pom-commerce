package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import facebook.web.users.package_info;
import pageObjects.AdminDashboardPagePO;
import pageObjects.AdminLoginPagePO;
import pageObjects.AdminProductsPagePO;
import pageObjects.PageGenerator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_Web_Data_Table extends AbstractTest {

	WebDriver driver;
	AdminLoginPagePO loginPage;
	AdminDashboardPagePO dashboardPage;
	AdminProductsPagePO productsPage;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		loginPage = PageGenerator.getAdminLoginPage(driver);
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productsPage = dashboardPage.openProductPage();
	}

	//@Test
	public void TC_01_Click_Page_Index() {
		productsPage.clickToPageIndex("1");
		Assert.assertTrue(productsPage.isNumberPageTableDisplayed("1"));
		productsPage.sleepSecond(2);
		productsPage.clickToPageIndex("2");
		Assert.assertTrue(productsPage.isNumberPageTableDisplayed("2"));
		productsPage.sleepSecond(2);
		productsPage.clickToPageIndex("3");
		Assert.assertTrue(productsPage.isNumberPageTableDisplayed("3"));
		productsPage.sleepSecond(2);
		productsPage.clickToPageIndex("1");
		Assert.assertTrue(productsPage.isNumberPageTableDisplayed("1"));
		productsPage.sleepSecond(2);
		
	}
	@Test
	public void TC_02_Selected_All() {
		productsPage.clickSelectAll();
		productsPage.areAllProductSelected();
		productsPage.sleepSecond(2);
		productsPage.clickToUnSelectAll();
		productsPage.areAllProductUnSelected();
		productsPage.sleepSecond(2);
		
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
