Feature: Login Functionality

Scenario: Valid Login
	Given I navigated to HRM website
	When I enter a valid username
	And I enter a valid password
	And I click on the login button
	Then I validate that I am logged in
	And I will quit the browser 
	
	Scenario: Invalid Password
	Given I navigated to HRM website
	When I enter a valid username
	And I enter an invalid password
	And I click on the login button
	Then I validate that Invalid Credentials
	And I will quit the browser