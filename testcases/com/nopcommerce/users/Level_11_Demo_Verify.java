package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;

import pageObjects.PageGenerator;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrderPO;
import pageObjects.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_11_Demo_Verify extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;
	UserCustomerInfoPO customerInfoPageObject;
	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserAddressesPO addressesPage;
	UserMyProductReviewPO myProductReview;
	UserOrderPO orderPageObject;

	String firstName, lastName, email, companyName, passWord, day, month, year;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
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

	}

	//@Test
	public void TC_01_Register() {
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

	@Test
	public void TC_02_Login() {
		log.info("click to login link " );
		loginPageObject = homePageObject.clickToLoginLink();

		log.info("input email texbox "+email );
		loginPageObject.senkeyToEmailTexbox(email);
		log.info("input passWord texbox "+passWord );
		loginPageObject.senkeyToPassWordTexbox(passWord);
		log.info("click to login button " );
		loginPageObject.clickToLoginButton();
		log.info("verify my account link displayed " );
		verifyFalse(loginPageObject.isMyAccountLinkDisplayed());
		log.info("verify Logout link displayed " );
		verifyFalse(loginPageObject.isLogoutLinkDisplayed());
		log.info("verify Regester Link UnDisplayed " );
		verifyFalse(loginPageObject.isRegesterLinkUnDisplayed());
		log.info("verify Login link un " );
		verifyTrue(loginPageObject.isLoginLinkUnDisplayed());
	}

	// @Test
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

//<10 page
//	@Test
	public void TC_04_Switch_Page_Solution_01() {
		addressesPage = (UserAddressesPO) customerInfoPageObject.openLinkByPageName(driver, "Addresses");

		customerInfoPageObject = (UserCustomerInfoPO) addressesPage.openLinkByPageName(driver, "Customer info");

		myProductReview = (UserMyProductReviewPO) customerInfoPageObject.openLinkByPageName(driver,
				"My product reviews");

		orderPageObject = (UserOrderPO) myProductReview.openLinkByPageName(driver, "Orders");
		customerInfoPageObject = (UserCustomerInfoPO) orderPageObject.openLinkByPageName(driver, "Customer info");
	}

	// Trường hợp nhiều page >10
//	@Test
	public void TC_04_Switch_Page_Solution_02() {
		customerInfoPageObject.openLinkWithPageName(driver, "Addresses");
		addressesPage = PageGenerator.getUserAddressesPage(driver);
		addressesPage.openLinkWithPageName(driver, "Customer info");
		customerInfoPageObject = PageGenerator.getUserCustomerInfoPage(driver);

		customerInfoPageObject.openLinkWithPageName(driver, "My product reviews");
		myProductReview = PageGenerator.getUserMyProductReviewPage(driver);

		myProductReview.openLinkWithPageName(driver, "Orders");
		orderPageObject = PageGenerator.getUserOrderPage(driver);

		orderPageObject.openLinkWithPageName(driver, "Customer info");
		customerInfoPageObject = PageGenerator.getUserCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
