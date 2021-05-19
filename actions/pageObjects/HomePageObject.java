package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
  WebDriver driver;
	public HomePageObject( WebDriver driver) {
		this.driver=driver;
		
	}

	public void clickToRegisterLink() {
		waitToElementclickable(driver, HomePageUI.REGESTER_LINK);
		clickToElement(driver, HomePageUI.REGESTER_LINK);
	}

	public void clickToLoginLink() {
		waitToElementclickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public void clickToMyAccountLink() {
		waitToElementclickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		
	}

	
}
