package com.practice.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.testbase.PageInitializer;


public class CommonMethods extends PageInitializer {

	/**
	 * This method will clear the textbox and send the new text to it.
	 * 
	 * @param WebElement
	 * @param text
	 */
	public static void sendText(WebElement WebElement, String text) {
		WebElement.clear();
		WebElement.sendKeys(text);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will check if a specified text is available in the drop down if
	 * its available then it will select it.
	 * 
	 * @param WebElement
	 * @param textToSelect
	 * @return
	 */
	public static void selectDropdown(WebElement WebElement, String textToSelect) {

		try {

			Select select = new Select(WebElement);
			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {

				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will check if an index exists in the drop down and if it exists
	 * then it will select it.
	 * 
	 * @param WebElement
	 * @param index
	 */

	public static void selectDropdown(WebElement WebElement, int index) {

		try {

			Select select = new Select(WebElement);

			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will create a WebDriverWait object and return it.
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will implement an explicit wait on a specified element.
	 * 
	 * @param WebElement
	 * @return
	 */
	public static WebElement waitForClickability(WebElement WebElement) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(WebElement));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will wait for an element to be visible.
	 * 
	 * @param WebElement
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement WebElement) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(WebElement));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will explicitly wait for an WebElement and once it is available
	 * it will click on the element.
	 * 
	 * @param WebElement
	 * @return
	 */
	public static void click(WebElement WebElement) {

		waitForClickability(WebElement);
		WebElement.click();
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will casts the driver to JavascriptExecutor and return it.
	 * 
	 * @return JavascriptExecutor
	 */
	public static JavascriptExecutor getJSObject() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will click to the WebElement that is passed using
	 * JavascriptExecutor.
	 * 
	 * @param WebElement
	 */
	public static void jsClick(WebElement WebElement) {

		getJSObject().executeScript("arguments[0].click()", WebElement);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will take a screenshot and save it with the provided filename.
	 * 
	 * @param filename
	 * @return picBytes as an array of bytes
	 */
	public static byte[] takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {

			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {

			System.out.println("Cannot take screenshot");

			e.printStackTrace();
		}
		return picBytes;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method will return the current time stamp in a String.
	 * @return time_stamp
	 */
	public static String getTimeStamp() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
