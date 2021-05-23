package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementclickable(driver, HomePageUI.REGESTER_LINK);
		clickToElement(driver, HomePageUI.REGESTER_LINK);
		return PageGenerator.getRegesterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementclickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitToElementclickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
       return PageGenerator.getCustomerInfoPage(driver);
	}
}
