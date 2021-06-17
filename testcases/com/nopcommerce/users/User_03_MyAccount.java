package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;
import pageObjects.PageGenerator;
import pageObjects.UserAddressesPO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class User_03_MyAccount extends AbstractTest {
	WebDriver driver;
	UserHomePO homePageObject;
	UserLoginPO loginPageObject;
	UserCustomerInfoPO customerInfo;
	UserChangePasswordPO changePasswordPage;
	UserAddressesPO addressesPage;
	String firstName, lastName, companyName, day, month, year;
	String email, password, cityName, address, zipCode, phoneNumber,country,newPassWord;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {
		email = "hoanghai@gmail.com";
		password = "123456";
		firstName = "Tony";
		lastName = "Buoi Sang";
		companyName = "Tony Buoi Sang";
		day = "2";
		month = "May";
		year = "2000";
		cityName="Việt Nam";
		address="Hà Nội";
		zipCode="012W2";
		phoneNumber="098765335";
		country="Andorra";
		newPassWord="654321";
		driver = getBrowserName(browser, urlValue);
		homePageObject = PageGenerator.getUserHomePage(driver);
		loginPageObject = homePageObject.clickToLoginLink();
		customerInfo =loginPageObject.loginToSystem(email,password);
		customerInfo.clickToMyaccountLink();

	}

	@Test
	public void TC_01_Update_Customer_Info() {
		customerInfo.clickToFemaleRadio();
		customerInfo.editFristName(firstName);
		customerInfo.editLastName(lastName);
		customerInfo.editSelectDay(day);
		customerInfo.editSelectMonth(month);
		customerInfo.editSelectYear(year);
		customerInfo.editCompany(companyName);
		verifyTrue(customerInfo.isGenderFemaleRadioSelected());
		verifyEquals(customerInfo.getFirstNameTextboxValue(), firstName);
		verifyEquals(customerInfo.getLastNameTextboxValue(), lastName);
		verifyEquals(customerInfo.getSelectedTextDayInDropdown(), day);
		verifyEquals(customerInfo.getSelectedTextMonthInDropdown(), month);
		verifyEquals(customerInfo.getSelectedTextYearInDropdown(), year);
		verifyEquals(customerInfo.getCompanyTextboxValue(), companyName);

	}

	@Test
	public void TC_02_Add_Address() {
		addressesPage = customerInfo.openAddressesPage(driver);
		addressesPage.clickToAddNewButton();
		addressesPage.inputToFirstName(firstName);
		addressesPage.inputToLastName(lastName);
		addressesPage.inputToEmail(email);
		addressesPage.selectCountry(country);
		addressesPage.inputToCity(cityName);
		addressesPage.inputToAddress1(address);
		addressesPage.inputToZipCode(zipCode);
		addressesPage.inputToPhoneNumber(phoneNumber);
		addressesPage.clickToSaveButton();
		
		verifyEquals(addressesPage.getName(), firstName+" "+lastName);
	
		verifyEquals(addressesPage.getEmail(),"Email: "+email);
		verifyEquals(addressesPage.getPhoneNumber(),"Phone number: "+ phoneNumber);
		verifyEquals(addressesPage.getFaxNumber(), "Fax number:");
		verifyEquals(addressesPage.getAdrress(), address);
		verifyEquals(addressesPage.getCityAndZipCode(), cityName+", "+zipCode);
		verifyEquals(addressesPage.getCountry(), country);

	}

	@Test
	public void TC_03_Chage_Password() {
     changePasswordPage=addressesPage.openChangePasswordPage(driver);
     changePasswordPage.inputOldPassword(password);
     changePasswordPage.ipnutNewPassword(newPassWord);
     changePasswordPage.inputConfirmNewPassword(newPassWord);
     changePasswordPage.clickToChangePasswordButton();
     customerInfo=changePasswordPage.openCustomerInfoPage(driver);
     homePageObject= customerInfo.clickToLogoutLink();
     loginPageObject= homePageObject.clickToLoginLink();
     loginPageObject.loginToSystem(email, newPassWord);
     verifyTrue(loginPageObject.isLogoutLinkDisplayed());
     verifyTrue(loginPageObject.isLoginLinkUnDisplayed());
     verifyTrue(loginPageObject.isMyAccountLinkDisplayed());
   
	}

	@Test
	public void TC_04_My_Products_Reviews() {

	}

	

	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
