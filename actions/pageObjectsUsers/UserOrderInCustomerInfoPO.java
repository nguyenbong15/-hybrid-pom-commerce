package pageObjectsUsers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIsUser.UserOrderInCustomerUI;

public class UserOrderInCustomerInfoPO extends AbstractPage {
	WebDriver driver;

	public UserOrderInCustomerInfoPO(WebDriver driver) {
		this.driver = driver;

	}

	public String getOrderNumberInCustomerIfo() {
		waitToElementVisible(driver, UserOrderInCustomerUI.ORDER_NUMBER);
		return getTextElement(driver, UserOrderInCustomerUI.ORDER_NUMBER);
	}

	public void clickToDetailButton() {
		waitToElementclickable(driver, UserOrderInCustomerUI.DETAILS_BUTTON);
clickToElement(driver, UserOrderInCustomerUI.DETAILS_BUTTON);
	}

	public String getTextBillingAddressByClass(String classTexbox) {
		waitToElementVisible(driver, UserOrderInCustomerUI.BILLING_ADDRESS_VERIFY, classTexbox);
		return getTextElement(driver, UserOrderInCustomerUI.BILLING_ADDRESS_VERIFY, classTexbox);
	}

	public String getTextMethodPayment() {
		waitToElementVisible(driver, UserOrderInCustomerUI.PAYMENT_TEX_VERIFY);
		return getTextElement(driver, UserOrderInCustomerUI.PAYMENT_TEX_VERIFY);
	}

	public String getTextShippingAddressByClass(String classTexbox) {
		waitToElementVisible(driver, UserOrderInCustomerUI.SHPPING_ADDRESS_VERIFY, classTexbox);
		return getTextElement(driver, UserOrderInCustomerUI.SHPPING_ADDRESS_VERIFY, classTexbox);
	}

	public String getTextMethodShipping() {
		waitToElementVisible(driver, UserOrderInCustomerUI.SHIPPING_TEX_VERIFY);
		return getTextElement(driver, UserOrderInCustomerUI.SHIPPING_TEX_VERIFY);
	}

	public boolean isInfoProductsDiplayed(String sku, String nameProduct, String unitPrices, String count,
			String totalPrices) {
		waitToElementVisible(driver, UserOrderInCustomerUI.INFO_PRODUCT_VERIFY, sku, nameProduct, unitPrices, count,
				totalPrices);
		return isElementDisplayed(driver, UserOrderInCustomerUI.INFO_PRODUCT_VERIFY, sku, nameProduct, unitPrices, count,
				totalPrices);
	}

	public String getTexGiftWrapping() {
		waitToElementVisible(driver, UserOrderInCustomerUI.GIFT_WRAPPING_TEXT_VERIFY);
		return getTextElement(driver, UserOrderInCustomerUI.GIFT_WRAPPING_TEXT_VERIFY);
	}

	public boolean areInfoPaymentInCartFooter(List<String> a) {
		waitToAllElementVisible(driver, UserOrderInCustomerUI.CART_FOOTER_VERIFY);
		List<WebElement> products = getElements(driver, UserOrderInCustomerUI.CART_FOOTER_VERIFY);
		ArrayList<String> dataOnUI = new ArrayList<String>();
		for (WebElement webElement : products) {
			dataOnUI.add(webElement.getText());
		}
		return dataOnUI.equals(a);
	}

	public String getOrderDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrderTotal() {
		waitToElementVisible(driver, UserOrderInCustomerUI.ORDER_TOTAl);
		return getTextElement(driver, UserOrderInCustomerUI.ORDER_TOTAl);
	}

	public UserOrderPagePO openOrderPage() {
		waitToElementclickable(driver, UserOrderInCustomerUI.RE_ORDER_BUTTON);
		clickToElement(driver, UserOrderInCustomerUI.RE_ORDER_BUTTON);
		return PageGenerator.getOrderPage(driver);
	}

}
