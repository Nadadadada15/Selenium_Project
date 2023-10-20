# Selenium_Project

This README provides a thorough description of an automated testing project using Selenium and TestNG. 
Selenium is a popular open-source framework for automating web applications, and TestNG is a testing framework 
designed to simplify test management and parallel test execution. 
This project aims to demonstrate creatation and execution of automated UI tests for web applications using POM.


# Here's a description of the project structure:

pom.xml: This Maven project file defines project dependencies, plugins, and build configurations.

We used:
Java Development Kit (JDK)
Maven
TestNG
WebDriver compatible with your preferred browser (Chrome, Firefox, etc.)


Pages: This directory contains page object classes for different web pages. 
Each page object class represents a specific web page or component and encapsulates the interactions and locators related to that page.

-CitiesPage.java
-NavPage.java
-LoginPage.java
-SignUpPage.java
-MessagesPopUpPage.java


Tests: This directory contains all test classes, organized by page's features. Each test class contains test methods related to a specific feature or functionality.

AdminCitiesTests.java: Test class for testing admin-related functionalities related to cities.
AuthRoutesTests.java: Test class for testing authentication routes.
LocaleTests.java: Test class for testing localization and locale-related functionality.
LoginTests.java: Test class for login-related test cases.
SignUpTests.java: Test class for sign-up-related test cases.



This project also incorporates "help" logic in the form of specific classes and methods.

BasicTests.java: Test class that includes common test setup and teardown logic.
BasicPageTests.java: Basic test class that focuses on generic page interactions that are not feature-specific.
RetryAnalyzer.java: Class  which will automatically retry the failed test.
helper.java: Class which will automatically generate screenshots for the faild tests.






 
