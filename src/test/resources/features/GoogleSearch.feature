Feature: Searching in Google

Scenario: Search by typing
	Given I navigated to Google
	When I type something on the search box
	And I click on the search button
	Then I can see the results of my search
	And I can count the number of the results
	
	Scenario: Search by voice
	Given I navigated to Google
	When I say what I want to search
	Then I can see the results of my search
	And I can count the number of the results