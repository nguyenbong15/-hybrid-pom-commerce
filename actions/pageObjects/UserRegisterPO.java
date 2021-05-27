package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;

	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToGenderMaleRadio() {
		waitToElementclickable(driver, UserRegisterPageUI.GENDERMALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDERMALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRST_NAME);
		senkeyToElement(driver, UserRegisterPageUI.FIRST_NAME, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LAST_NAME);
		senkeyToElement(driver, UserRegisterPageUI.LAST_NAME, lastName);

	}

	public void selectDayDropdown(String day) {
		waitToElementclickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);

	}

	public void selectMonthDropdown(String month) {
		waitToElementclickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementclickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);

	}

	public void inputToEmailTexbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTexbox(String companyName) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);

	}

	public void inputToPasswordTexbox(String passWord) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, passWord);
	}

	public void inputToConfirmPasswordTexbox(String passWord) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, passWord);

	}

	public void clickToRegisterButton() {
		waitToElementclickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}

	public String getTextRegisterSuccessMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return getTextElement(driver, UserRegisterPageUI.REGISTER_MESSAGE_SUCCESS );
	}

	public UserHomePO clickToLogoutLink() {
		waitToElementclickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGenerator.getUserHomePage(driver);
	}

	

}
