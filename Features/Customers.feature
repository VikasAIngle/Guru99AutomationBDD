Feature: Features related to Customer

Scenario: Add new Customer
		Given User Launch Chrome browser
    When User opens URL "https://demo.guru99.com/v4/index.php"
    And User Enters username as "mngr403565" and Password as "Pass@123"
    And Click on Login
    Then User can view Dashboard
		When User click on New Customer menu
		Then User can view Add new customer page
		When User enter customer info
		And click on Submit button
		Then User can view customer info with its customer id
		And Close the Browser
































