package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserOrderPO extends AbstractPage {
	WebDriver driver;
	public UserOrderPO( WebDriver driver) {
		this.driver=driver;
		
	}
}
