package com.nopcommerce.commons;
import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
public class Common_01_Register extends AbstractTest {


		WebDriver driver;
		UserHomePO homePageObject;
		
	
		UserRegisterPO registerPageObject;
		

		String firstName, lastName, companyName, day, month, year;
       public static    String  email, passWord;
		@Parameters(value = { "browser", "url" })
		@BeforeTest
		public void beforeClass(String browser, String urlValue) {

			driver = getBrowserName(browser, urlValue);

			// driver.get("https://demo.nopcommerce.com/");
			firstName = "Tony";
			lastName = "Buoi Sang";
			email = "tonybuoisang" + getRandomNumber() + "@hotmail.com";
			companyName = "Tony Buoi Sang";
			passWord = "tony123";
			day = "2";
			month = "May";
			year = "2000";

			log.info("open link nopcommerce");
			homePageObject = PageGenerator.getUserHomePage(driver);
			log.info("click to register link");
			registerPageObject = homePageObject.clickToRegisterLink();
			log.info("click to Gender Male Radio");
			registerPageObject.clickToGenderMaleRadio();
			log.info("input To First Name Textbox " + firstName);
			registerPageObject.inputToFirstNameTextbox(firstName);
			log.info("input To Last Name Textbox " + lastName);

			registerPageObject.inputToLastNameTextbox(lastName);
			log.info("select day  " + day);
			registerPageObject.selectDayDropdown(day);
			log.info("select month  " + month);
			registerPageObject.selectMonthDropdown(month);
			log.info("select year  " + year);
			registerPageObject.selectYearDropdown(year);

			log.info("input To Email Textbox " + email);
			registerPageObject.inputToEmailTexbox(email);
			log.info("input To Company Textbox " + companyName);
			registerPageObject.inputToCompanyTexbox(companyName);
			log.info("input To Password Textbox " + passWord);
			registerPageObject.inputToPasswordTexbox(passWord);
			log.info("input To Confirm Password Textbox " + passWord);
			registerPageObject.inputToConfirmPasswordTexbox(passWord);

			log.info("click To Register Button ");
			registerPageObject.clickToRegisterButton();
			log.info("verify Message Success " );
			verifyEquals(registerPageObject.getTextRegisterSuccessMessage(), "Your registration completed");
			log.info("click to log out link " );
			homePageObject = registerPageObject.clickToLogoutLink();

		}

	

		@AfterTest(alwaysRun = true)
		public void afterClass() {
			closeBrowserAndDriver(driver);
		}

	}


