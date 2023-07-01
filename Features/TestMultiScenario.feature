Feature: Multiple Scenario Testing with each file

  Scenario Outline: First Scenario
    Given Need open one browser
    When Launch the application "<browser_URL>"
    And Navigate to the next page
    And click the page link with proper system
    Then close the browser
    
 Examples:
 |browser_URL|
 |https://enps.nsdl.com/|
 |https://www.onlinesbi.sbi/|
 
  
