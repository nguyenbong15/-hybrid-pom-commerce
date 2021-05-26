package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class OrderPageObject extends AbstractPage {
	WebDriver driver;
	public OrderPageObject( WebDriver driver) {
		this.driver=driver;
		
	}
}
