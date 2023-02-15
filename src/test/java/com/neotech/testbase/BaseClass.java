package com.neotech.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * This method will initialize the driver
	 */
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported!!!");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
	}

	/**
	 * This method will quit the browser
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}