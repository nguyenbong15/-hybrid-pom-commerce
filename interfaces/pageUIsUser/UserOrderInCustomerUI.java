package pageUIsUser;

public class UserOrderInCustomerUI {
	public static final String ORDER_NUMBER = "//strong[contains(text(),'Order')]";
	public static final String DETAILS_BUTTON = "//button[text()='Details']";
	public static final String ORDER_DATE = "//li[@class='order-date']";
	public static final String ORDER_TOTAl = "//li[@class='order-total']//strong";
	public static final String BILLING_ADDRESS_VERIFY = "//div[@class='billing-info-wrap']//li[@class='%s']";
	public static final String PAYMENT_TEX_VERIFY = "//div[@class='billing-info-wrap']//span[@class='value']";
	public static final String CART_FOOTER_VERIFY = "//td//span[@class='value-summary']";
	public static final String GIFT_WRAPPING_TEXT_VERIFY = "//div[@class='selected-checkout-attributes']";
	public static final String INFO_PRODUCT_VERIFY ="//span[text()='%s']/parent::td/following-sibling::td[@class='product']/a[text()='%s']/parent::td/following-sibling::td[@class='unit-price']/span[text()='%s']/parent::td/following-sibling::td[@class='quantity']/span[text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span[text()='%s']";
	public static final String SHIPPING_TEX_VERIFY = "//div[@class='shipping-info-wrap']//span[@class='value']";
	public static final String SHPPING_ADDRESS_VERIFY = "//div[@class='shipping-info-wrap']//li[@class='%s']";
	public static final String RE_ORDER_BUTTON = "//button[text()='Re-order']";
	

}
