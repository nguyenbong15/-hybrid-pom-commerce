package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserLoginPageUI;

public class UserLoginPO extends AbstractPage {
	 WebDriver driver;
		public UserLoginPO( WebDriver driver) {
			this.driver=driver;
			
		}

	public void senkeyToEmailTexbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXBOX);
		senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXBOX, email);
		
	}

	public void senkeyToPassWordTexbox(String passWord) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXBOX);
		senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXBOX, passWord);
		
	}

	public void clickToLoginButton() {
		waitToElementclickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  UserLoginPageUI.LOGIN_BUTTON);
	}

	public boolean isMyAccountLinkDisplayed() {
		
		return isElementDisplayed(driver, UserLoginPageUI.MYACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		
		return isElementDisplayed(driver, UserLoginPageUI.LOGOUT_LINK);
	}

}
