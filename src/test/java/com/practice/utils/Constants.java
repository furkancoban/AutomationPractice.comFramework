package com.practice.utils;

public class Constants {

	public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/configs/configurations.properties";

	public static final String WINDOWS_CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	
	public static final String MAC_CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";

	public static final String WINDOWS_GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe";

	public static final String MAC_GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";

	public static final int IMPLICIT_WAIT_TIME = 15;

	public static final int EXPLICIT_WAIT_TIME = 25;
	
	public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir") + "/screenshot/";

}
