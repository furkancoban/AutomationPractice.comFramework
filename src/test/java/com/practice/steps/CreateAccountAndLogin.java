package com.practice.steps;

import org.junit.Assert;

import com.practice.utils.CommonMethods;
import com.practice.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountAndLogin extends CommonMethods {

	@Given("User creates a new account, providing the minimum required information")
	public void user_creates_a_new_account_providing_the_minimum_required_information() {

		// sending email that I get from configurations.properties file by using ConfigsReader utility.
		sendText(createAccount.emailAddress, ConfigsReader.getProperty("Email"));
		
		// by using java script click I click on "Create Account" button.
		jsClick(createAccount.createAccountBtn);
		
		// I select title of the new user
		click(createAccount.title);
		
		// sending firstname of the user
		sendText(createAccount.firstName, "Furkan");
		
		// sending lastname of the user
		sendText(createAccount.lastName, "Coban");
		
		// sending password of the user
		sendText(createAccount.password, ConfigsReader.getProperty("password"));
		
		//selecting day.month, and year for date of birth of the new user.
		selectDropdown(createAccount.selectDays, 5);
		selectDropdown(createAccount.SelectMonths, 8);
		selectDropdown(createAccount.selectYears, 22);
		
		// sending address and phone number information of the new user.
		
		sendText(createAccount.addressFirstName, "Furkan");
		sendText(createAccount.addressLastName, "Coban");
		sendText(createAccount.Address1,  "Test Street 1122");
		sendText(createAccount.city,  "Austin");
		selectDropdown(createAccount.selectState, 43);
		sendText(createAccount.zipCode, "78798");
		selectDropdown(createAccount.selectCountry, 21);
		sendText(createAccount.mobilePhone, "7373362640");
		
		// click on "Register" button
		click(createAccount.registerBtn);
	}

	@When("User signs out")
	public void user_signs_out() {

		// Signining out
		click(createAccount.signOut);
	}

	@Then("User signs in with the newly created account")
	public void user_signs_in_with_the_newly_created_account() {

		// Signining in with the new account created
		sendText(login.emailAddress, ConfigsReader.getProperty("Email"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.signInBtn);
	}

	@Then("Verify that user signed in successfully.")
	public void verify_that_user_signed_in_successfully() {

		// Verifity that new user has successfully signed in
		Boolean isSuccessfull = createAccount.myAccount.isDisplayed();
		Assert.assertTrue(isSuccessfull);
	}
}