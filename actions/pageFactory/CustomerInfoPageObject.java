package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUIsUser.UserCustomerInfoPageUI;
import pageUIsUser.UserRegisterPageUI;

public class CustomerInfoPageObject extends AbstractPage_Factory {
	WebDriver driver;
	public CustomerInfoPageObject( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement gendermaleRadio;
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastName;
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dayDropdown;
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement monthDropdown;
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement yearDropdown;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTexbox;
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyTexbox;
	@FindBy(xpath = "//input[@id='Newsletter']")
	WebElement newletterTexbox;

	public boolean isGenderMaleRadioSelected() {
		return isElementSelected(driver, gendermaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, firstName);
		return getElementAttribute(driver,firstName,"value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, lastName);
		return getElementAttribute(driver, lastName,"value");
	}

	public String getSelectedTextDayInDropdown() {
		waitToElementVisible(driver,dayDropdown);
		return getFirstSelectedTextInDropdown(driver,dayDropdown);
	}

	public String getSelectedTextMonthInDropdown() {
		waitToElementVisible(driver,monthDropdown);
		return getFirstSelectedTextInDropdown(driver,monthDropdown);
	}

	public String getSelectedTextYearInDropdown() {
		waitToElementVisible(driver,yearDropdown);
		return getFirstSelectedTextInDropdown(driver,yearDropdown);
	}

	public String getEmailTextBoxValue() {
		waitToElementVisible(driver,emailTexbox);
		return getElementAttribute(driver,emailTexbox,"value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver,companyTexbox);
		return getElementAttribute(driver,companyTexbox,"value");
	}

	public boolean isNewsletterSelected() {
		
		return isElementSelected(driver,newletterTexbox);
	}

}
