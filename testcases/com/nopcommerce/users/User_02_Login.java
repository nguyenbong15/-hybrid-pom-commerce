package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;
import pageObjects.PageGenerator;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class User_02_Login extends AbstractTest {
	WebDriver driver;
	UserHomePO homePageObject;
    String emailWrong="abc",emailInvalid="abcd45@gmail.com";
	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);
		homePageObject= PageGenerator.getUserHomePage(driver);
		loginPageObject=homePageObject.clickToLoginLink();
		
	}
	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPageObject.clickToLoginButton();
		verifyEquals(loginPageObject.getEmailLoginError(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		loginPageObject.senkeyToEmailTexbox(emailWrong);
		loginPageObject.clickToLoginButton();
		verifyEquals(loginPageObject.getEmailLoginError(), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Email_Not_Exist() {
		
		loginPageObject.senkeyToEmailTexbox(emailInvalid);
		loginPageObject.clickToLoginButton();
		verifyEquals(loginPageObject.getEmailNotExitError(), "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"No customer account found");
		
	}

	@Test
	public void TC_04_Login_With_Email_Exist_And_Empty_Password() {
		loginPageObject.senkeyToEmailTexbox(Common_01_Register.email);
		loginPageObject.clickToLoginButton();
		verifyEquals(loginPageObject.getEmailNotExitError(), "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect");
		
	  
	       
	}

	@Test
	public void TC_05_Login_With_Email_Exist_And_Password_Wrong() {
		loginPageObject.senkeyToPassWordTexbox("123");
		loginPageObject.clickToLoginButton();
		verifyEquals(loginPageObject.getEmailNotExitError(), "Login was unsuccessful. Please correct the errors and try again.\n" +
			"The credentials provided are incorrect");
	  
		  
	}

	@Test
	public void TC_06_Login_Success() {
		log.info("Step 01- input email texbox");
		loginPageObject.senkeyToEmailTexbox(Common_01_Register.email);
		log.info("Step 02- input passWord texbox");
	    loginPageObject.senkeyToPassWordTexbox(Common_01_Register.passWord);
	    
	    log.info("Step 03- click to login button " );
	    loginPageObject.clickToLoginButton();
	    log.info("Step 04-verify my account link displayed " );
		verifyTrue(loginPageObject.isMyAccountLinkDisplayed());
		log.info("Step 05-verify Logout link displayed " );
		verifyTrue(loginPageObject.isLogoutLinkDisplayed());
		log.info("Step 06-verify Regester Link UnDisplayed " );
		verifyTrue(loginPageObject.isRegesterLinkUnDisplayed());
		log.info("Step 07-verify Login link undisplayed " );
		verifyTrue(loginPageObject.isLoginLinkUnDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
