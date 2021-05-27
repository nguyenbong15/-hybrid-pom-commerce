package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrderPO;
import pageObjects.PageGenerator;
import pageObjects.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Register_Login_Dynamic_Locator_Rest_Parameter extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;
	UserCustomerInfoPO customerInfoPageObject;
	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserAddressesPO addressesPage;
	UserMyProductReviewPO myProductReview;
	UserOrderPO orderPageObject;

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
//<10 page
	@Test
	public void TC_04_Switch_Page_Solution_01() {
		addressesPage=  (UserAddressesPO) customerInfoPageObject.openLinkByPageName(driver, "Addresses");
		
		customerInfoPageObject=(UserCustomerInfoPO) addressesPage.openLinkByPageName(driver,"Customer info");
		
		myProductReview=(UserMyProductReviewPO) customerInfoPageObject.openLinkByPageName(driver,"My product reviews");
		
		orderPageObject=(UserOrderPO) myProductReview.openLinkByPageName(driver,"Orders");
		customerInfoPageObject=(UserCustomerInfoPO) orderPageObject.openLinkByPageName(driver,"Customer info");
	}
	//Trường hợp nhiều page >10
	@Test
	public void TC_04_Switch_Page_Solution_02() {
      customerInfoPageObject.openLinkWithPageName(driver, "Addresses");
      addressesPage=PageGenerator.getUserAddressesPage(driver);
      addressesPage.openLinkWithPageName(driver, "Customer info");
      customerInfoPageObject=PageGenerator.getUserCustomerInfoPage(driver);
      
      customerInfoPageObject.openLinkWithPageName(driver, "My product reviews");
      myProductReview=PageGenerator.getUserMyProductReviewPage(driver);
      
      myProductReview.openLinkWithPageName(driver, "Orders");
      orderPageObject=PageGenerator.getUserOrderPage(driver);
      
      orderPageObject.openLinkWithPageName(driver, "Customer info");
      customerInfoPageObject=PageGenerator.getUserCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
