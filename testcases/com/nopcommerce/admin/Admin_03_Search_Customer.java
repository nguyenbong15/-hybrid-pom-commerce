package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjectAdmin.AdminCustomerPagePO;
import pageObjectAdmin.AdminDashboardPagePO;
import pageObjectAdmin.AdminLoginPagePO;
import pageObjectAdmin.AdminProductsPagePO;
import pageObjectsUsers.PageGenerator;

public class Admin_03_Search_Customer extends AbstractTest {

	WebDriver driver;
	AdminLoginPagePO loginPage;
	AdminDashboardPagePO dashboardPage;
	AdminProductsPagePO productsPagePO;
	AdminCustomerPagePO customerPage;
	String email,password;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {
        email="admin@yourstore.com";
        password="admin";
        driver = getBrowserName(browser, urlValue);
		loginPage=PageGenerator.getAdminLoginPage(driver);
		dashboardPage=loginPage.loginToSystem(email, password);
		customerPage=dashboardPage.openCustomerPage();
	}
	@Test
	public void TC_01_Search_Customer_With_Email() {
		
	}

	@Test
	public void TC_02_Search_With_Name_And_Parent_Category_And_UncheckSearch() {
	
       
	}
	@Test
	public void TC_03_Search_With_Name_And_Parent_Category_CheckSearchCategory() {

	}
	@Test
	public void TC_04_Search_With_Name_And_Child_Category_unCheckSearchCategory() {
		
		
	}
	@Test
	public void TC_05_Search_With_Product_Name_And_Manufacturer() {
		
       
	}
	@Test
	public void TC_06_Search_With_SKU() {
	
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
