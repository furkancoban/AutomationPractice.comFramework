package com.practice.steps;


import com.practice.testbase.BaseClass;
import com.practice.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void start() {		
		
		setUp();
	}

	@After
	public void end(Scenario scenario) {

		byte[] picture;

		if (scenario.isFailed()) {
			
			picture = CommonMethods.takeScreenshot("failed/" + scenario.getName());
			
		} else{
			
			picture = CommonMethods.takeScreenshot("passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());

		tearDown();
	}
}