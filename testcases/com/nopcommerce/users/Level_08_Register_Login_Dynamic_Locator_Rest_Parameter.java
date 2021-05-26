package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.OrderPageObject;
import pageObjects.PageGenerator;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Register_Login_Dynamic_Locator_Rest_Parameter extends AbstractTest {

	WebDriver driver;
	HomePageObject homePageObject;
	CustomerInfoPageObject customerInfoPageObject;
	LoginPageObject loginPageObject;
	RegisterPageObject registerPageObject;
	AddressesPageObject addressesPage;
	MyProductReviewPageObject myProductReview;
	OrderPageObject orderPageObject;

	String firstName, lastName, email, companyName, passWord, day, month, year;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {

		driver = getBrowserName(browser);

		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
		homePageObject = PageGenerator.getHomePage(driver);

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
		addressesPage=  (AddressesPageObject) customerInfoPageObject.openLinkByPageName(driver, "Addresses");
		
		customerInfoPageObject=(CustomerInfoPageObject) addressesPage.openLinkByPageName(driver,"Customer info");
		
		myProductReview=(MyProductReviewPageObject) customerInfoPageObject.openLinkByPageName(driver,"My product reviews");
		
		orderPageObject=(OrderPageObject) myProductReview.openLinkByPageName(driver,"Orders");
		customerInfoPageObject=(CustomerInfoPageObject) orderPageObject.openLinkByPageName(driver,"Customer info");
	}
	//Trường hợp nhiều page >10
	@Test
	public void TC_04_Switch_Page_Solution_02() {
      customerInfoPageObject.openLinkWithPageName(driver, "Addresses");
      addressesPage=PageGenerator.getAddressesPage(driver);
      addressesPage.openLinkWithPageName(driver, "Customer info");
      customerInfoPageObject=PageGenerator.getCustomerInfoPage(driver);
      
      customerInfoPageObject.openLinkWithPageName(driver, "My product reviews");
      myProductReview=PageGenerator.getMyProductReviewPage(driver);
      
      myProductReview.openLinkWithPageName(driver, "Orders");
      orderPageObject=PageGenerator.getOrderPage(driver);
      
      orderPageObject.openLinkWithPageName(driver, "Customer info");
      customerInfoPageObject=PageGenerator.getCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
