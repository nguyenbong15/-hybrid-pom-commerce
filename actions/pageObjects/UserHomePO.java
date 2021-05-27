package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

import pageUIs.UserHomePageUI;

public class UserHomePO extends AbstractPage {

	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;

	}

	public UserRegisterPO clickToRegisterLink() {
		waitToElementclickable(driver, UserHomePageUI.REGESTER_LINK);
		clickToElement(driver, UserHomePageUI.REGESTER_LINK);
		return PageGenerator.getUserRegesterPage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementclickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
	}

	public UserCustomerInfoPO clickToMyAccountLink() {
		waitToElementclickable(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
       return PageGenerator.getUserCustomerInfoPage(driver);
	}
}
