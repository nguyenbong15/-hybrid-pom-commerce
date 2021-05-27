package commons;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {
	
	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	
	protected WebDriver getBrowserName(String browser) {
		
		if (browser.equals("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome_ui")) {
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox_headless")) {
			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browser.equals("chrome_headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equals("edge_chromium")) {
			System.setProperty("webdriver.edge.driver", projectFolder + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Pleasse input browser name!!!");
		}
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	protected WebDriver getBrowserName(String browser,String url) {
		
	if (browser.equals("firefox_ui")) {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	} else if (browser.equals("chrome_ui")) {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
	} else if (browser.equals("firefox_headless")) {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		driver = new FirefoxDriver(options);
	} else if (browser.equals("chrome_headless")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
	} else if (browser.equals("edge_chromium")) {
		System.setProperty("webdriver.edge.driver", projectFolder + "\\browserDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
	} else {
		throw new RuntimeException("Pleasse input browser name!!!");
	}
	driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
	return driver;
	}
	protected int getRandomNumber() {
		Random rd = new Random();
		return rd.nextInt(99999);
	}
}
