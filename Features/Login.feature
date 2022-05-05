Feature: Login in Guru99V4 Application

  Scenario: Testing Login functionalty with valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://demo.guru99.com/v4/index.php"
    And User Enters username as "mngr403565" and Password as "Pass@123"
    And Click on Login
    Then Page Title should be "Guru99 Bank Manager HomePage"
    When User Click on Log out link
    Then Page Title should be "Guru99 Bank Home Page"
    And Close the Browser
