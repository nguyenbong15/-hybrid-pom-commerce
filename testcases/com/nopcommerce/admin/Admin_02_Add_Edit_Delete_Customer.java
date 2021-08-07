package com.nopcommerce.admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commons.AbstractTest;
import pageObjectAdmin.AdminCustomerPagePO;
import pageObjectAdmin.AdminDashboardPagePO;
import pageObjectAdmin.AdminLoginPagePO;
import pageObjectsUsers.PageGenerator;

public class Admin_02_Add_Edit_Delete_Customer extends AbstractTest {

	WebDriver driver;
	AdminLoginPagePO loginPage;
	AdminDashboardPagePO dashboardPage;
	AdminCustomerPagePO customerPage;
	Alert alert;
	
	Faker fake = new Faker();
	String email, password;
	String emailCustomer, passwordCustomer, customerRole, firstName, lastName, companyName, date, newLetter;
	String	adminComment,cityname,address,phoneNumber,zipcode;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {
		email = "admin@yourstore.com";
		password = "admin";
		emailCustomer = fake.internet().emailAddress();
		passwordCustomer = fake.internet().password();
		firstName = fake.name().firstName();
		lastName = fake.name().lastName();
		companyName = fake.company().name();
		date = "1/1/2000";
		newLetter = "Your store name";
		adminComment = "Good";
		customerRole = "Guests";
		cityname=fake.address().cityName();
		address=fake.address().fullAddress();
		phoneNumber=fake.phoneNumber().phoneNumber();
		zipcode="32CS";
		driver = getBrowserName(browser, urlValue);
		loginPage = PageGenerator.getAdminLoginPage(driver);
		dashboardPage = loginPage.loginToSystem(email, password);
		customerPage = dashboardPage.openCustomerPage();
	}

	@Test
	public void TC_01_Add_New_Customer() {
		customerPage.clickToAddButton();
		customerPage.waitoAjaxLoaded(driver);
		customerPage.inputTexboxById(driver, emailCustomer, "Email");
		customerPage.inputTexboxById(driver, passwordCustomer, "Password");
		customerPage.inputTexboxById(driver, firstName, "FirstName");
		customerPage.inputTexboxById(driver, lastName, "LastName");
		customerPage.clickRadioById(driver, "Gender_Male");
		customerPage.inputTexboxById(driver, date, "DateOfBirth");
		customerPage.inputTexboxById(driver, companyName, "Company");
		customerPage.chooseItemInCustomDropdownById(newLetter, "SelectedNewsletterSubscriptionStoreIds_listbox");

		customerPage.clickToRegisterButtonToRemove();
		customerPage.chooseItemInCustomDropdownById(customerRole, "SelectedCustomerRoleIds_taglist");
		// inputTexboxById(driver, adminComment, "AdminComment");
		customerPage.clickCheckBoxById(driver, "Active");
		customerPage.clickToSaveAndContinueEditButton();
		customerPage.waitoAjaxLoaded(driver);
		verifyTrue(customerPage.isMessageAddSucessDispalyed());
		customerPage.clickToHideButtonByIdPage(driver, "customer-info");
		verifyEquals(customerPage.getElementById(driver, "Email"), emailCustomer);
		verifyEquals(customerPage.getElementById(driver, "FirstName"), firstName);
		verifyEquals(customerPage.getElementById(driver, "LastName"), lastName);
		verifyEquals(customerPage.getElementById(driver, "DateOfBirth"), date);
		verifyEquals(customerPage.getElementById(driver, "Company"), companyName);
		// verifyEquals(customerPage.getElementById(driver, "AdminComment"),
		// adminComment);
		verifyEquals(customerPage.getNewletter(), newLetter);
		verifyTrue(customerPage.isMaleRadioChecked());
		verifyTrue(customerPage.isActiveCheckboxChecked());
		customerPage.clickToBackToListLink();
		customerPage.clickToShowSearchPage();
		customerPage.clickToRegisterButtonToRemove();
		customerPage.chooseItemInCustomDropdownById(customerRole, "SelectedCustomerRoleIds_taglist");
		customerPage.clickToSearchButton();
		customerPage.chooseNumberItemInPage("50");
		verifyTrue(customerPage.isInfoCustomerDisplayedInTable(firstName + " " + lastName, companyName, "true"));

	}

	@Test
	public void TC_02_Search_Customer_With_Email() {
		customerPage.inputTexboxById(driver, emailCustomer, "SearchEmail");
		customerPage.clickToSearchButton();
		verifyTrue(customerPage.isInfoCustomerDisplayedInTable(firstName + " " + lastName, companyName, "true"));

	}

	@Test
	public void TC_03_Search_Customer_With_Fisrtname_lastname() {
		customerPage.inputTexboxById(driver, "", "SearchEmail");
		customerPage.inputTexboxById(driver, firstName, "SearchFirstName");
		customerPage.inputTexboxById(driver, lastName, "SearchLastName");
		customerPage.clickToSearchButton();
		verifyTrue(customerPage.isInfoCustomerDisplayedInTable(firstName + " " + lastName, companyName, "true"));

	}

	@Test
	public void TC_04_Search_Customer_With_Company() {
		customerPage.inputTexboxById(driver, "", "SearchEmail");
		customerPage.inputTexboxById(driver, "", "SearchFirstName");
		customerPage.inputTexboxById(driver, "", "SearchLastName");
		customerPage.inputTexboxById(driver, companyName, "SearchCompany");
		customerPage.clickToSearchButton();
		verifyTrue(customerPage.isInfoCustomerDisplayedInTable(firstName + " " + lastName, companyName, "true"));

	}

	@Test
	public void TC_05_Search_Customer_With_Full_Data() {
		customerPage.inputTexboxById(driver, emailCustomer, "SearchEmail");
		customerPage.inputTexboxById(driver, firstName, "SearchFirstName");
		customerPage.inputTexboxById(driver, lastName, "SearchLastName");
		customerPage.inputTexboxById(driver, companyName, "SearchCompany");
		customerPage.chosseItemInDropdownById("1", "SearchMonthOfBirth");
		customerPage.chosseItemInDropdownById("1", "SearchDayOfBirth");
		customerPage.clickToSearchButton();
		verifyTrue(customerPage.isInfoCustomerDisplayedInTable(firstName + " " + lastName, companyName, "true"));

	}

	@Test(dependsOnMethods = "TC_05_Search_Customer_With_Full_Data")
	public void TC_06_Edit_Customer() {
		customerPage.clickToEditLinkByName_Company(firstName + " " + lastName, companyName);
		customerPage.clickToHideButtonByIdPage(driver, "customer-info");

		customerPage.inputTexboxById(driver,  emailCustomer, "Email");
		customerPage.inputTexboxById(driver, passwordCustomer, "Password");
		customerPage.inputTexboxById(driver, "Edit " + firstName, "FirstName");
		customerPage.inputTexboxById(driver, "Edit " + lastName, "LastName");
		customerPage.inputTexboxById(driver, "2/2/2000", "DateOfBirth");
		customerPage.inputTexboxById(driver, "Edit " + companyName, "Company");
		customerPage.clickToSaveButton();

		customerPage.inputTexboxById(driver, emailCustomer, "SearchEmail");
		customerPage.inputTexboxById(driver, "Edit " + firstName, "SearchFirstName");
		customerPage.inputTexboxById(driver, "Edit " + lastName, "SearchLastName");
		customerPage.inputTexboxById(driver, "Edit " + companyName, "SearchCompany");
		customerPage.chosseItemInDropdownById("2", "SearchMonthOfBirth");
		customerPage.chosseItemInDropdownById("2", "SearchDayOfBirth");

		customerPage.clickToRegisterButtonToRemove();
		customerPage.chooseItemInCustomDropdownById(customerRole, "SelectedCustomerRoleIds_taglist");
		customerPage.clickToSearchButton();
		verifyTrue(customerPage.isInfoCustomerDisplayedInTable("Edit " + firstName + " " + "Edit " + lastName,
				"Edit " + companyName, "true"));

	}
	@Test(dependsOnMethods = "TC_06_Edit_Customer")
	public void TC_07_Add_New_Address_() {
		customerPage.clickToEditLinkByName_Company("Edit " + firstName + " " + "Edit " + lastName,"Edit " + companyName);
		customerPage.clickToHideButtonByIdPage(driver, "customer-address");
		customerPage.clickToAddNewAddressButton();
		customerPage.inputTexboxById(driver, firstName, "Address_FirstName");
		customerPage.inputTexboxById(driver, lastName, "Address_LastName");
		customerPage.inputTexboxById(driver, emailCustomer, "Address_Email");
		customerPage.inputTexboxById(driver, companyName, "Address_Company");
		customerPage.inputTexboxById(driver, cityname, "Address_City");
		customerPage.inputTexboxById(driver, address, "Address_Address1");
		customerPage.inputTexboxById(driver, zipcode, "Address_ZipPostalCode");
		customerPage.inputTexboxById(driver, phoneNumber, "Address_PhoneNumber");
		customerPage.clickToSaveAddressButton();
		verifyTrue(customerPage.isMessageAddSucessDispalyed());
		
		verifyEquals(customerPage.getElementById(driver, "Address_FirstName"), firstName);
		verifyEquals(customerPage.getElementById(driver, "Address_LastName"), lastName);
		verifyEquals(customerPage.getElementById(driver, "Address_Email"), emailCustomer);
		verifyEquals(customerPage.getElementById(driver, "Address_Company"), companyName);
		verifyEquals(customerPage.getElementById(driver, "Address_City"), cityname);
		verifyEquals(customerPage.getElementById(driver, "Address_Address1"), address);
		verifyEquals(customerPage.getElementById(driver, "Address_ZipPostalCode"), zipcode);
		verifyEquals(customerPage.getElementById(driver, "Address_PhoneNumber"), phoneNumber);
		
		customerPage.clickToBackToDetailsLink();
		customerPage.clickToHideButtonByIdPage(driver, "customer-address");
		verifyTrue(customerPage.isInfoAddressDisplayed(firstName,lastName,emailCustomer,phoneNumber));
		verifyEquals(customerPage.getAddress(), companyName +"\n"+address+"\n"+cityname+","+zipcode);
	}
	
	@Test(dependsOnMethods = "TC_06_Edit_Customer")
	public void TC_08_Edit_And_Delete_New_Address() {
	    customerPage.clickToEditAddressByEmail(emailCustomer);  
	    customerPage.inputTexboxById(driver,"Edit "+firstName, "Address_FirstName");
		customerPage.inputTexboxById(driver, "Edit "+lastName, "Address_LastName");
		customerPage.inputTexboxById(driver, emailCustomer, "Address_Email");
		customerPage.inputTexboxById(driver, "Edit "+companyName, "Address_Company");
		customerPage.inputTexboxById(driver, "Edit "+cityname, "Address_City");
		customerPage.inputTexboxById(driver, "Edit "+address, "Address_Address1");
		customerPage.inputTexboxById(driver, zipcode, "Address_ZipPostalCode");
		customerPage.inputTexboxById(driver, phoneNumber, "Address_PhoneNumber");
		customerPage.clickToSaveAddressButton();
		verifyTrue(customerPage.isMessageAddSucessDispalyed());
		customerPage.clickToBackToDetailsLink();		
		customerPage.clickToHideButtonByIdPage(driver, "customer-address");
		verifyTrue(customerPage.isInfoAddressDisplayed("Edit "+firstName,"Edit "+lastName,emailCustomer,phoneNumber));
		verifyEquals(customerPage.getAddress(), "Edit "+companyName +"\n"+"Edit "+address+"\n"+"Edit "+cityname+","+zipcode);
		 customerPage.clickToDeleteAddressByEmail(emailCustomer);
		 customerPage.waitAlertPresence(driver);
		 customerPage.acceptAlert(driver);
		 customerPage.waitoAjaxLoaded(driver);
		 verifyTrue(customerPage.isMessageNoDataInTable());
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
