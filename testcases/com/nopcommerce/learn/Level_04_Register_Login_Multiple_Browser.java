package com.nopcommerce.learn;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Register_Login_Multiple_Browser extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;
	UserCustomerInfoPO customerInfoPageObject;
	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	
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

		homePageObject = new UserHomePO(driver);
	}

	

	@Test
	public void TC_01_Register() {

		homePageObject.clickToRegisterLink();
		registerPageObject = new UserRegisterPO(driver);
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

		registerPageObject.clickToLogoutLink();
		homePageObject = new UserHomePO(driver);
	}

	@Test
	public void TC_02_Login() {
		homePageObject.clickToLoginLink();
		loginPageObject = new UserLoginPO(driver);
		loginPageObject.senkeyToEmailTexbox(email);
		loginPageObject.senkeyToPassWordTexbox(passWord);
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isMyAccountLinkDisplayed());
		Assert.assertTrue(loginPageObject.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_MyAcount() {
		homePageObject.clickToMyAccountLink();
		customerInfoPageObject = new UserCustomerInfoPO(driver);
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
