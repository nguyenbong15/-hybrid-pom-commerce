package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserMyProductsReviewPageUI;

public class UserMyProductReviewPO extends AbstractPage {
	WebDriver driver;
	public UserMyProductReviewPO( WebDriver driver) {
		this.driver=driver;
		
	}
	public String getTitleReview() {
		waitToElementVisible(driver, UserMyProductsReviewPageUI.TITLE_REVIEW_TEXTBOX);
		return getTextElement(driver, UserMyProductsReviewPageUI.TITLE_REVIEW_TEXTBOX);
	}
	public String getNameProductsReview() {
		waitToElementVisible(driver, UserMyProductsReviewPageUI.NAME_PRODUCTS_REVIEW_TEXTBOX);
		return getTextElement(driver, UserMyProductsReviewPageUI.NAME_PRODUCTS_REVIEW_TEXTBOX);
	}
	public String getTextReview() {
		waitToElementVisible(driver, UserMyProductsReviewPageUI.TEXT_REVIEW_TEXTBOX);
		return getTextElement(driver, UserMyProductsReviewPageUI.TEXT_REVIEW_TEXTBOX);
	}
	
}
