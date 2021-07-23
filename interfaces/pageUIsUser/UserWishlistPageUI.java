package pageUIsUser;

public class UserWishlistPageUI {
	public static final String PRODUCTS_INFO="//span[text()='%s']/parent::td/following-sibling::td[@class='product']/a[text()='%s']/parent::td/following-sibling::td[@class='unit-price']/span[text()='%s']";
	public static final String CHECKBOX="//a[text()='%s']/parent::td/preceding-sibling::td[@class='add-to-cart']/input";
	public static final String ADD_TO_CART_BUTTON_BY_NAME="//button[@class='button-2 wishlist-add-to-cart-button']";
	public static final String TITLE_PAGE="//div[@class='page-title']/h1[text()='%s']";
	public static final String WISHLIST_LINK = "//span[@class='wishlist-label']";
	public static final String NO_DATA = "//div[@class='no-data']";
	public static final String REMOVE_BUTTON_BY_NAME = "//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']//button[@class='remove-btn']";
	public static final String UPDATE_BUTTON = "//button[@class='button-2 update-wishlist-button']";
	public static final String ADD_PRODUCTS_BY_NAME="//h2[@class='product-title']/a[text()='%s']";
	public static final String ADD_TO_WISHLIST_BUTTON="//div[@class='overview-buttons']//button[text()='Add to wishlist']";
	public static final String MESSAGE_ADD_TO_WISHLIST="//div[@class='bar-notification success']/p[text()='The product has been added to your ']";
	public static final String CLOSE_MESSAGE_BUTTON="//span[@class='close']";
	public static final String PRODUCT_NAME_LINK="//div[@class='details']//a[text()='%s']";
	public static final String COMPUTER_LINK="//ul[@class='top-menu notmobile']//a[text()='Computers ']";
	public static final String DESKTOP_LINK="//ul[@class='top-menu notmobile']//a[text()='Desktops ']";
	public static final String AJAX_ICON="//div[@class='ajax-products-busy']";
}
