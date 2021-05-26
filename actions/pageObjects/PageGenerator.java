package pageObjects;

import org.openqa.selenium.WebDriver;



public class PageGenerator{
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegesterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
}
