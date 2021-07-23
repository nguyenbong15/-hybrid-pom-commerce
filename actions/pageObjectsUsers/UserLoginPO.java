package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.UserCustomerInfoPageUI;
import pageUIsUser.UserLoginPageUI;

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

	public UserCustomerInfoPO clickToLoginButton() {
		waitToElementclickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  UserLoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getUserCustomerInfoPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		
		return isElementDisplayed(driver, UserLoginPageUI.MYACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		
		return isElementDisplayed(driver, UserLoginPageUI.LOGOUT_LINK);
	}

	public boolean isRegesterLinkUnDisplayed() {
		waitToElementInvisible(driver, UserLoginPageUI.REGESTER_LINK);
		return isElementUnDisplayed(driver, UserLoginPageUI.REGESTER_LINK);
	}

	
	public boolean isLoginLinkUnDisplayed() {
		waitToElementInvisible(driver, UserLoginPageUI.LOGIN_LINK);
		return isElementUnDisplayed(driver, UserLoginPageUI.LOGIN_LINK);
	}

	public String getEmailLoginError() {
	waitToElementVisible(driver, UserLoginPageUI.EMAIL_ERROR);
		return getTextElement(driver, UserLoginPageUI.EMAIL_ERROR);
	}

	public String getEmailNotExitError() {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_NOT_EXIST_ERROR);
		return getTextElement(driver, UserLoginPageUI.EMAIL_NOT_EXIST_ERROR);
	}

	public UserCustomerInfoPO loginToSystem(String email,String passWord) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXBOX);
		senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXBOX, email);
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXBOX);
		senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXBOX, passWord);
		waitToElementclickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  UserLoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getUserCustomerInfoPage(driver);
	}

	public void clickToMyAccountLink() {
		waitToElementclickable(driver, UserLoginPageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserLoginPageUI.MYACCOUNT_LINK);
		
	}

	

}
