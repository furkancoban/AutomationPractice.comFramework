package com.practice.testbase;

import com.practice.pages.CreateAccountPageElements;
import com.practice.pages.LoginPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static CreateAccountPageElements createAccount;

	
	
	
	
	public static void initializeAllPages() {

		login = new LoginPageElements();
		createAccount = new CreateAccountPageElements();
	}
}