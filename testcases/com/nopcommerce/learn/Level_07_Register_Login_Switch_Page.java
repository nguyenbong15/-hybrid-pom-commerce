package com.nopcommerce.learn;

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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Register_Login_Switch_Page extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;
	UserCustomerInfoPO customerInfoPageObject;
	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserAddressesPO addressesPage;
	UserMyProductReviewPO myProductReview;
	UserOrderInCustomerInfoPO orderPageObject;

	String firstName, lastName, email, companyName, passWord, day, month, year;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {

		driver = getBrowserName(browser);

		
		driver.get("https://demo.nopcommerce.com/");
		firstName = "Tony";
		lastName = "Buoi Sang";
		email = "tonybuoisang" + getRandomNumber() + "@hotmail.com";
		companyName = "Tony Buoi Sang";
		passWord = "tony123";
		day = "2";
		month = "May";
		year = "2000";

	}

	@Test
	public void TC_01_Register() {
		homePageObject = PageGenerator.getUserHomePage(driver);

		registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.clickToGenderMaleRadio();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.selectDayDropdown(day);
		registerPageObject.selectMonthDropdown(month);
		registerPageObject.selectYearDropdown(year);
		registerPageObject.inputToEmailTexbox(email);
		registerPageObject.inputToCompanyTexbox(companyName);
		registerPageObject.inputToPasswordTexbox(passWord);
		registerPageObject.inputToConfirmPasswordTexbox(passWord);

		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getTextRegisterSuccessMessage(), "Your registration completed");

		homePageObject = registerPageObject.clickToLogoutLink();

	}

	@Test
	public void TC_02_Login() {
		loginPageObject = homePageObject.clickToLoginLink();

		loginPageObject.senkeyToEmailTexbox(email);
		loginPageObject.senkeyToPassWordTexbox(passWord);
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isMyAccountLinkDisplayed());
		Assert.assertTrue(loginPageObject.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_MyAcount() {
		customerInfoPageObject = homePageObject.clickToMyAccountLink();

		Assert.assertTrue(customerInfoPageObject.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInfoPageObject.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPageObject.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInfoPageObject.getSelectedTextDayInDropdown(), day);
		Assert.assertEquals(customerInfoPageObject.getSelectedTextMonthInDropdown(), month);
		Assert.assertEquals(customerInfoPageObject.getSelectedTextYearInDropdown(), year);
		Assert.assertEquals(customerInfoPageObject.getEmailTextBoxValue(), email);
		Assert.assertEquals(customerInfoPageObject.getCompanyTextboxValue(), companyName);
		Assert.assertTrue(customerInfoPageObject.isNewsletterSelected());

	}

	@Test
	public void TC_04_Switch_Page() {
      addressesPage=  customerInfoPageObject.openAddressesPage(driver);
      
      customerInfoPageObject=addressesPage.openCustomerInfoPage(driver);
      
      myProductReview=customerInfoPageObject.openMyProductReviewPage(driver);
      
      orderPageObject=myProductReview.openOrderPage(driver);
      customerInfoPageObject=myProductReview.openCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
