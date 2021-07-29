package com.nopcommerce.learn;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_02_Register_Login_AbstractPage_02 extends AbstractPage {
	
	WebDriver driver;
	
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
	    
	}

	public int getRandomNumber() {
		Random rd=new Random();
		return rd.nextInt(99999);
	}

	@Test
	public void TC_01_Register() {
		clickToElement(driver, "//a[text()='Register']");
		 clickToElement(driver, "//input[@id='gender-male']");
		 senkeyToElement(driver,"//input[@id='FirstName']",firstName);
	
		 senkeyToElement(driver,"//input[@id='LastName']",lastName);
		 selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "2");
		 selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		 selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
		
		 senkeyToElement(driver,"//input[@id='Email']",email);
		 senkeyToElement(driver,"//input[@id='Company']",companyName);
		 senkeyToElement(driver,"//input[@id='Password']",passWord);
		 senkeyToElement(driver,"//input[@id='ConfirmPassword']",passWord);
		 clickToElement(driver, "//button[@id='register-button']");
	    Assert.assertEquals( getTextElement(driver,"//div[@class='result']"),"Your registration completed");
	    Assert.assertTrue( isElementDisplayed(driver, "//a[text()='Log out']"));
	}
	@Test
	public void TC_02_Login() {
		
		 clickToElement(driver, "//a[text()='Log out']");
		 clickToElement(driver, "//a[text()='Log in']");
	     senkeyToElement(driver, "//input[@id='Email']", email);
		 senkeyToElement(driver,"//input[@id='Password']",passWord);
		 clickToElement(driver, "//button[@class='button-1 login-button']");
		Assert.assertTrue( isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue( isElementDisplayed(driver, "//a[text()='Log out']"));
	}
	@Test
		public void TC_03_MyAcount() {
			 clickToElement(driver, "//a[@class='ico-account']");
			Assert.assertTrue( isElementSelected(driver, "//input[@id='gender-male']"));
			 Assert.assertEquals( getAttributeElement(driver,"//input[@id='FirstName']","value"),firstName);
			 Assert.assertEquals( getAttributeElement(driver,"//input[@id='LastName']","value"),lastName);
			 Assert.assertEquals( getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthDay']"),"2");
			 Assert.assertEquals( getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthMonth']"),"May");
			 Assert.assertEquals( getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthYear']"),"2000");
			 Assert.assertEquals( getAttributeElement(driver,"//input[@id='Email']","value"),email);
			 Assert.assertEquals( getAttributeElement(driver,"//input[@id='Company']","value"),companyName);
			 Assert.assertTrue( isElementSelected(driver, "//input[@id='Newsletter']"));
			 
		
		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
