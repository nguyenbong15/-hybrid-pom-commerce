package com.nopcommerce.users;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register;

import commons.AbstractTest;
import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserCompareProductsPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserHomePO;
import pageObjectsUsers.UserLoginPO;
import pageObjectsUsers.UserOrderInCustomerInfoPO;
import pageObjectsUsers.UserOrderPagePO;
import pageObjectsUsers.UserRegisterPO;
import pageObjectsUsers.UserWishlistPagePO;

public class User_07_Order_Edit_Remove_Update_Payment_Shopping_Cart extends AbstractTest {

	WebDriver driver;
	UserHomePO homePageObject;

	UserLoginPO loginPageObject;
	UserRegisterPO registerPageObject;
	UserCustomerInfoPO customerInfor;
	UserWishlistPagePO wishlistPage;
	UserCompareProductsPO comparePage;
	UserOrderPagePO orderPage;
	UserOrderInCustomerInfoPO orderInCustomer;
	 String cityName,address,zipCode,phoneNumber,country;
	String[] info = {"$3,600.00","$0.00","$0.00","$3,600.00","360 points"};
	 List<String> a= Arrays.asList(info);
			 
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String urlValue) {

		driver = getBrowserName(browser, urlValue);
		cityName="Việt Nam";
		address="Hà Nội";
		zipCode="012W2";
		phoneNumber="098765335";
		country="Andorra";
		 homePageObject = PageGenerator.getUserHomePage(driver);
		 loginPageObject = homePageObject.clickToLoginLink();
		 customerInfor = loginPageObject.loginToSystem(Common_01_Register.email,
		 Common_01_Register.passWord);
		orderPage = PageGenerator.getOrderPage(driver);
	}

	// @Test
	public void TC_01_Add_Product_To_Cart() {

		orderPage.clickToComputer();
		orderPage.clickToDeskRop();
		orderPage.clickToProductBy("Build your own computer");
		orderPage.chooseItemInProcessorDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		orderPage.chooseItemInRamDropdown("8GB [+$60.00]");
		orderPage.clickTo400GBHHDRadio();
		orderPage.clickToOsVistaPremiumRadio();
		orderPage.clickToMicrosoftOfficeCheckBox();
		orderPage.clickToAcrobatReaderCheckBox();
		orderPage.clickToTotalCommanderCheckBox();
		orderPage.clickToAddToCart();
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		verifyEquals(orderPage.getNumberProductInCart(), "(1)");
		verifyEquals(orderPage.getNumberItemInCart(), "1 item(s)");
		verifyEquals(orderPage.nameProductsDisplayed(), "Build your own computer");
		verifyEquals(orderPage.attributeProductsDisplayed(),
				"Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\n" + "RAM: 8GB [+$60.00]\n"
						+ "HDD: 400 GB [+$100.00]\n" + "OS: Vista Premium [+$60.00]\n"
						+ "Software: Microsoft Office [+$50.00]\n" + "Software: Acrobat Reader [+$10.00]\n"
						+ "Software: Total Commander [+$5.00]");

		verifyEquals(orderPage.getUnitPrices(), "$1,500.00");
		verifyEquals(orderPage.getQuantity(), "1");
		verifyEquals(orderPage.getTotalPrice(), "$1,500.00");

	}

	// @Test(dependsOnMethods = "TC_01_Add_Product_To_Cart")
	public void TC_02_Edit_Product() {
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		orderPage.clickToEditLink();
		orderPage.chooseItemInProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");
		orderPage.chooseItemInRamDropdown("4GB [+$20.00]");
		orderPage.clickTo320GBHHDRadio();
		orderPage.clickToOsVistaHomeRadio();
		orderPage.clickToMicrosoftOfficeCheckBox();
		orderPage.unCheckAcrobatReaderCheckBox();
		orderPage.unCheckTotalCommanderCheckBox();
		orderPage.inputNumberProducts("2");
		verifyEquals(orderPage.getPriceProduct(), "$1,320.00");
		orderPage.clickToUpdateButton();
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		verifyEquals(orderPage.getNumberProductInCart(), "(2)");
		verifyEquals(orderPage.getNumberItemInCart(), "2 item(s)");
		verifyEquals(orderPage.nameProductsDisplayed(), "Build your own computer");
		verifyEquals(orderPage.attributeProductsDisplayed(),
				"Processor: 2.2 GHz Intel Pentium Dual-Core E2200\n" + "RAM: 4GB [+$20.00]\n" + "HDD: 320 GB\n"
						+ "OS: Vista Home [+$50.00]\n" + "Software: Microsoft Office [+$50.00]");
		verifyEquals(orderPage.getUnitPrices(), "$1,320.00");
		verifyEquals(orderPage.getQuantity(), "2");
		verifyEquals(orderPage.getTotalPrice(), "$2,640.00");

	}

	// @Test(dependsOnMethods = "TC_02_Edit_Product")
	public void TC_03_Remove_Product() {
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		orderPage.clickToRemoveIcon();
		verifyEquals(orderPage.getTextMessage(), "Your Shopping Cart is empty!");
	}

	//@Test
	public void TC_04_Update_Shopping_cart() {
		orderPage.clickToComputer();
		orderPage.clickToDeskRop();
		orderPage.clickAddToCartByName("Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		verifyEquals(orderPage.getTotalPriceInShoppingCartByName("Lenovo IdeaCentre 600 All-in-One PC"), "$500.00");
		orderPage.inputQuantityTextBox("5", "Lenovo IdeaCentre 600 All-in-One PC");
		orderPage.clickUpdateShoppingCartButton();
		verifyEquals(orderPage.getTotalPriceInShoppingCartByName("Lenovo IdeaCentre 600 All-in-One PC"), "$2,500.00");

	}

	
	@Test
	public void TC_05_Order_Products() {
		orderPage.clickToComputer();
		orderPage.clickToNotebook();
		orderPage.clickAddToCartByName("Apple MacBook Pro 13-inch");
		orderPage.clickToAddToCart();
		verifyEquals(orderPage.getTexMessageDisplay(), "The product has been added to your shopping cart");
		orderPage.hoverToShoppingCart();
		orderPage.clickToGoToCartButton();
		verifyEquals(orderPage.getTitlePage(), "Shopping cart");
		verifyEquals(orderPage.getTotalPriceInShoppingCartByName("Apple MacBook Pro 13-inch"), "$3,600.00");
		orderPage.chooseItemInGiftWrappingDropdown("No");
		verifyEquals(orderPage.getTexGiftWrapping(), "Gift wrapping: No");
		orderPage.clickToAgreeServiceCheckbox();
		orderPage.clickToCheckoutButton();
		orderPage.clickToShipToSameAddressCheckbox();
		verifyEquals(orderPage.getTextById("BillingNewAddress_FirstName"), Common_01_Register.firstName);
		verifyEquals(orderPage.getTextById("BillingNewAddress_LastName"), Common_01_Register.lastName);
		verifyEquals(orderPage.getTextById("BillingNewAddress_Email"), Common_01_Register.email);
		verifyEquals(orderPage.getTextById("BillingNewAddress_Company"), Common_01_Register.companyName);
		orderPage.chooseItemsInCountryDropdown(country);
		orderPage.inputToTextBoxById(cityName,"BillingNewAddress_City");
		orderPage.inputToTextBoxById(address,"BillingNewAddress_Address1");
		orderPage.inputToTextBoxById(zipCode,"BillingNewAddress_ZipPostalCode");
		orderPage.inputToTextBoxById(phoneNumber,"BillingNewAddress_PhoneNumber");
		orderPage.clickToContinueButtonById("billing-buttons-container");
		orderPage.clickToMethodShipRadio();
		orderPage.clickToContinueButtonById("shipping-method-buttons-container");
		orderPage.clictToMethodPaymentRadio();
		orderPage.clickToContinueButtonById("payment-method-buttons-container");
		verifyEquals(orderPage.getTextPaymentInfo(), "Mail Personal or Business Check, Cashier's Check or money order to:\n" + 
				"\n" + 
				"NOP SOLUTIONS\n" + 
				"your address here,\n" + 
				"New York, NY 10001\n" + 
				"USA\n" + 
				"Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\n" + 
				"P.S. You can edit this text from admin panel.");
		orderPage.clickToContinueButtonById("payment-info-buttons-container");
		verifyEquals(orderPage.getTextBillingAddressByClass("name"), Common_01_Register.firstName+" "+ Common_01_Register.lastName);
		verifyEquals(orderPage.getTextBillingAddressByClass("email"),"Email: "+ Common_01_Register.email);
		verifyEquals(orderPage.getTextBillingAddressByClass("phone"), "Phone: "+phoneNumber);
		verifyEquals(orderPage.getTextBillingAddressByClass("company"), Common_01_Register.companyName);
		verifyEquals(orderPage.getTextBillingAddressByClass("address1"), address);
		verifyEquals(orderPage.getTextBillingAddressByClass("city-state-zip"), cityName+","+zipCode);
		verifyEquals(orderPage.getTextBillingAddressByClass("country"), country);
		verifyEquals(orderPage.getTextMethodPayment(), "Check / Money Order");
		
		
		verifyEquals(orderPage.getTextShippingAddressByClass("name"), Common_01_Register.firstName+" "+ Common_01_Register.lastName);
		verifyEquals(orderPage.getTextShippingAddressByClass("email"), "Email: "+Common_01_Register.email);
		verifyEquals(orderPage.getTextShippingAddressByClass("phone"), "Phone: "+phoneNumber);
		verifyEquals(orderPage.getTextShippingAddressByClass("company"), Common_01_Register.companyName);
		verifyEquals(orderPage.getTextShippingAddressByClass("address1"), address);
		verifyEquals(orderPage.getTextShippingAddressByClass("city-state-zip"), cityName+","+zipCode);
		verifyEquals(orderPage.getTextShippingAddressByClass("country"), country);
		verifyEquals(orderPage.getTextMethodShipping(), "Ground");
		
		verifyTrue(orderPage.isInfoProductsDiplayed("AP_MBP_13","Apple MacBook Pro 13-inch","$1,800.00","2","$3,600.00"));
		verifyEquals(orderPage.getTexGiftWrapping(), "Gift wrapping: No");
		verifyTrue(orderPage.areInfoPaymentInCartFooter(a));
		
		orderPage.clickToCofirmButton();
		
	//	verifyEquals(orderPage.getTitlePage(), "Thank you");
		verifyTrue(orderPage.isMessageOrderSuccessDisplayed());
		verifyTrue(orderPage.isOrderNumberDisplayed());
		String orderNumber=orderPage.getOrderNumber();
		homePageObject=PageGenerator.getUserHomePage(driver);
		customerInfor=homePageObject.clickToMyAccountLink();
		orderInCustomer=customerInfor.openOrderPage(driver);
		verifyEquals(orderInCustomer.getOrderNumberInCustomerIfo().toLowerCase(), orderNumber.toLowerCase());
		orderInCustomer.clickToDetailButton();
		
		
		//verifyEquals(orderInCustomer.getOrderDate(),"" );
		//verifyEquals(orderInCustomer.getOrderNumberInCustomerIfo().split(""),"" );
		verifyEquals(orderInCustomer.getOrderTotal(),"$3,600.00" );
		
		
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("name"), Common_01_Register.firstName+" "+ Common_01_Register.lastName);
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("email"),"Email: "+ Common_01_Register.email);
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("phone"), "Phone: "+phoneNumber);
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("company"), Common_01_Register.companyName);
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("address1"), address);
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("city-state-zip"), cityName+","+zipCode);
		verifyEquals(orderInCustomer.getTextBillingAddressByClass("country"), country);
		verifyEquals(orderInCustomer.getTextMethodPayment(), "Check / Money Order");
		
		
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("name"), Common_01_Register.firstName+" "+ Common_01_Register.lastName);
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("email"), "Email: "+Common_01_Register.email);
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("phone"), "Phone: "+phoneNumber);
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("company"), Common_01_Register.companyName);
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("address1"), address);
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("city-state-zip"), cityName+","+zipCode);
		verifyEquals(orderInCustomer.getTextShippingAddressByClass("country"), country);
		verifyEquals(orderInCustomer.getTextMethodShipping(), "Ground");
		
		verifyTrue(orderInCustomer.isInfoProductsDiplayed("AP_MBP_13","Apple MacBook Pro 13-inch","$1,800.00","2","$3,600.00"));
		verifyEquals(orderInCustomer.getTexGiftWrapping(), "Gift wrapping: No");
		verifyTrue(orderInCustomer.areInfoPaymentInCartFooter(a));
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
