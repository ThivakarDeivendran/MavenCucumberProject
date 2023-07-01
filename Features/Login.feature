Feature: Login

Scenario Outline: Successful login with valid credentials
Given User launch the Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<columnA>" and Password as "<columnB>"
And Click on login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on log out link
Then Page Title should be "Your store. Login"
And close browser
Examples:
|columnA            |columnB      |
|admin@yourstore.com|admin        |
|xyz@gmail.com      |login        |