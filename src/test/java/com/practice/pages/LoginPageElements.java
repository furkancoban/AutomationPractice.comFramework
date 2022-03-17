package com.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	public WebElement signIn;

	@FindBy(id = "email")
	public WebElement emailAddress;
	
	@FindBy(id = "passwd")
	public WebElement password;
	
	@FindBy(css = "#SubmitLogin")
	public WebElement signInBtn;
	
	@FindBy(css = "div[class='alert alert-danger'] ol li")
	public WebElement errorMsg;
	
	
	
	
	
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
}