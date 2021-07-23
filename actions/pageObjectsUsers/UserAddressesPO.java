package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.UserAddressPageUI;
import pageUIsUser.UserCustomerInfoPageUI;

public class UserAddressesPO extends AbstractPage{
	WebDriver driver;
	public UserAddressesPO( WebDriver driver) {
		this.driver=driver;
		
	}
	public void clickToAddNewButton() {
		waitToElementclickable(driver, UserAddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver,  UserAddressPageUI.ADD_NEW_BUTTON);
	}
	public void inputToFirstName(String value ) {
		waitToElementVisible(driver, UserAddressPageUI.FIRST_NAME);
		senkeyToElement(driver, UserAddressPageUI.FIRST_NAME, value);
		
	}
	public void inputToLastName(String value) {
		waitToElementVisible(driver, UserAddressPageUI.LAST_NAME);
		senkeyToElement(driver, UserAddressPageUI.LAST_NAME, value);
		
	}
	public void inputToEmail(String value) {
		waitToElementVisible(driver, UserAddressPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserAddressPageUI.EMAIL_TEXTBOX, value);
		
	}
	public void inputToCity(String value) {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS_CITY);
		senkeyToElement(driver, UserAddressPageUI.ADDRESS_CITY, value);
		
	}
	public void inputToAddress1(String value) {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS1_TEXTBOX);
		senkeyToElement(driver, UserAddressPageUI.ADDRESS1_TEXTBOX, value);
		
	}
	public void inputToZipCode(String value) {
		waitToElementVisible(driver, UserAddressPageUI.ZIPPOSTALCODE_TEXTBOX);
		senkeyToElement(driver, UserAddressPageUI.ZIPPOSTALCODE_TEXTBOX, value);
		
	}
	public void inputToPhoneNumber(String value) {
		waitToElementVisible(driver, UserAddressPageUI.PHONENUMBER_TEXTBOX);
		senkeyToElement(driver, UserAddressPageUI.PHONENUMBER_TEXTBOX, value);
		
	}
	public void clickToSaveButton() {
		waitToElementclickable(driver, UserAddressPageUI.SAVE_BUTTON);
		clickToElement(driver,  UserAddressPageUI.SAVE_BUTTON);
	}
	public String getName() {
		waitToElementVisible(driver, UserAddressPageUI.NAME_VERIFY);
		return getTextElement(driver, UserAddressPageUI.NAME_VERIFY);
	}
	public String getEmail() {
		waitToElementVisible(driver, UserAddressPageUI.EMAIL_VERIFY);
		return getTextElement(driver, UserAddressPageUI.EMAIL_VERIFY);
	}
	public String getPhoneNumber() {
		waitToElementVisible(driver, UserAddressPageUI.PHONENUMBER__VERIFY);
		return getTextElement(driver, UserAddressPageUI.PHONENUMBER__VERIFY);
	}
	public String getFaxNumber() {
		waitToElementVisible(driver, UserAddressPageUI.FAX_NUMBER);
		return getTextElement(driver, UserAddressPageUI.FAX_NUMBER);
	}
	public String getCityAndZipCode() {
		waitToElementVisible(driver, UserAddressPageUI.ZIPCODE_VERIFY);
		return getTextElement(driver, UserAddressPageUI.ZIPCODE_VERIFY);
	}
	public String getAdrress() {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS1_VERIFY);
		return getTextElement(driver, UserAddressPageUI.ADDRESS1_VERIFY);
	}
	public String getCountry() {
		waitToElementVisible(driver, UserAddressPageUI.COUNTRY__VERIFY);
		return getTextElement(driver, UserAddressPageUI.COUNTRY__VERIFY);
	}
	public void selectCountry(String country) {
		waitToElementclickable(driver, UserAddressPageUI.COUNTRY__DROPDOWN);
		selectItemInDropdown(driver,  UserAddressPageUI.COUNTRY__DROPDOWN, country);
		
	}
	
}
