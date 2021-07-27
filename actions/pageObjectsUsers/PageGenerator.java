package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import pageObjectAdmin.AdminDashboardPagePO;
import pageObjectAdmin.AdminLoginPagePO;
import pageObjectAdmin.AdminProductsPagePO;

public class PageGenerator {
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

	public static UserSearchPagePO getSearchPage(WebDriver driver) {

		return new UserSearchPagePO(driver);
	}

	public static UserSortDisplayPagingPO getSortDisplayPagingPage(WebDriver driver) {

		return new UserSortDisplayPagingPO(driver);
	}

	public static UserWishlistPagePO getWishlistPage(WebDriver driver) {

		return new UserWishlistPagePO(driver);
	}

	public static UserCompareProductsPO getComparePage(WebDriver driver) {
		return new UserCompareProductsPO(driver);
		}
	public static UserOrderPagePO getOrderPage(WebDriver driver) {
		return new UserOrderPagePO(driver);
		}
	
}
