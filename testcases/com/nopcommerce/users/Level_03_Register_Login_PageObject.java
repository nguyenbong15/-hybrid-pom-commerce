package com.nopcommerce.users;

import org.testng.annotations.Test;

import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Register_Login_PageObject {
 

	WebDriver driver;
	HomePageObject homePageObject;
	CustomerInfoPageObject customerInfoPageObject;
	LoginPageObject loginPageObject;
	RegisterPageObject registerPageObject;
	
	String firstName,lastName,email,companyName,passWord;
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "browerdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
      
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	    driver.get("https://demo.nopcommerce.com/");
	    firstName="Tony";
	    lastName="Buoi Sang";
	    email="tonybuoisang"+ getRandomNumber()+"@hotmail.com";
	    companyName="Tony Buoi Sang";
	    passWord="tony123";
	    homePageObject=new HomePageObject(driver);
	}

	public int getRandomNumber() {
		Random rd=new Random();
		return rd.nextInt(99999);
	}

	@Test
	public void TC_01_Register() {
		
		homePageObject.clickToRegisterLink();
		registerPageObject=new RegisterPageObject(driver);
		registerPageObject.clickToGenderMaleRadio();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.selectDayDropdown("2");
		registerPageObject.selectMonthDropdown("May");
		registerPageObject.selectYearDropdown("2000");
		registerPageObject.inputToEmailTexbox(email);
		registerPageObject.inputToCompanyTexbox(companyName);
		registerPageObject.inputToPasswordTexbox(passWord);
		registerPageObject.inputToConfirmPasswordTexbox(passWord);
		
		registerPageObject.clickToRegisterButton();
	    Assert.assertEquals(registerPageObject.getTextRegisterSuccessMessage(),"Your registration completed");
	   
	    registerPageObject.clickToLogoutLink();
	    homePageObject=new HomePageObject(driver);  
	}
	@Test
	public void TC_02_Login() {
		homePageObject.clickToLoginLink();
		loginPageObject=new LoginPageObject(driver);
		loginPageObject.senkeyToEmailTexbox(email);
		loginPageObject.senkeyToPassWordTexbox(passWord);
		loginPageObject.clickToLoginButton();
		
		Assert.assertTrue( loginPageObject.isMyAccountLinkDisplayed());
		Assert.assertTrue( loginPageObject.isLogoutLinkDisplayed());
	}
	@Test
		public void TC_03_MyAcount() {
		homePageObject.clickToMyAccountLink();
		customerInfoPageObject=new CustomerInfoPageObject(driver);
			Assert.assertTrue( customerInfoPageObject.isGenderMaleRadioSelected());
			 Assert.assertEquals( customerInfoPageObject.getFirstNameTextboxValue(),firstName);
			 Assert.assertEquals( customerInfoPageObject.getLastNameTextboxValue(),lastName);
			 Assert.assertEquals( customerInfoPageObject.getSelectedTextDayInDropdown(),"2");
			 Assert.assertEquals( customerInfoPageObject.getSelectedTextMonthInDropdown(),"May");
			 Assert.assertEquals( customerInfoPageObject.getSelectedTextYearInDropdown(),"2000");
			 Assert.assertEquals( customerInfoPageObject.getEmailTextBoxValue(),email);
			 Assert.assertEquals( customerInfoPageObject.getCompanyTextboxValue(),companyName);
			 Assert.assertTrue( customerInfoPageObject.isNewsletterSelected());
			 
		
		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
