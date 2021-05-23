package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage_Factory {

	public void waitToElementclickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		if (driver.toString().toLowerCase().contains("edge")) {
			sleepMiliSecond(500);
		}

		element.click();
	}

	public void waitToElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOf(element));

	}

	public boolean isElementSelected(WebDriver driver, WebElement element) {

		return element.isSelected();
	}

	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {

		return element.getAttribute(attributeName);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, WebElement element) {

		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void sleepSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void senkeyToElement(WebDriver driver, WebElement element, String value) {

		element.clear();
		if (driver.toString().toLowerCase().contains("edge") || driver.toString().toLowerCase().contains("chrome")) {
			sleepMiliSecond(500);
		}
		element.sendKeys(value);
	}

	public boolean isElementDisplayed(WebDriver driver, WebElement element) {

		return element.isDisplayed();
	}

	public void selectItemInDropdown(WebDriver driver, WebElement element, String itemValue) {

		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getTextElement(WebDriver driver, WebElement element) {

		return element.getText();

	}

	public void sleepMiliSecond(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private WebDriverWait explicitWait;
	private Select select;
}
