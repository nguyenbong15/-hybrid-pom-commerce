package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage_Factory {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement emailTexbox;
	@FindBy(id = "Password")
	WebElement passwordTexbox;
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement buttonLogin;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;

	public void senkeyToEmailTexbox(String email) {
		waitToElementclickable(driver, emailTexbox);
		senkeyToElement(driver, emailTexbox, email);

	}

	public void senkeyToPassWordTexbox(String passWord) {
		waitToElementVisible(driver, passwordTexbox);
		senkeyToElement(driver, passwordTexbox, passWord);

	}

	public void clickToLoginButton() {
		waitToElementclickable(driver, buttonLogin);
		clickToElement(driver, buttonLogin);
	}

	public boolean isMyAccountLinkDisplayed() {

		return isElementDisplayed(driver, myAccountLink);
	}

	public boolean isLogoutLinkDisplayed() {

		return isElementDisplayed(driver, logoutLink);
	}

}
