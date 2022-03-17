package com.practice.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practice.utils.ConfigsReader;
import com.practice.utils.Constants;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * This method will create a driver according to Operating system of the local machine and return it
	 * @return WebDriver driver
	 */
	public static WebDriver setUp() {

		String os = System.getProperty("os.name").toLowerCase();

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":

			if (os.startsWith("win")) {

				System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_CHROME_DRIVER_PATH);

			} else if (os.startsWith("mac")) {

				System.setProperty("webdriver.chrome.driver", Constants.MAC_CHROME_DRIVER_PATH);
			}

			driver = new ChromeDriver();
			break;

		case "firefox":

			if (os.startsWith("win")) {

				System.setProperty("webdriver.gecko.driver", Constants.WINDOWS_GECKO_DRIVER_PATH);

			} else if (os.startsWith("mac")) {

				System.setProperty("webdriver.gecko.driver", Constants.MAC_GECKO_DRIVER_PATH);
			}

			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("The browser you are using is not supported for this project!");
		}

		// Implicit wait for driver
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		// maximizing the browser window
		driver.manage().window().maximize();
		
		// Getting url from configuration.properties file by using ConfigsReader class.
		driver.get(ConfigsReader.getProperty("url"));

		
		// to initialize pages in Pages packages.
		PageInitializer.initializeAllPages();

		return driver;
	}

	/**
	 * This method will quit the browser.
	 */
	public static void tearDown() {

		if (driver != null) {

			driver.quit();
		}
	}
}