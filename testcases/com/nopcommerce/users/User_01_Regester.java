package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserAddressesPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserMyProductReviewPO;
import pageObjectsUsers.UserOrderInCustomerInfoPO;
import pageObjectsUsers.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Regester extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;

	String firstName, lastName, companyName, day, month, year;
      String email,passWord;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);
		firstName = "Tony";
		lastName = "Buoi Sang";
		email = "tonybuoisang" + getRandomNumber() + "@hotmail.com";
		companyName = "Tony Buoi Sang";
		passWord = "tony123";
		day = "2";
		month = "May";
		year = "2000";
		homePageObject = PageGenerator.getUserHomePage(driver);
		registerPageObject = homePageObject.clickToRegisterLink();

	}
	@Test
	public void TC_01_Register_With_Empty_Data() {
		log.info("Step 01 - click to register button");
		registerPageObject.clickToRegisterButton();
		log.info("Step 02 - verify message error");
		verifyEquals(registerPageObject.getFristnameError(), "First name is required.");
		verifyEquals(registerPageObject.getLastnameError(), "Last name is required.");
		verifyEquals(registerPageObject.getEmailError(), "Email is required.");
		verifyEquals(registerPageObject.getPasswordError(), "Password is required.");
		verifyEquals(registerPageObject.getConfirmPasswordError(), "Password is required.");

	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		
		registerPageObject.clickToGenderMaleRadio();
       registerPageObject.inputToFirstNameTextbox(firstName);
       registerPageObject.inputToLastNameTextbox(lastName);
       registerPageObject.inputToEmailTexbox("abcd");
       registerPageObject.selectDayDropdown(day);
       registerPageObject.selectMonthDropdown(month);
       registerPageObject.selectYearDropdown(year);
       registerPageObject.inputToCompanyTexbox(companyName);
       registerPageObject.inputToPasswordTexbox(passWord);
       registerPageObject.inputToConfirmPasswordTexbox(passWord);
       registerPageObject.clickToRegisterButton();
       verifyEquals(registerPageObject.getEmailError(), "Wrong email");
       
	}

//	@Test
	public void TC_03_Register_With_Email_Exist() {
		
	      registerPageObject.inputToEmailTexbox("abc@gmail.com");
	 
	       registerPageObject.inputToPasswordTexbox(passWord);
	       registerPageObject.inputToConfirmPasswordTexbox(passWord);
	       registerPageObject.clickToRegisterButton();
	       verifyEquals(registerPageObject.getEmailExistError(), "The specified email already exists");
	}

	@Test
	public void TC_04_Register_With_Password_Under6() {

	       registerPageObject.inputToEmailTexbox(email);

	       registerPageObject.inputToPasswordTexbox("1234");
	       registerPageObject.inputToConfirmPasswordTexbox("1234");
	       registerPageObject.clickToRegisterButton();
	       verifyEquals(registerPageObject.getPasswordUnder6Error1(), "Password must meet the following rules:");
	       verifyEquals(registerPageObject.getPasswordUnder6Error2(), "must have at least 6 characters");
	       
	}

	@Test
	public void TC_05_Register_With_Password_Wrong() {
		 registerPageObject.inputToPasswordTexbox(passWord);
	       registerPageObject.inputToConfirmPasswordTexbox("1234");
	       registerPageObject.clickToRegisterButton();
	       verifyEquals(registerPageObject.getConfirmPasswordError(), "The password and confirmation password do not match.");
	       	       
	}

	@Test
	public void TC_06_Register_Success() {
	       registerPageObject.inputToEmailTexbox(email);
	       registerPageObject.inputToConfirmPasswordTexbox(passWord);
	       registerPageObject.clickToRegisterButton();
	       verifyEquals(registerPageObject.getTextRegisterSuccessMessage(), "Your registration completed");
	       homePageObject = registerPageObject.clickToLogoutLink();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
