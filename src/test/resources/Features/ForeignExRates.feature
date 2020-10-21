Feature: Foreign currency exchange rates api with currency conversion

  Scenario: Checking status code
    Given Rates API for Latest Foreign Exchange rates
    When  The API is available
    Then  Validate the code
    
  Scenario: Checking response
    Given Rates API for Latest Foreign Exchange rates
    When  The API is available
    Then  Validate the response
    
  Scenario: Checking error response
    Given Rates API for Latest Foreign Exchange rates
    When  An incorrect or incomplete url is provided
    Then  Validate the correct response
    
  

 