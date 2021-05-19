package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	 WebDriver driver;
		public LoginPageObject( WebDriver driver) {
			this.driver=driver;
			
		}

	public void senkeyToEmailTexbox(String email) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_TEXBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXBOX, email);
		
	}

	public void senkeyToPassWordTexbox(String passWord) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXBOX, passWord);
		
	}

	public void clickToLoginButton() {
		waitToElementclickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isMyAccountLinkDisplayed() {
		
		return isElementDisplayed(driver, LoginPageUI.MYACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		
		return isElementDisplayed(driver, LoginPageUI.LOGOUT_LINK);
	}

}
