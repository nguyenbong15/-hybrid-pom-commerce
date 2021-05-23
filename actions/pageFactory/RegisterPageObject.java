package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage_Factory {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement gendermaleRadio;
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameTexbox;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameTexbox;
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

	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTexbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@id='register-button']")
	WebElement regesterButton;
	@FindBy(xpath = "//div[@class='result']")
	WebElement regesterMessageSuccess;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;

	public void clickToGenderMaleRadio() {
		waitToElementclickable(driver, gendermaleRadio);
		clickToElement(driver, gendermaleRadio);

	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, firstNameTexbox);
		senkeyToElement(driver, firstNameTexbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, lastNameTexbox);
		senkeyToElement(driver, lastNameTexbox, lastName);

	}

	public void selectDayDropdown(String day) {
		waitToElementclickable(driver, dayDropdown);
		selectItemInDropdown(driver, dayDropdown, day);

	}

	public void selectMonthDropdown(String month) {
		waitToElementclickable(driver, monthDropdown);
		selectItemInDropdown(driver, monthDropdown, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementclickable(driver, yearDropdown);
		selectItemInDropdown(driver, yearDropdown, year);

	}

	public void inputToEmailTexbox(String email) {
		waitToElementVisible(driver, emailTexbox);
		senkeyToElement(driver, emailTexbox, email);

	}

	public void inputToCompanyTexbox(String companyName) {
		waitToElementVisible(driver, companyTexbox);
		senkeyToElement(driver, companyTexbox, companyName);

	}

	public void inputToPasswordTexbox(String passWord) {
		waitToElementVisible(driver, passwordTexbox);
		senkeyToElement(driver, passwordTexbox, passWord);
	}

	public void inputToConfirmPasswordTexbox(String passWord) {
		waitToElementVisible(driver, confirmPassword);
		senkeyToElement(driver, confirmPassword, passWord);

	}

	public void clickToRegisterButton() {
		waitToElementclickable(driver, regesterButton);
		clickToElement(driver, regesterButton);

	}

	public String getTextRegisterSuccessMessage() {
		waitToElementVisible(driver, regesterMessageSuccess);
		return getTextElement(driver, regesterMessageSuccess);
	}

	public void clickToLogoutLink() {
		waitToElementclickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

}
