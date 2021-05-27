package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInfoPageUI;
import pageUIs.UserRegisterPageUI;

public class UserCustomerInfoPO extends AbstractPage {
	WebDriver driver;
	public UserCustomerInfoPO( WebDriver driver) {
		this.driver=driver;
		
	}

	public boolean isGenderMaleRadioSelected() {
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDERMALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME,"value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME,"value");
	}

	public String getSelectedTextDayInDropdown() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextMonthInDropdown() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextYearInDropdown() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextBoxValue() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX,"value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX,"value");
	}

	public boolean isNewsletterSelected() {
		
		return isElementSelected(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}


	

	

}
