package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.UserChangePasswordPageUI;

public class UserChangePasswordPO extends AbstractPage {
	WebDriver driver;
	   public UserChangePasswordPO(WebDriver driver) {
		   this.driver=driver;
	   }
	public void inputOldPassword(String password) {
		waitToElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXBOX, password);
		
	}
	public void ipnutNewPassword(String newPassWord) {
		waitToElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXBOX, newPassWord);
		
	}
	public void inputConfirmNewPassword(String newPassWord) {
		waitToElementVisible(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXBOX, newPassWord);
		
	}
	public void clickToChangePasswordButton() {
	waitToElementclickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		
	}
}
