package pageUIsUser;

public class UserOrderPageUI {
	public static final String COMPUTER_LINK = "//div[@class='header-menu']//ul[1]//a[text()='Computers ']";
	public static final String DESKTOP_LINK = "//ul[@class='top-menu notmobile']//a[text()='Desktops ']";
	public static final String NAME_PROUCTS_LINK = "//div[@class='products-wrapper']//a[text()='%s']";
	public static final String PROCESSOR_DROPDOWN = "//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN = "//select[@id='product_attribute_2']";
	public static final String HHD_FOURTY_GB_RADIO = "//input[@id='product_attribute_3_7']";
	public static final String HHD_ORTHER_GB_RADIO = "//input[@id='product_attribute_3_6']";
	public static final String OS_PREMIUM_RADIO = "//input[@id='product_attribute_4_9']";
	public static final String OS_HOME_RADIO = "//input[@id='product_attribute_4_8']";

	public static final String MICROSOFT_CHECKBOX = "//input[@id='product_attribute_5_10']";
	public static final String ACROBAT_CHECKBOX = "//input[@id='product_attribute_5_11']";
	public static final String TOTAL_CHECKBOX = "//input[@id='product_attribute_5_12']";
	public static final String ADD_TO_CART_BUTTON = "//button[@id='add-to-cart-button-1']";
	public static final String MESSAGE = "//div[@id='bar-notification']//p";
	public static final String SHOPPING_CART_LINK = "//li[@id='topcartlink']//a";
	public static final String NUMBER_IN_CART_LINK = "//li[@id='topcartlink']//span[@class='cart-qty']";
	public static final String NUMBER_ITEMS_IN_CART_LINK = "//div[@id='flyout-cart']//div[@class='count']//a";
	public static final String NAME_PRODUCTS_VERIFY = "//div[@id='flyout-cart']//div[@class='name']//a";
	public static final String PROCESSOR_VERIFY = "//div[@class='attributes']";
	public static final String GO_TO_CART_BUTTON = "//button[text()='Go to cart']";
	public static final String TITLE_PAGE = "//div[@class='page-title']/h1";
	public static final String EDIT_LINK = "//div[@class='edit-item']/a";
	public static final String UNIT_PRICE_VERIFY = "//div[@class='price']/span";
	public static final String QUANTITY_PRICE_VERIFY = "//div[@class='quantity']/span";
	public static final String TOTAL_PRICE_VERIFY = "//div[@class='totals']/strong";
	public static final String QUANTITY_TEXTBOX = "//input[@name='addtocart_1.EnteredQuantity']";
	public static final String UNIT_PRICEs = "//div[@class='prices']//span";
	public static final String UPDATE_BUTTON = "//button[text()='Update']";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "//button[text()='Update shopping cart']";
	public static final String ICON_REMOVE = "//button[@class='remove-btn']";
	public static final String MEASSAGE_NODATA = "//div[@class='no-data']";
	public static final String ADD_TO_CART_BUTTON_BY_NAME = "//a[text()='%s']/parent::h2//following-sibling::div[@class='add-info']//button[text()='Add to cart']";
	public static final String QUANTITY_TEXTBOX_IN_SHOPPING_CART_BY_NAME = "//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']//input";
	public static final String TOTAL_PRICES_IN_SHOPPING_CART_BY_NAME = "//a[text()='%s']/parent::td/following-sibling::td[@class='subtotal']//span";
	public static final String ICON_LOADING = "//div[@id='ajaxBusy']/span";

}
