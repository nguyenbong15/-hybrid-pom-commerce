package com.nopcommerce.learn;

import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserAddressesPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserMyProductReviewPO;
import pageObjectsUsers.UserOrderPO;
import pageObjectsUsers.UserRegisterPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_12_Demo_Share_State extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;
	UserCustomerInfoPO customerInfoPageObject;
	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserAddressesPO addressesPage;
	UserMyProductReviewPO myProductReview;
	UserOrderPO orderPageObject;

	

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);

		// driver.get("https://demo.nopcommerce.com/");
	

	}

	

	@Test
	public void TC_02_Login() {
		homePageObject = PageGenerator.getUserHomePage(driver);
		log.info("click to login link " );
	
		loginPageObject = homePageObject.clickToLoginLink();

		log.info("input email texbox "+Common_01_Register.email );
		loginPageObject.senkeyToEmailTexbox(Common_01_Register.email);
		log.info("input passWord texbox "+Common_01_Register.passWord );
		loginPageObject.senkeyToPassWordTexbox(Common_01_Register.passWord);
		log.info("click to login button " );
		loginPageObject.clickToLoginButton();
		log.info("verify my account link displayed " );
		verifyTrue(loginPageObject.isMyAccountLinkDisplayed());
		log.info("verify Logout link displayed " );
		verifyTrue(loginPageObject.isLogoutLinkDisplayed());
		log.info("verify Regester Link UnDisplayed " );
		verifyTrue(loginPageObject.isRegesterLinkUnDisplayed());
		log.info("verify Login link un " );
		verifyTrue(loginPageObject.isLoginLinkUnDisplayed());
	}

	

	@AfterClass
	
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
