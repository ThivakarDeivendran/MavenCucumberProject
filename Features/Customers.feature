Feature: Customers

  Scenario: Add new Customer
    Given User launch the Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then User view the Dashboard
    When User click on Customers Menu
    And Click on Customer Menu Item
    And Click on Add new button
    Then User can view Add new Customer page
    When User enters customer info
    And click on save button
    Then User can view Confirmation message "The new customer has been added successfully."
    And close browser

  Scenario: Search Customer by EMailID
    Given User launch the Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then User view the Dashboard
    When User click on Customers Menu
    And Click on Customer Menu Item
    And Enter customer EMail as "kiyjcycyhjc676008@gmail.com"
    When Click the search button
    Then User should found Email in the search table
    And close browser
