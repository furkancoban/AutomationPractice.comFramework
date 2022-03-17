# Automationpractice.comFramework


This repository includes Automation.com's login, creating a new account, and negative login tests.

I have created a framework from scratch by using: 

Maven to build project structure.
Cucumber to run behavior-driven tests using Gherkin syntax. 
Junit for assertions.
Java as a programming language. 
Selenium to automate web browsers. 
Apache commons-io for taking screenshots after each test scenario.
Surefire reports for test reports.

--- How to Execute Tests ---

Note: Please make sure to update the "Email" variable which is located in the src/test/resources/configs/configuration.properties file if you want to run tests multiple times.
Note: This project support only Chrome and Gecko browsers. By default it uses Chrome browser, 
however if you want to run tests in Firefox browser you will need to change "browser" variable which is located in src/test/resources/configs/configuration.properties file.


1. Run from PowerShell / Terminal

Steps:

1. mvn clean
2. mvn test



2. Run from pom.xml file

Steps:

1. Open the pom.xml file 
2. Right mouse click anywhere in the file.
3. Click on "Run as"
4. Select "Maven test"

-- Challenges I faced during this project --

1. I had to use implicit and explicit waits for the driver because the application was not stable.
2. When I tried to select a value by visible text from the dropdown I was not able to do it. I solved that problem by selecting by its index.

-- Why I chose to use Cucumber Framework --

1. Cucumber supports different languages like Java and Ruby. 
2. Cucumber also acts as a bridge between the business and technical language. We can accomplish this by creating a test case in plain English text. 
It allows the test script to be written without knowledge of any code, it also allows the involvement of non-programmers as well. 
3. It serves the purpose of an end-to-end test framework, unlike other tools. Due to simple test script architecture.
4. Cucumber provides code reusability.
5. If needed I can also run data-driven tests using the Cucumber's "Example table" and even get data from an excel sheet.
