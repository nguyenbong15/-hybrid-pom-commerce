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
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserRegisterPO;

public class User_03_MyAccount extends AbstractTest {
	WebDriver driver;
	UserHomePO homePageObject;
	UserLoginPO loginPageObject;
	UserMyProductReviewPO myProductsReviews;
	UserCustomerInfoPO customerInfo;
	UserChangePasswordPO changePasswordPage;
	UserAddressesPO addressesPage;
	String firstName, lastName, companyName, day, month, year;
	String email, password, cityName, address, zipCode, phoneNumber,country,newPassWord,nameProduct,
	titleReview,textReview;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {
		//email = "hoanghai@gmail.com";
		//password = "123456";
		nameProduct="Build your own computer";
		titleReview="hello";
		textReview="Bong";
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
		customerInfo =loginPageObject.loginToSystem(Common_01_Register.email,Common_01_Register.passWord);
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
		addressesPage.inputToEmail(Common_01_Register.email);
		addressesPage.selectCountry(country);
		addressesPage.inputToCity(cityName);
		addressesPage.inputToAddress1(address);
		addressesPage.inputToZipCode(zipCode);
		addressesPage.inputToPhoneNumber(phoneNumber);
		addressesPage.clickToSaveButton();
		
		verifyEquals(addressesPage.getName(),firstName+" "+lastName);
	
		verifyEquals(addressesPage.getEmail(),"Email: "+Common_01_Register.email);
		verifyEquals(addressesPage.getPhoneNumber(),"Phone number: "+ phoneNumber);
		verifyEquals(addressesPage.getFaxNumber(), "Fax number:");
		verifyEquals(addressesPage.getAdrress(), address);
		verifyEquals(addressesPage.getCityAndZipCode(), cityName+", "+zipCode);
		verifyEquals(addressesPage.getCountry(), country);

	}

	@Test
	public void TC_03_Chage_Password() {
     changePasswordPage=addressesPage.openChangePasswordPage(driver);
     changePasswordPage.inputOldPassword(Common_01_Register.passWord);
     changePasswordPage.ipnutNewPassword(newPassWord);
     changePasswordPage.inputConfirmNewPassword(newPassWord);
     changePasswordPage.clickToChangePasswordButton();
     customerInfo=changePasswordPage.openCustomerInfoPage(driver);
     homePageObject= customerInfo.clickToLogoutLink();
     loginPageObject= homePageObject.clickToLoginLink();
     loginPageObject.loginToSystem(Common_01_Register.email, newPassWord);
     verifyTrue(loginPageObject.isLogoutLinkDisplayed());
     verifyTrue(loginPageObject.isLoginLinkUnDisplayed());
     verifyTrue(loginPageObject.isMyAccountLinkDisplayed());
   
	}

	@Test
	public void TC_04_My_Products_Reviews() {
	   loginPageObject.clickToMyAccountLink();
      customerInfo=loginPageObject.openCustomerInfoPage(driver);
      customerInfo.hoverToComputerLink();
      customerInfo.clickToDesktopLink();
      customerInfo.clickToProductsName(nameProduct);
      customerInfo.clickToAddReviewLink();
      customerInfo.senkeyTopTitleReviewTexbox(titleReview);
      customerInfo.senkeyTopReviewTextTexbox(textReview);
      customerInfo.clickToRattingRadio();
      customerInfo.clickToSubmitLink();
      verifyEquals(customerInfo.getTextProdustReviewSuccess(),"Product review is successfully added.");
      customerInfo.clickToMyaccountLink();
      myProductsReviews=customerInfo.openMyProductReviewPage(driver);
      verifyEquals(myProductsReviews.getTitleReview(),titleReview );
      verifyEquals(myProductsReviews.getTextReview(),textReview );
      verifyEquals(myProductsReviews.getNameProductsReview(),nameProduct);
      
      
    
	}	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
