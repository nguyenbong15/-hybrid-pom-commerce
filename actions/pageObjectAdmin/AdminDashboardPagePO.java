package pageObjectAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjectsUsers.PageGenerator;
import pageUIAdmin.AdminDashboardPageUI;
import pageUIAdmin.AdminProductPageUI;

public class AdminDashboardPagePO extends AbstractPage{
	WebDriver driver;
	public AdminDashboardPagePO( WebDriver driver) {
		this.driver=driver;
		
	}
	public AdminProductsPagePO openProductPage() {
		waitToElementclickable(driver, AdminDashboardPageUI.CATALOG_LINK);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_LINK);
		waitToElementVisible(driver, AdminDashboardPageUI.PRODUCTS_LINK);
		waitToElementclickable(driver, AdminDashboardPageUI.PRODUCTS_LINK);
		clickToElement(driver, AdminDashboardPageUI.PRODUCTS_LINK);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
		//waitToElementPresent(driver, AdminProductPageUI.ALL_PRODUCTS,Integer.parseInt(getFirstSelectedTextInDropdown(driver, AdminProductPageUI.NUMBER_PRODUCT_DROPDOWN)));
		return PageGenerator.getAdminProductsPage(driver);
	}
	public AdminCustomerPagePO openCustomerPage() {
		waitToElementclickable(driver, AdminDashboardPageUI.CUSTOMERS_LINK);
		clickToElement(driver, AdminDashboardPageUI.CUSTOMERS_LINK);
		waitToElementVisible(driver, AdminDashboardPageUI.CUSTOMERS_IN_CUSTOMERS_LINK);
		waitToElementclickable(driver, AdminDashboardPageUI.CUSTOMERS_IN_CUSTOMERS_LINK);
		clickToElement(driver, AdminDashboardPageUI.CUSTOMERS_IN_CUSTOMERS_LINK);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
		//waitToElementPresent(driver, AdminProductPageUI.ALL_PRODUCTS,Integer.parseInt(getFirstSelectedTextInDropdown(driver, AdminProductPageUI.NUMBER_PRODUCT_DROPDOWN)));
		return PageGenerator.getAdminCustomerPage(driver);
	}
}
