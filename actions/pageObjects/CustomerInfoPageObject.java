package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;
import pageUIs.RegisterPageUI;

public class CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;
	public CustomerInfoPageObject( WebDriver driver) {
		this.driver=driver;
		
	}

	public boolean isGenderMaleRadioSelected() {
		return isElementSelected(driver, CustomerInfoPageUI.GENDERMALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.FIRST_NAME);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME,"value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.LAST_NAME);
		return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME,"value");
	}

	public String getSelectedTextDayInDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextMonthInDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextYearInDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextBoxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX,"value");
	}

	public boolean isNewsletterSelected() {
		
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}


	

	

}
