package com.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utils.CommonMethods;

public class CreateAccountPageElements extends CommonMethods {

	@FindBy(id = "uniform-id_gender1")
	public WebElement title;

	@FindBy(id = "email_create")
	public WebElement emailAddress;

	@FindBy(id = "SubmitCreate")
	public WebElement createAccountBtn;

	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;

	@FindBy(id = "passwd")
	public WebElement password;

	@FindBy(xpath = "//select[@id='days']")
	public WebElement selectDays;

	@FindBy(id = "months")
	public WebElement SelectMonths;

	@FindBy(id = "years")
	public WebElement selectYears;

	@FindBy(id = "firstname")
	public WebElement addressFirstName;

	@FindBy(id = "lastname")
	public WebElement addressLastName;

	@FindBy(id = "address1")
	public WebElement Address1;

	@FindBy(id = "city")
	public WebElement city;

	@FindBy(id = "id_state")
	public WebElement selectState;

	@FindBy(id = "postcode")
	public WebElement zipCode;

	@FindBy(id = "id_country")
	public WebElement selectCountry;

	@FindBy(id = "phone_mobile")
	public WebElement mobilePhone;

	@FindBy(xpath = "//span[normalize-space()='Register']")
	public WebElement registerBtn;

	@FindBy(xpath = "//a[@title='Log me out']")
	public WebElement signOut;

	@FindBy(xpath = "//h1[normalize-space()='My account']")
	public WebElement myAccount;

	public CreateAccountPageElements() {
		PageFactory.initElements(driver, this);
	}
}