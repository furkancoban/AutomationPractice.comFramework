package com.practice.steps;

import org.junit.Assert;

import com.practice.utils.CommonMethods;
import com.practice.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() {

	//Click on "Sign In" button by using JS click method from CommonMethods utility Class.
	jsClick(login.signIn);
	
	}

	@When("User signs in with invalid credentials")
	public void user_signs_in_with_invalid_credentials() {

		// Enter invalid email in the "Email Address" field by using getProperty method from the ConfigsReader utility.
		sendText(login.emailAddress, ConfigsReader.getProperty("invaildEmail"));
		
		// Enter invalid password in the "Password" field by using getProperty method from the ConfigsReader utility.
		sendText(login.password, ConfigsReader.getProperty("invaildPassword"));
		
		// Click on "Sign in" Button by using click method from CommonMethods utility Class.
		click(login.signInBtn);
	}

	@Then("Verify that the user receives an error message")
	public void verify_that_the_user_receives_an_error_message() {

		//By using isDisplayed() method I have checked if error message displayed and stored in a boolean
		//and then by using Junit assertions I verified if error message was displayed.
		
		Boolean isErrorMsgVisible = login.errorMsg.isDisplayed();
		Assert.assertTrue(isErrorMsgVisible);
	}
}