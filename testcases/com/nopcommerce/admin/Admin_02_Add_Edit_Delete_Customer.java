package com.nopcommerce.admin;

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
	Faker fake=new Faker();
	String email,password;
	String emailCustomer,passwordCustomer,customerRole,firstName,lastName,companyName,date,newLetter,adminComment;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {
        email="admin@yourstore.com";
        password="admin";
        emailCustomer=fake.internet().emailAddress();
        passwordCustomer=fake.internet().password();
        firstName=fake.name().firstName();
        lastName=fake.name().lastName();
        companyName=fake.company().name();
        date="1/1/2000";
        newLetter="Your store name";
        adminComment="Good";
        customerRole="Guests";
		driver = getBrowserName(browser, urlValue);
		loginPage=PageGenerator.getAdminLoginPage(driver);
		dashboardPage=loginPage.loginToSystem(email, password);
		customerPage=dashboardPage.openCustomerPage();
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
	   customerPage.chooseItemInCustomDropdownById(newLetter,"SelectedNewsletterSubscriptionStoreIds_listbox");
	   
	   customerPage.clickToRegisterButtonToRemove();
	   customerPage.chooseItemInCustomDropdownById(customerRole,"SelectedCustomerRoleIds_taglist");
	//inputTexboxById(driver, adminComment, "AdminComment");
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
	  // verifyEquals(customerPage.getElementById(driver, "AdminComment"), adminComment);
	   verifyEquals(customerPage.getNewletter(),newLetter);
	   verifyTrue(customerPage.isMaleRadioChecked());
	   verifyTrue(customerPage.isActiveCheckboxChecked());
	   customerPage.clickToBackToListLink();
	   customerPage.clickToShowSearchPage();
	   customerPage.clickToRegisterButtonToRemove();
	   //customerPage.hoverToCustomDropdown();
	   customerPage.chooseItemInCustomDropdownById(customerRole,"SelectedCustomerRoleIds_taglist");
	   customerPage.clickToSearchButton();
	   customerPage.chooseNumberItemInPage("50");
	   verifyTrue(customerPage.isInfoCustomerDisplayedInTable(firstName+" "+lastName,companyName,"true"));
	
	}

	@Test
	public void TC_02_Search_With_Name_And_Parent_Category_And_UncheckSearch() {
		
       
	}
	@Test
	public void TC_03_Search_With_Name_And_Parent_Category_CheckSearchCategory() {
		
       
	}
	


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
