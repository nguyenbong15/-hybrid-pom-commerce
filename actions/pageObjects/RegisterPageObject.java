package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToGenderMaleRadio() {
		waitToElementclickable(driver, RegisterPageUI.GENDERMALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDERMALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, RegisterPageUI.FIRST_NAME);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, RegisterPageUI.LAST_NAME);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME, lastName);

	}

	public void selectDayDropdown(String day) {
		waitToElementclickable(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);

	}

	public void selectMonthDropdown(String month) {
		waitToElementclickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementclickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);

	}

	public void inputToEmailTexbox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTexbox(String companyName) {
		waitToElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);

	}

	public void inputToPasswordTexbox(String passWord) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);
	}

	public void inputToConfirmPasswordTexbox(String passWord) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, passWord);

	}

	public void clickToRegisterButton() {
		waitToElementclickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getTextRegisterSuccessMessage() {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return getTextElement(driver, RegisterPageUI.REGISTER_MESSAGE_SUCCESS );
	}

	public void clickToLogoutLink() {
		waitToElementclickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		
	}

	

}
