package pageObjectAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjectsUsers.PageGenerator;
import pageUIAdmin.AdminLoginPageUI;

public class AdminLoginPagePO extends AbstractPage {
	WebDriver driver;

	public AdminLoginPagePO(WebDriver driver) {
		this.driver = driver;

	}
	public void inputToEmailTexbox(String email) {
		waitToElementVisible(driver, AdminLoginPageUI.EMAIL_TEXBOX);
		senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXBOX, email);
	}
	public void inputToPasswordTexbox(String password) {
		waitToElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXBOX, password);
	}

	public AdminDashboardPagePO clickToLoginButton() {
		waitToElementclickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getAdminDashboardPage(driver);
		
	}
	public AdminDashboardPagePO loginToSystem(String email, String password) {
		inputToEmailTexbox(email);
		inputToPasswordTexbox(password);
		clickToLoginButton();
		return PageGenerator.getAdminDashboardPage(driver);

	}
}
