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

	public void clickToMyaccountLink() {
	waitToElementclickable(driver, UserCustomerInfoPageUI.MYACCOUNT_LINK);
	clickToElement(driver,  UserCustomerInfoPageUI.MYACCOUNT_LINK);
		
	}

	public void clickToFemaleRadio() {
		waitToElementclickable(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		
	}

	public void editFristName(String value) {
		waitToElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME);
		senkeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME, value);
		
	}

	public void editLastName(String value) {
		waitToElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME);
		senkeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME, value);
		
	}

	public void editSelectDay(String itemValue) {
	waitToElementclickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	selectItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN, itemValue);
		
	}

	public void editSelectMonth(String itemValue) {
		waitToElementclickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN, itemValue);
		
	}

	public void editSelectYear(String itemValue) {
		waitToElementclickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN, itemValue);
		
	}

	public void editCompany(String value) {
		waitToElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, value);
		
	}

	public boolean isGenderFemaleRadioSelected() {
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public UserHomePO clickToLogoutLink() {
		waitToElementclickable(driver, UserCustomerInfoPageUI.LOGOUT_LINK);
		clickToElement(driver,  UserCustomerInfoPageUI.LOGOUT_LINK);
		return PageGenerator.getUserHomePage(driver);
	}


	

	

}
