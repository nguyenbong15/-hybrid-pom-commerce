package pageObjects;

import org.openqa.selenium.WebDriver;



public class PageGenerator{
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}

	public static UserRegisterPO getUserRegesterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	public static UserMyProductReviewPO getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserOrderPO getUserOrderPage(WebDriver driver) {
		return new UserOrderPO(driver);
	}

	public static AdminLoginPagePO getAdminLoginPage(WebDriver driver) {
		
		return new AdminLoginPagePO(driver);
	}

	public static AdminDashboardPagePO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPagePO(driver);
	}

	public static AdminProductsPagePO getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPagePO(driver);
	}

	public static UserChangePasswordPO getChangePasswordPage(WebDriver driver) {
		
		return new UserChangePasswordPO(driver);
	}

	
	
}
