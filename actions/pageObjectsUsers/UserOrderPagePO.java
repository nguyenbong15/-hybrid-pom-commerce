package pageObjectsUsers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import commons.AbstractPage;
import pageUIsUser.UserOrderPageUI;
import pageUIsUser.UserSortDisplayPagingUI;

public class UserOrderPagePO extends AbstractPage {

	WebDriver driver;

	public UserOrderPagePO(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToComputer() {
		waitToElementVisible(driver, UserOrderPageUI.COMPUTER_LINK);
		hoverMouseToElement(driver, UserOrderPageUI.COMPUTER_LINK);

	}

	public void clickToDeskRop() {
		waitToElementclickable(driver, UserOrderPageUI.DESKTOP_LINK);
		clickToElement(driver, UserOrderPageUI.DESKTOP_LINK);

	}

	public void chooseItemInProcessorDropdown(String itemValue) {
		waitToElementVisible(driver, UserOrderPageUI.PROCESSOR_DROPDOWN);
		selectItemInDropdown(driver, UserOrderPageUI.PROCESSOR_DROPDOWN, itemValue);
	}

	public void clickToProductBy(String value) {
		waitToElementclickable(driver, UserOrderPageUI.NAME_PROUCTS_LINK, value);
		clickToElement(driver, UserOrderPageUI.NAME_PROUCTS_LINK, value);

	}

	public void chooseItemInRamDropdown(String itemValue) {
		waitToElementVisible(driver, UserOrderPageUI.RAM_DROPDOWN);
		selectItemInDropdown(driver, UserOrderPageUI.RAM_DROPDOWN, itemValue);

	}

	public void clickTo400GBHHDRadio() {
		waitToElementclickable(driver, UserOrderPageUI.HHD_FOURTY_GB_RADIO);
		clickToElement(driver, UserOrderPageUI.HHD_FOURTY_GB_RADIO);
	}

	public void clickToOsVistaPremiumRadio() {
		waitToElementclickable(driver, UserOrderPageUI.OS_PREMIUM_RADIO);
		clickToElement(driver, UserOrderPageUI.OS_PREMIUM_RADIO);

	}

	public void clickToAddToCart() {
		// sleepSecond(2);
		waitToElementclickable(driver, UserOrderPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserOrderPageUI.ADD_TO_CART_BUTTON);

	}

	public String getTexMessageDisplay() {
		waitToElementVisible(driver, UserOrderPageUI.MESSAGE);
		return getTextElement(driver, UserOrderPageUI.MESSAGE);
	}

	public void hoverToShoppingCart() {
		waitToElementInvisible(driver, UserOrderPageUI.MESSAGE);
		waitToElementVisible(driver, UserOrderPageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, UserOrderPageUI.SHOPPING_CART_LINK);
	}

	public String getNumberProductInCart() {
		waitToElementVisible(driver, UserOrderPageUI.NUMBER_IN_CART_LINK);

		return getTextElement(driver, UserOrderPageUI.NUMBER_IN_CART_LINK);
	}

	public String getNumberItemInCart() {
		waitToElementVisible(driver, UserOrderPageUI.NUMBER_ITEMS_IN_CART_LINK);

		return getTextElement(driver, UserOrderPageUI.NUMBER_ITEMS_IN_CART_LINK);
	}

	public String nameProductsDisplayed() {
		waitToElementVisible(driver, UserOrderPageUI.NAME_PRODUCTS_VERIFY);

		return getTextElement(driver, UserOrderPageUI.NAME_PRODUCTS_VERIFY);
	}

	public String attributeProductsDisplayed() {
		waitToElementVisible(driver, UserOrderPageUI.PROCESSOR_VERIFY);
		System.out.println(UserOrderPageUI.PROCESSOR_VERIFY);
		return getTextElement(driver, UserOrderPageUI.PROCESSOR_VERIFY);
	}

	public void clickToMicrosoftOfficeCheckBox() {
		waitToElementclickable(driver, UserOrderPageUI.MICROSOFT_CHECKBOX);
		checkToCheckbox(driver, UserOrderPageUI.MICROSOFT_CHECKBOX);
	}

	public void clickToAcrobatReaderCheckBox() {
		waitToElementclickable(driver, UserOrderPageUI.ACROBAT_CHECKBOX);
		checkToCheckbox(driver, UserOrderPageUI.ACROBAT_CHECKBOX);

	}

	public void clickToTotalCommanderCheckBox() {
		waitToElementclickable(driver, UserOrderPageUI.TOTAL_CHECKBOX);
		checkToCheckbox(driver, UserOrderPageUI.TOTAL_CHECKBOX);

	}

	public void clickToGoToCartButton() {
		waitToElementclickable(driver, UserOrderPageUI.GO_TO_CART_BUTTON);
		clickToElement(driver, UserOrderPageUI.GO_TO_CART_BUTTON);

	}

	public String getTitlePage() {
		waitToElementVisible(driver, UserOrderPageUI.TITLE_PAGE);

		return getTextElement(driver, UserOrderPageUI.TITLE_PAGE);
	}

	public void clickToEditLink() {
		waitToElementclickable(driver, UserOrderPageUI.EDIT_LINK);
		clickToElement(driver, UserOrderPageUI.EDIT_LINK);
	}

	public void clickTo320GBHHDRadio() {
		waitToElementclickable(driver, UserOrderPageUI.HHD_ORTHER_GB_RADIO);
		clickToElement(driver, UserOrderPageUI.HHD_ORTHER_GB_RADIO);
	}

	public void clickToOsVistaHomeRadio() {
		waitToElementclickable(driver, UserOrderPageUI.OS_HOME_RADIO);
		clickToElement(driver, UserOrderPageUI.OS_HOME_RADIO);

	}

	public void unCheckAcrobatReaderCheckBox() {
		waitToElementclickable(driver, UserOrderPageUI.ACROBAT_CHECKBOX);
		uncheckToCheckbox(driver, UserOrderPageUI.ACROBAT_CHECKBOX);

	}

	public void unCheckTotalCommanderCheckBox() {
		waitToElementclickable(driver, UserOrderPageUI.TOTAL_CHECKBOX);
		uncheckToCheckbox(driver, UserOrderPageUI.TOTAL_CHECKBOX);
	}

	public String getUnitPrices() {
		waitToElementVisible(driver, UserOrderPageUI.UNIT_PRICE_VERIFY);
		return getTextElement(driver, UserOrderPageUI.UNIT_PRICE_VERIFY);
	}

	public String getQuantity() {
		waitToElementVisible(driver, UserOrderPageUI.QUANTITY_PRICE_VERIFY);
		return getTextElement(driver, UserOrderPageUI.QUANTITY_PRICE_VERIFY);
	}

	public String getTotalPrice() {
		waitToElementVisible(driver, UserOrderPageUI.TOTAL_PRICE_VERIFY);
		return getTextElement(driver, UserOrderPageUI.TOTAL_PRICE_VERIFY);
	}

	public void inputNumberProducts(String value) {
		sleepSecond(1);
		waitToElementVisible(driver, UserOrderPageUI.QUANTITY_TEXTBOX);
		senkeyToElement(driver, UserOrderPageUI.QUANTITY_TEXTBOX, value);

	}

	public String getPriceProduct() {
		waitToElementVisible(driver, UserOrderPageUI.UNIT_PRICEs);

		return getTextElement(driver, UserOrderPageUI.UNIT_PRICEs);
	}

	public void clickToUpdateButton() {
		waitToElementclickable(driver, UserOrderPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserOrderPageUI.UPDATE_BUTTON);

	}

	public void clickToRemoveIcon() {

		waitToElementclickable(driver, UserOrderPageUI.ICON_REMOVE);
		clickToElement(driver, UserOrderPageUI.ICON_REMOVE);
	}

	public String getTextMessage() {
		waitToElementVisible(driver, UserOrderPageUI.MEASSAGE_NODATA);
		return getTextElement(driver, UserOrderPageUI.MEASSAGE_NODATA);
	}

	public void clickAddToCartByName(String nameProduct) {
		waitToElementclickable(driver, UserOrderPageUI.ADD_TO_CART_BUTTON_BY_NAME, nameProduct);
		clickToElement(driver, UserOrderPageUI.ADD_TO_CART_BUTTON_BY_NAME, nameProduct);

	}

	public void inputQuantityTextBox(String value, String nameProduct) {
		waitToElementVisible(driver, UserOrderPageUI.QUANTITY_TEXTBOX_IN_SHOPPING_CART_BY_NAME, nameProduct);
		senkeyToElement(driver, UserOrderPageUI.QUANTITY_TEXTBOX_IN_SHOPPING_CART_BY_NAME, value, nameProduct);

	}

	public void clickUpdateShoppingCartButton() {

		waitToElementclickable(driver, UserOrderPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, UserOrderPageUI.UPDATE_SHOPPING_CART_BUTTON);
		waitToAjaxLoading(driver, UserOrderPageUI.ICON_LOADING);
	}

	public String getTotalPriceInShoppingCartByName(String nameProduct) {

		waitToElementVisible(driver, UserOrderPageUI.TOTAL_PRICES_IN_SHOPPING_CART_BY_NAME, nameProduct);
		return getTextElement(driver, UserOrderPageUI.TOTAL_PRICES_IN_SHOPPING_CART_BY_NAME, nameProduct);
	}

	public void clickToNotebook() {
		waitToElementclickable(driver, UserOrderPageUI.NOTEBOOK_LINK);
		clickToElement(driver, UserOrderPageUI.NOTEBOOK_LINK);

	}

	public void chooseItemInGiftWrappingDropdown(String itemValue) {
		waitToElementVisible(driver, UserOrderPageUI.GIFT_WRAPPING_DROPDOWN);
		selectItemInDropdown(driver, UserOrderPageUI.GIFT_WRAPPING_DROPDOWN, itemValue);
	}

	public String getTexGiftWrapping() {
		waitToElementVisible(driver, UserOrderPageUI.GIFT_WRAPPING_TEXT_VERIFY);
		return getTextElement(driver, UserOrderPageUI.GIFT_WRAPPING_TEXT_VERIFY);
	}

	public void clickToAgreeServiceCheckbox() {
		waitToElementclickable(driver, UserOrderPageUI.AGREE_SERVICE_CHECKBOX);
		clickToElement(driver, UserOrderPageUI.AGREE_SERVICE_CHECKBOX);

	}

	public void clickToCheckoutButton() {
		waitToElementclickable(driver, UserOrderPageUI.CHECK_OUT_BUTTON);
		clickToElement(driver, UserOrderPageUI.CHECK_OUT_BUTTON);

	}

	public String getTextById(String id) {
		waitToElementVisible(driver, UserOrderPageUI.FIRST_LAST_NAME_EMAIL_VERIFY, id);
		return getAttributeElement(driver, UserOrderPageUI.FIRST_LAST_NAME_EMAIL_VERIFY,"value", id);
	}

	public void chooseItemsInCountryDropdown(String country) {
		waitToElementVisible(driver, UserOrderPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserOrderPageUI.COUNTRY_DROPDOWN, country);
	}

	public void inputToTextBoxById(String cityName, String id) {
		waitToElementVisible(driver, UserOrderPageUI.INPUT_TEXTBOX_BY_ID, id);
		senkeyToElement(driver, UserOrderPageUI.INPUT_TEXTBOX_BY_ID, cityName, id);
	}

	public void clickToContinueButtonById(String id) {
		waitToElementclickable(driver, UserOrderPageUI.CONTINUE_BUTTON, id);
		clickToElement(driver, UserOrderPageUI.CONTINUE_BUTTON, id);

	}

	public void clickToShipToSameAddressCheckbox() {
		waitToElementclickable(driver, UserOrderPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		checkToCheckbox(driver, UserOrderPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);

	}

	public void clickToMethodShipRadio() {
		waitToElementclickable(driver, UserOrderPageUI.METHOD_SHIP_RADIO);
		clickToElement(driver, UserOrderPageUI.METHOD_SHIP_RADIO);

	}

	public void clictToMethodPaymentRadio() {
		waitToElementclickable(driver, UserOrderPageUI.METHOD_PAYMENT_RADIO);
		clickToElement(driver, UserOrderPageUI.METHOD_PAYMENT_RADIO);

	}

	public String getTextPaymentInfo() {
		waitToElementVisible(driver, UserOrderPageUI.PAYMENT_INFO);
		return getTextElement(driver, UserOrderPageUI.PAYMENT_INFO);
	}

	public String getTextBillingAddressByClass(String classTexbox) {
		waitToElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_VERIFY, classTexbox);
		return getTextElement(driver, UserOrderPageUI.BILLING_ADDRESS_VERIFY,classTexbox);
	}

	public String getTextMethodPayment() {
		waitToElementVisible(driver, UserOrderPageUI.PAYMENT_TEX_VERIFY);
		return getTextElement(driver, UserOrderPageUI.PAYMENT_TEX_VERIFY);
	}

	public String getTextShippingAddressByClass(String classTexbox) {
		waitToElementVisible(driver, UserOrderPageUI.SHPPING_ADDRESS_VERIFY, classTexbox);
		return getTextElement(driver, UserOrderPageUI.SHPPING_ADDRESS_VERIFY, classTexbox);
	}

	public String getTextMethodShipping() {
		waitToElementVisible(driver, UserOrderPageUI.SHIPPING_TEX_VERIFY);
		return getTextElement(driver, UserOrderPageUI.SHIPPING_TEX_VERIFY);
	}

	public boolean isInfoProductsDiplayed(String sku, String nameProduct, String unitPrices, String count,
			String totalPrices) {
		waitToElementVisible(driver, UserOrderPageUI.INFO_PRODUCT_VERIFY, sku, nameProduct, unitPrices, count,
				totalPrices);
		return isElementDisplayed(driver, UserOrderPageUI.INFO_PRODUCT_VERIFY, sku, nameProduct, unitPrices, count,
				totalPrices);
	}

	public String getTexCartFooterByName(String name) {
		waitToElementVisible(driver, UserOrderPageUI.CART_FOOTER_VERIFY, name);
		return getTextElement(driver, UserOrderPageUI.CART_FOOTER_VERIFY, name);
	}

	public void clickToCofirmButton() {
		waitToElementclickable(driver, UserOrderPageUI.COFIRM_BUTTON);
		clickToElement(driver, UserOrderPageUI.COFIRM_BUTTON);

	}

	
	public boolean areInfoPaymentInCartFooter( List<String> info) {
		waitToAllElementVisible(driver, UserOrderPageUI.CART_FOOTER_VERIFY);
		List<WebElement> products= getElements(driver, UserOrderPageUI.CART_FOOTER_VERIFY);
		ArrayList<String> dataOnUI=new ArrayList<String>();
	    for (WebElement webElement : products) {
			dataOnUI.add(webElement.getText());
		}           
	    return dataOnUI.equals(info);
	}

	public boolean isOrderNumberDisplayed() {
		waitToElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_TEXT);
		return isElementDisplayed(driver, UserOrderPageUI.ORDER_NUMBER_TEXT);
	}

	public boolean isMessageOrderSuccessDisplayed() {
		waitToElementVisible(driver, UserOrderPageUI.MESSAGE_ORDER_SUCESS);
		return isElementDisplayed(driver, UserOrderPageUI.MESSAGE_ORDER_SUCESS);
	}

	public String getOrderNumber() {
		waitToElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_TEXT);
		return getTextElement(driver, UserOrderPageUI.ORDER_NUMBER_TEXT);
	}

	

}
