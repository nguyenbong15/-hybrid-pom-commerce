package facebook.web.users;

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

public class Level_01_Register_Login_AbstractPage_01 {
	WebDriver driver;
	AbstractPage abstractPage;
	String firstName,lastName,email,companyName,passWord;
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "browerdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
       abstractPage = new AbstractPage();
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	    driver.get("https://demo.nopcommerce.com/");
	    firstName="Tony";
	    lastName="Buoi Sang";
	    email="tonybuoisang"+ getRandomNumber()+"@hotmail.com";
	    companyName="Tony Buoi Sang";
	    passWord="tony123";
	    
	}

	

	@Test
	public void TC_01_Register() {
		abstractPage.clickToElement(driver, "//a[text()='Register']");
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.senkeyToElement(driver,"//input[@id='FirstName']",firstName);
	
		abstractPage.senkeyToElement(driver,"//input[@id='LastName']",lastName);
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "2");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
		
		abstractPage.senkeyToElement(driver,"//input[@id='Email']",email);
		abstractPage.senkeyToElement(driver,"//input[@id='Company']",companyName);
		abstractPage.senkeyToElement(driver,"//input[@id='Password']",passWord);
		abstractPage.senkeyToElement(driver,"//input[@id='ConfirmPassword']",passWord);
		abstractPage.clickToElement(driver, "//button[@id='register-button']");
	    Assert.assertEquals(abstractPage.getTextElement(driver,"//div[@class='result']"),"Your registration completed");
	    Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[text()='Log out']"));
	}
	@Test
	public void TC_02_Login() {
		
		abstractPage.clickToElement(driver, "//a[text()='Log out']");
		abstractPage.clickToElement(driver, "//a[text()='Log in']");
	    abstractPage.senkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.senkeyToElement(driver,"//input[@id='Password']",passWord);
		abstractPage.clickToElement(driver, "//button[@class='button-1 login-button']");
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[text()='Log out']"));
	}
	@Test
		public void TC_03_MyAcount() {
			abstractPage.clickToElement(driver, "//a[@class='ico-account']");
			Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));
			 Assert.assertEquals(abstractPage.getElementAttribute(driver,"//input[@id='FirstName']","value"),firstName);
			 Assert.assertEquals(abstractPage.getElementAttribute(driver,"//input[@id='LastName']","value"),lastName);
			 Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthDay']"),"2");
			 Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthMonth']"),"May");
			 Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver,"//select[@name='DateOfBirthYear']"),"2000");
			 Assert.assertEquals(abstractPage.getElementAttribute(driver,"//input[@id='Email']","value"),email);
			 Assert.assertEquals(abstractPage.getElementAttribute(driver,"//input[@id='Company']","value"),companyName);
			 Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
			 
		
		}
	public int getRandomNumber() {
		Random rd=new Random();
		return rd.nextInt(99999);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
