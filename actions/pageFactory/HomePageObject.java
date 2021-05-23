package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import   pageFactory.AbstractPage_Factory;
public class HomePageObject extends AbstractPage_Factory {
	
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement regesterLink;
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myaccountLink;

	public void clickToRegisterLink() {
		waitToElementclickable(driver, regesterLink);
		clickToElement(driver, regesterLink);
	}

	public void clickToLoginLink() {
		waitToElementclickable(driver, loginLink);
		clickToElement(driver, loginLink);

	}

	public void clickToMyAccountLink() {
		waitToElementclickable(driver, myaccountLink);
		clickToElement(driver, myaccountLink);

	}

}
